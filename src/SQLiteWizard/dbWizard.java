/*
 * Payday 2 Loadout Database Wizard Developed by Michael Rosenberg
 * http://mikerosenberger.com/blog || http://github.com/miker525
 * Developed for CS350 Final Project
 * Licensed Under GPLv3.0 - http://gnu.org/licenses/gpl-3.0.txt
 */
package SQLiteWizard;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import java.sql.*;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JCheckBox;

@SuppressWarnings("serial")
public class dbWizard extends JFrame {

	private JPanel contentPane;
	public static JTextField nameText;
	public static DefaultListModel<String> dlm =  new DefaultListModel<String>(), dlm2 = new DefaultListModel<String>();
	public static JList<String> list, list_1;
	public static int selectedID = 0;
	public static JCheckBox chckbxPrimary;
	public static JTextField magField, ammoField, wepDmgField, accuField, stabField, wepConField, threatField, armorField, speedField, armorConField, dodgeField, steadField, textField_1;
	public static int ids = 0;

	public static void main(String[] args)
	{
		try 
		{
			dbWizard frame = new dbWizard();
			initialize();
			frame.setVisible(true);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	}

	public dbWizard() {
		setResizable(false);
		setTitle("dbWizard");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 290);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		list = new JList<String>(dlm);
		list.setBounds(10, 21, 170, 80);
		list.addMouseListener(new java.awt.event.MouseAdapter()
		{
            public void mouseClicked(java.awt.event.MouseEvent mouseEvent)
            {
            	dlm2.clear();
            	clearFields();
            	ids = 0;
            	if(list.getSelectedValue() == "Armor")
            	{
            		try
       	    	 	{
            		 Connection c = null;
       	    		 Statement stmt = null;
       	    		 Class.forName("org.sqlite.JDBC");
       	    	     c = DriverManager.getConnection("jdbc:sqlite:payday.db");
       	    	     c.setAutoCommit(false);
       	    	     stmt = c.createStatement();
       	    	     ResultSet rs = stmt.executeQuery( "SELECT * FROM ARMOR;" );
       	    	     while ( rs.next() ) 
       	    	     {
       	    	         String  name = rs.getString("name");
       	    	         dlm2.addElement(name);
       	    	         ids++;
       	    	      }
       	    	    rs = stmt.executeQuery( "SELECT * FROM WEAPON;" );
       	    	  	while ( rs.next() ) 
   	    	    	{
       	    	  		ids++;
   	    	    	}
       	    	      rs.close();
       	    	      stmt.close();
       	    	      c.close();
       	    	 	}
       	    	 	catch (Exception e)
       	    	 	{
       	    		  System.err.println( e.getClass().getName() + ": " + e.getMessage() );
       	    		  System.exit(0);
       	    	 	}
            	}
            	else if (list.getSelectedValue() == "Weapons")
            	{
            		try
       	    	 	{
            			Connection c = null;
          	    		 Statement stmt = null;
          	    		 Class.forName("org.sqlite.JDBC");
          	    	     c = DriverManager.getConnection("jdbc:sqlite:payday.db");
          	    	     c.setAutoCommit(false);
          	    	     stmt = c.createStatement();
          	    	     ResultSet rs = stmt.executeQuery( "SELECT * FROM WEAPON;" );
          	    	     while ( rs.next() ) 
          	    	     {
          	    	         String  name = rs.getString("name");
          	    	         dlm2.addElement(name);
          	    	         ids++;
          	    	      }
          	    	     rs = stmt.executeQuery( "SELECT * FROM ARMOR;" );
         	    	     while ( rs.next() ) 
         	    	     {
         	    	    	 ids++;
         	    	     }
          	    	      rs.close();
          	    	      stmt.close();
          	    	      c.close();
       	    	 	}
       	    	 	catch (Exception e)
       	    	 	{
       	    		  System.err.println( e.getClass().getName() + ": " + e.getMessage() );
       	    		  System.exit(0);
       	    	 	}
            	}
            	 
            }
         });
		contentPane.add(list);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 107, 170, 122);
		list_1 = new JList<String>(dlm2);
		list_1.setBounds(10, 107, 170, 122);
		scrollPane.setViewportView(list_1);
		list_1.addMouseListener(new java.awt.event.MouseAdapter()
		{
            public void mouseClicked(java.awt.event.MouseEvent mouseEvent)
            {
            	if (list.getSelectedValue() == "Weapons")
            	{
            		clearFields();
            		try
       	    	 	{
            			Connection c = null;
          	    		 Statement stmt = null;
          	    		 Class.forName("org.sqlite.JDBC");
          	    	     c = DriverManager.getConnection("jdbc:sqlite:payday.db");
          	    	     c.setAutoCommit(false);
          	    	     stmt = c.createStatement();
          	    	     ResultSet rs = stmt.executeQuery( "SELECT * FROM WEAPON WHERE name='" + list_1.getSelectedValue() +"';" );
          	    	     while ( rs.next() ) 
          	    	     {
          	    	         int id = rs.getInt("id");
          	    	         String  name = rs.getString("name");
          	    	         boolean primary  = rs.getBoolean("prime");
          	    	         int  magazine = rs.getInt("mag");
          	    	         int  ammo = rs.getInt("ammo");
          	    	         int  damage = rs.getInt("dmg");
          	    	         int  accuracy = rs.getInt("accu");
          	    	         int  stability = rs.getInt("stab");
          	    	         int  concealment = rs.getInt("con");
          	    	         int  threat = rs.getInt("threat");
          	    	         selectedID = id;
          	    	         nameText.setText(name);
          	    	         magField.setText(""+magazine);
          	    	         ammoField.setText(""+ammo);
          	    	         wepDmgField.setText(""+damage);
          	    	         accuField.setText(""+accuracy);
          	    	         stabField.setText(""+stability);
          	    	         wepConField.setText(""+concealment);
          	    	         threatField.setText(""+threat);
          	    	         if(primary)
          	    	         {
          	    	        	chckbxPrimary.setSelected(true);
          	    	         }
          	    	         else
          	    	         {
          	    	        	chckbxPrimary.setSelected(false);
          	    	         }
          	    	     }
          	    	     rs.close();
          	    	     stmt.close();
          	    	     c.close();
       	    	 	}
       	    	 	catch (Exception e)
       	    	 	{
       	    		  System.err.println( e.getClass().getName() + ": " + e.getMessage() );
       	    		  System.exit(0);
       	    	 	}
            	}
            	else if (list.getSelectedValue() == "Armor")
            	{
            		clearFields();
            		try
       	    	 	{
            			Connection c = null;
          	    		 Statement stmt = null;
          	    		 Class.forName("org.sqlite.JDBC");
          	    	     c = DriverManager.getConnection("jdbc:sqlite:payday.db");
          	    	     c.setAutoCommit(false);
          	    	     stmt = c.createStatement();
          	    	     ResultSet rs = stmt.executeQuery( "SELECT * FROM ARMOR WHERE name='" + list_1.getSelectedValue() +"';" );
          	    	     while ( rs.next() ) 
          	    	     {
          	    	          int id = rs.getInt("id");
          	    	          String  name = rs.getString("name");
          	    	          int  armor  = rs.getInt("armo");
          	    	       	  int  concealment = rs.getInt("conc");
          	    	       	  int  speed = rs.getInt("sped");
          	    	       	  int  dodge = rs.getInt("dodg");
          	    	       	  int  steadiness = rs.getInt("sted");
          	    	       	  int  stamina = rs.getInt("stam");
          	    	          selectedID = id;
          	    	          nameText.setText(name);
          	    	          armorField.setText(""+armor);
          	    	          armorConField.setText(""+concealment);
          	    	          speedField.setText(""+speed);
          	    	          dodgeField.setText(""+dodge);
          	    	          steadField.setText(""+steadiness);
          	    	          textField_1.setText(""+stamina);
          	    	     }
          	    	     rs.close();
          	    	     stmt.close();
          	    	     c.close();
       	    	 	}
       	    	 	catch (Exception e)
       	    	 	{
       	    		  System.err.println( e.getClass().getName() + ": " + e.getMessage() );
       	    		  System.exit(0);
       	    	 	}
            	}
            }
		});
		contentPane.add(scrollPane);
		
		
		JButton btnAdd = new JButton("+");
		btnAdd.setBounds(10, 235, 71, 23);
		btnAdd.addActionListener(new dbActions());
		btnAdd.setActionCommand("add");
		contentPane.add(btnAdd);
		
