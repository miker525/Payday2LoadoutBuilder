/*
 * Payday 2 Loadout Builder Developed by Michael Rosenberg
 * http://mikerosenberger.com/blog || http://github.com/miker525
 * Developed for CS350 Final Project
 * Licensed Under GPLv3.0 - http://gnu.org/licenses/gpl-3.0.txt
 */
package PaydayLoadoutBuilder;

import javax.swing.*;
import javax.swing.border.*;
import java.sql.*;
import java.awt.Font;
import java.util.ArrayList;


@SuppressWarnings("serial")
public class Wnd extends JFrame {

	private JPanel contentPane;
	public static JTextField txtSuggestedPrimaryWeapon, txtSuggestedSecondaryWeapon, txtSuggestedArmor;
	public static JComboBox<String> comboBox, comboBox_1, comboBox_2, comboBox_3;
	private static JButton btnBuildLoadout;
	public static ArrayList<Weapon> wlist = new ArrayList<Weapon>(), wslist = new ArrayList<Weapon>();
	public static ArrayList<Armor> alist = new ArrayList<Armor>();
	
	
	public static void main(String[] args) 
	{
		try 
		{
			Wnd frame = new Wnd();
			FillCombox();
			getWeapons();
			getArmors();
			printWeapons();
			printArmors();
			frame.setVisible(true);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	//Sets up JFrame
	//Adds all action listeners to the ActionSys class
	public Wnd() {
		setTitle("Payday 2 Loadout Builder");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 464, 246);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		comboBox = new JComboBox<String>();
		comboBox.setBounds(84, 85, 357, 20);
		contentPane.add(comboBox);
		
		JLabel lblPlayStyle = new JLabel("Play Style:");
		lblPlayStyle.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblPlayStyle.setBounds(25, 88, 69, 14);
		contentPane.add(lblPlayStyle);
		
		JLabel lblArmorPreference = new JLabel("Armor Preference:");
		lblArmorPreference.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblArmorPreference.setBounds(10, 11, 99, 14);
		contentPane.add(lblArmorPreference);
		
		comboBox_1 = new JComboBox<String>();
		comboBox_1.setBounds(10, 29, 99, 20);
		contentPane.add(comboBox_1);
		
		JLabel lblPrimary = new JLabel("Primary Weapon Preference:");
		lblPrimary.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblPrimary.setBounds(131, 10, 150, 14);
		contentPane.add(lblPrimary);
		
		comboBox_2 = new JComboBox<String>();
		comboBox_2.setBounds(130, 29, 139, 20);
		contentPane.add(comboBox_2);
		
		JLabel lblSecondaryWeaponPreference = new JLabel("Secondary Weapon Preference:");
		lblSecondaryWeaponPreference.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblSecondaryWeaponPreference.setBounds(291, 11, 187, 14);
		contentPane.add(lblSecondaryWeaponPreference);
		
		comboBox_3 = new JComboBox<String>();
		comboBox_3.setBounds(289, 29, 152, 20);
		contentPane.add(comboBox_3);
		
		JLabel lblOr = new JLabel("OR");
		lblOr.setBounds(216, 60, 25, 14);
		contentPane.add(lblOr);
		
		txtSuggestedPrimaryWeapon = new JTextField();
		txtSuggestedPrimaryWeapon.setText("Suggested Primary Weapon");
		txtSuggestedPrimaryWeapon.setEditable(false);
		txtSuggestedPrimaryWeapon.setBounds(10, 150, 205, 20);
		contentPane.add(txtSuggestedPrimaryWeapon);
		txtSuggestedPrimaryWeapon.setColumns(10);
		
		txtSuggestedSecondaryWeapon = new JTextField();
		txtSuggestedSecondaryWeapon.setEditable(false);
		txtSuggestedSecondaryWeapon.setText("Suggested Secondary Weapon");
		txtSuggestedSecondaryWeapon.setBounds(245, 150, 203, 20);
		contentPane.add(txtSuggestedSecondaryWeapon);
		txtSuggestedSecondaryWeapon.setColumns(10);
		
		txtSuggestedArmor = new JTextField();
		txtSuggestedArmor.setEditable(false);
		txtSuggestedArmor.setText("Suggested Armor");
		txtSuggestedArmor.setBounds(131, 181, 205, 20);
		contentPane.add(txtSuggestedArmor);
		txtSuggestedArmor.setColumns(10);
		
		btnBuildLoadout = new JButton("Build Loadout");
		btnBuildLoadout.setBounds(10, 116, 431, 23);
		btnBuildLoadout.addActionListener(new ActionSys());
		btnBuildLoadout.setActionCommand("btn");
		contentPane.add(btnBuildLoadout);
	}
	
	//Creates method to fill all the combo boxes with whatever options we would 
	//like to see in each box. Fills Armor, Primary, and Secondary weapons
	private static void FillCombox()
	{
		comboBox.addItem("None");
		comboBox.addItem("Stealth");
		comboBox.addItem("Shoot Out");
		comboBox_1.addItem("Light");
		comboBox_1.addItem("Medium");
		comboBox_1.addItem("Heavy");
		comboBox_2.addItem("High Ammo");
		comboBox_2.addItem("High Damage");
		comboBox_2.addItem("High Accuracy");
		comboBox_2.addItem("High Concealment");
		comboBox_2.addItem("High Threat");
		comboBox_3.addItem("High Damage");
		comboBox_3.addItem("High Concealment");
		comboBox_3.addItem("High Threat");
	}
	
	//This connects to our SQLite db and pulls all of our weapons out. It stores the Weapons
	//in two separate Weapon Array Lists, one for Primary and one for Secondary
	private static void getWeapons()
	{
		try
		{
			Connection c = null;
   		 	Statement stmt = null;
   		 	Class.forName("org.sqlite.JDBC");
   		 	c = DriverManager.getConnection("jdbc:sqlite:payday.db");
   		 	c.setAutoCommit(false);
   		 	System.out.println("Opened database successfully");

   		 	stmt = c.createStatement();
   		 	ResultSet rs = stmt.executeQuery( "SELECT * FROM WEAPON;" );
   		 	while ( rs.next() ) 
   		 	{
   		 		Weapon w = new Weapon(rs.getString("name"), rs.getBoolean("prime"), rs.getInt("id"), rs.getInt("mag"), rs.getInt("ammo"), rs.getInt("dmg"), rs.getInt("accu"), rs.getInt("stab"), rs.getInt("con"), rs.getInt("threat"));
   		 		int id = rs.getInt("id");
   		 		String  name = rs.getString("name");
   		 		boolean primary  = rs.getBoolean("prime");
   		 		int  magazine = rs.getInt("mag");
   		 		int  ammo = rs.getInt("ammo");
   		 		int  damage = rs.getInt("dmg");
   		 		int  accuracy = rs.getInt("accu");
   		 		int  stability = rs.getInt("stab");
   		 		int  concealment = rs.getInt("con");
   		 		int threat = rs.getInt("threat");
   		 		System.out.println( "ID = " + id );
   		 		System.out.println( "NAME = " + name );
   		 		System.out.println( "Primary = " + primary );
   		 		System.out.println( "Magazine = " + magazine );
   		 		System.out.println( "Ammo = " + ammo );
   		 		System.out.println( "Damage = " + damage );
   		 		System.out.println( "Accuracy = " + accuracy );
   		 		System.out.println( "Stability = " + stability );
   		 		System.out.println( "Concealment = " + concealment );
   		 		System.out.println( "Threat = " + threat );
   		 		System.out.println();
   		 		if (w.isPrimary())
   		 		{
   		 			wlist.add(w);
   		 		}
   		 		else if (!w.isPrimary())
   		 		{
   		 			wslist.add(w);
   		 		}
   		 	}
   		 	rs.close();
   		 	stmt.close();
   		 	c.close();
   		 	System.out.println("Read Weapons from DB to List");
		}
		catch (Exception e)
		{
			System.out.println(e + e.getMessage());
		}
	}
	
	//This method connects to our SQLite db and pulls all our Armors out into an Armor
	//Array List.
	private static void getArmors()
	{
		try
		{
			Connection c = null;
   		 	Statement stmt = null;
   		 	Class.forName("org.sqlite.JDBC");
   		 	c = DriverManager.getConnection("jdbc:sqlite:payday.db");
   		 	c.setAutoCommit(false);
   		 	System.out.println("Opened database successfully");
   		 	stmt = c.createStatement();
   		 	ResultSet rs = stmt.executeQuery( "SELECT * FROM ARMOR;" );
   		 	while ( rs.next() ) 
   		 	{
   		 		Armor arm = new Armor(rs.getString("name"), rs.getInt("id"), rs.getInt("armo"), rs.getInt("conc"), rs.getInt("sped"), rs.getInt("dodg"), rs.getInt("sted"), rs.getInt("stam"));
   		 		int id = rs.getInt("id");
   		 		String  name = rs.getString("name");
   		 		int  armor  = rs.getInt("armo");
   		 		int  concealment = rs.getInt("conc");
   		 		int  speed = rs.getInt("sped");
   		 		int  dodge = rs.getInt("dodg");
   		 		int  steadiness = rs.getInt("sted");
   		 		int  stamina = rs.getInt("stam");
   		 		System.out.println( "ID = " + id );
   		 		System.out.println( "NAME = " + name );
   		 		System.out.println( "ARMOR = " + armor );
   		 		System.out.println( "CONCEALMENT = " + concealment );
   		 		System.out.println( "SPEED = " + speed );
   		 		System.out.println( "DODGE = " + dodge );
   		 		System.out.println( "STEADINESS = " + steadiness );
   		 		System.out.println( "STAMINA = " + stamina );
   		 		System.out.println();
   		 		alist.add(arm);
   		 	}
   		 	rs.close();
   		 	stmt.close();
   		 	c.close();
   		 	System.out.println("Read Armors from DB to List");
		}
		catch (Exception e)
		{
			System.out.println(e + e.getMessage());
		}
	}
	
	//This method will go through our Primary and Secondary Weapons lists and print out
	//our primary weapons followed by our secondary weapons.
	private static void printWeapons()
	{
		System.out.println("\nPrimary Weapons");
		for (Weapon w: wlist)
		{
			System.out.println(w.getWeaponName());
		}
		System.out.println("\nSecondary Weapons");
		for (Weapon w: wslist)
		{
			System.out.println(w.getWeaponName());
		}
	}
	
	//This method will go through and print out all of our Armors
	private static void printArmors()
	{
		System.out.println("\nArmors");
		for (Armor a: alist)
		{
			System.out.println(a.getName());
		}
	}


}