		JButton button = new JButton("-");
		button.setBounds(109, 235, 71, 23);
		button.addActionListener(new dbActions());
		button.setActionCommand("minus");
		contentPane.add(button);
		
		nameText = new JTextField();
		nameText.setBounds(231, 11, 203, 20);
		contentPane.add(nameText);
		nameText.setColumns(10);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblName.setBounds(200, 14, 46, 14);
		contentPane.add(lblName);
		
		chckbxPrimary = new JCheckBox("Primary?");
		chckbxPrimary.setFont(new Font("Tahoma", Font.PLAIN, 10));
		chckbxPrimary.setBounds(211, 61, 97, 23);
		contentPane.add(chckbxPrimary);
		
		JLabel lblWeapons = new JLabel("Weapons");
		lblWeapons.setBounds(219, 40, 60, 14);
		contentPane.add(lblWeapons);
		
		JLabel lblArmor = new JLabel("Armor");
		lblArmor.setBounds(376, 40, 46, 14);
		contentPane.add(lblArmor);
		
		JLabel lblMag = new JLabel("Mag");
		lblMag.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblMag.setBounds(201, 91, 46, 14);
		contentPane.add(lblMag);
		
		magField = new JTextField();
		magField.setBounds(226, 89, 71, 20);
		contentPane.add(magField);
		magField.setColumns(10);
		
		JLabel lblAmmo = new JLabel("Ammo");
		lblAmmo.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblAmmo.setBounds(195, 116, 46, 14);
		contentPane.add(lblAmmo);
		
		ammoField = new JTextField();
		ammoField.setBounds(226, 113, 71, 20);
		contentPane.add(ammoField);
		ammoField.setColumns(10);
		
		JLabel lblDmg = new JLabel("Dmg");
		lblDmg.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblDmg.setBounds(201, 141, 46, 14);
		contentPane.add(lblDmg);
		
		wepDmgField = new JTextField();
		wepDmgField.setBounds(226, 138, 71, 20);
		contentPane.add(wepDmgField);
		wepDmgField.setColumns(10);
		
		JLabel lblAccu = new JLabel("Accu");
		lblAccu.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblAccu.setBounds(201, 164, 36, 14);
		contentPane.add(lblAccu);
		
		accuField = new JTextField();
		accuField.setBounds(226, 161, 71, 20);
		contentPane.add(accuField);
		accuField.setColumns(10);
		
		JLabel lblStab = new JLabel("Stab");
		lblStab.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblStab.setBounds(201, 189, 46, 14);
		contentPane.add(lblStab);
		
		stabField = new JTextField();
		stabField.setBounds(226, 184, 71, 20);
		contentPane.add(stabField);
		stabField.setColumns(10);
		
		JLabel lblCon = new JLabel("Con");
		lblCon.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblCon.setBounds(201, 210, 46, 14);
		contentPane.add(lblCon);
		
		wepConField = new JTextField();
		wepConField.setBounds(226, 207, 71, 20);
		contentPane.add(wepConField);
		wepConField.setColumns(10);
		
		JLabel lblThreat = new JLabel("Threat");
		lblThreat.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblThreat.setBounds(194, 232, 46, 14);
		contentPane.add(lblThreat);
		
		threatField = new JTextField();
		threatField.setBounds(226, 230, 71, 20);
		contentPane.add(threatField);
		threatField.setColumns(10);
		
		JLabel lblArmor_1 = new JLabel("Armor");
		lblArmor_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblArmor_1.setBounds(327, 65, 46, 14);
		contentPane.add(lblArmor_1);
		
		armorField = new JTextField();
		armorField.setBounds(363, 62, 71, 20);
		contentPane.add(armorField);
		armorField.setColumns(10);
		
		JLabel lblSpeed = new JLabel("Speed");
		lblSpeed.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblSpeed.setBounds(327, 87, 46, 14);
		contentPane.add(lblSpeed);
		
		speedField = new JTextField();
		speedField.setBounds(363, 88, 71, 20);
		contentPane.add(speedField);
		speedField.setColumns(10);
		
		JLabel lblCon_1 = new JLabel("Con");
		lblCon_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblCon_1.setBounds(327, 115, 46, 14);
		contentPane.add(lblCon_1);
		
		armorConField = new JTextField();
		armorConField.setBounds(363, 113, 71, 20);
		contentPane.add(armorConField);
		armorConField.setColumns(10);
		
		JLabel lblDodge = new JLabel("Dodge");
		lblDodge.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblDodge.setBounds(327, 141, 46, 14);
		contentPane.add(lblDodge);
		
		dodgeField = new JTextField();
		dodgeField.setBounds(363, 138, 71, 20);
		contentPane.add(dodgeField);
		dodgeField.setColumns(10);
		
		JLabel lblStead = new JLabel("Stead");
		lblStead.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblStead.setBounds(327, 164, 46, 14);
		contentPane.add(lblStead);
		
		steadField = new JTextField();
		steadField.setBounds(363, 161, 71, 20);
		contentPane.add(steadField);
		steadField.setColumns(10);
		
		JLabel lblStam = new JLabel("Stam");
		lblStam.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblStam.setBounds(327, 189, 46, 14);
		contentPane.add(lblStam);
		
		textField_1 = new JTextField();
		textField_1.setBounds(363, 186, 71, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setBounds(333, 225, 89, 23);
		btnEdit.addActionListener(new dbActions());
		btnEdit.setActionCommand("edit");
		contentPane.add(btnEdit);
	}
	
	public static void initialize()
	{
		 dlm.addElement("Weapons");
		 dlm.addElement("Armor");
	}
	
	public static void clearFields()
	{
		magField.setText(""); ammoField.setText(""); wepDmgField.setText(""); accuField.setText(""); stabField.setText(""); wepConField.setText(""); threatField.setText(""); armorField.setText(""); speedField.setText(""); armorConField.setText(""); dodgeField.setText(""); steadField.setText(""); textField_1.setText(""); nameText.setText("");chckbxPrimary.setSelected(false);;
	}
	
}
