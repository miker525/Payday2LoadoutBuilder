/*
 * Payday 2 Loadout Database Wizard Developed by Michael Rosenberg
 * http://mikerosenberger.com/blog || http://github.com/miker525
 * Developed for CS350 Final Project
 * Licensed Under GPLv3.0 - http://gnu.org/licenses/gpl-3.0.txt
 */
package SQLiteWizard;

import java.awt.event.ActionListener;
import java.sql.*;



public class dbActions implements ActionListener
{
	public dbActions() {}
	
	public void actionPerformed(java.awt.event.ActionEvent ae) 
	{
		if (ae.getActionCommand().equals("add"))
		{
			if (dbWizard.list.getSelectedValue() == "Weapons")
			{
				try
				{
					Connection c = null;
		    		Statement stmt = null;
		    		Class.forName("org.sqlite.JDBC");
		    	    c = DriverManager.getConnection("jdbc:sqlite:payday.db");
		    	    c.setAutoCommit(false);
		    	    stmt = c.createStatement();
		    	    int p = (dbWizard.chckbxPrimary.isSelected()) ? 1 : 0;
		    	    String sql = "INSERT INTO WEAPON (ID,NAME,PRIME,MAG,AMMO,DMG,ACCU,STAB,CON,THREAT) " +
	    	                   "VALUES ("
		    	    		+dbWizard.ids+1+", '"
		    	    		+dbWizard.nameText.getText()+"', "
		    	    		+p+", "
		    	    		+dbWizard.magField.getText()+", "
		    	    		+dbWizard.ammoField.getText()+", "
		    	    		+dbWizard.wepDmgField.getText()+", "
		    	    		+dbWizard.accuField.getText()+", "
		    	    		+dbWizard.stabField.getText()+", "
		    	    		+dbWizard.wepConField.getText()+", "
		    	    		+dbWizard.threatField.getText()+");";
		    	    stmt.executeUpdate(sql);
		    	    stmt.close();
					c.commit();
	                c.close();
					System.out.println("Weapon Added Successfully");
					refreshLists();
				}
				catch (Exception e)
				{
					System.out.println(e.getMessage());
				}
			}
			else if (dbWizard.list.getSelectedValue() == "Armor")
			{
				try
				{
					Connection c = null;
		    		Statement stmt = null;
		    		Class.forName("org.sqlite.JDBC");
		    	    c = DriverManager.getConnection("jdbc:sqlite:payday.db");
		    	    c.setAutoCommit(false);
		    	    stmt = c.createStatement();
		    	    String sql = "INSERT INTO ARMOR (ID,NAME,ARMO,CONC,SPED,DODG,STED,STAM) " +
	    	                   "VALUES ("
		    	    		+dbWizard.ids+1+", '"
		    	    		+dbWizard.nameText.getText()+"', "
		    	    		+dbWizard.armorField.getText()+", "
		    	    		+dbWizard.armorConField.getText()+", "
		    	    		+dbWizard.speedField.getText()+", "
		    	    		+dbWizard.dodgeField.getText()+", "
		    	    		+dbWizard.steadField.getText()+", "
		    	    		+dbWizard.textField_1.getText()+");";
		    	    stmt.executeUpdate(sql);
		    	    stmt.close();
					c.commit();
	                c.close();
					System.out.println("Armor Added Successfully");
					refreshLists();
				}
				catch (Exception e)
				{
					System.out.println(e.getMessage());
				}
			}
		}
		
		
		else if (ae.getActionCommand().equals("minus"))
		{
			 	Connection c = null;
			    Statement stmt = null;
			    try
			    {
			      Class.forName("org.sqlite.JDBC");
			      c = DriverManager.getConnection("jdbc:sqlite:payday.db");
			      c.setAutoCommit(false);
			      System.out.println("Opened database successfully");
			      stmt = c.createStatement();
			      String sql = "";
			      if (dbWizard.list.getSelectedValue() == "Weapons")
			      {
			    	  sql = "DELETE from WEAPON where id=" + dbWizard.selectedID + ";";
			      }
			      else if (dbWizard.list.getSelectedValue() == "Armor")
			      {
			    	  sql = "DELETE from ARMOR where id=" + dbWizard.selectedID + ";";
			      }
			      stmt.executeUpdate(sql);
			      c.commit();
			      stmt.close();
			      c.close();
			    } catch ( Exception e ) {
			      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			      System.exit(0);
			    }
			System.out.println("Removed Successfully");
			refreshLists();
		}
		
		
		else if (ae.getActionCommand().equals("edit"))
		{
			if (dbWizard.list.getSelectedValue() == "Weapons")
			{
				try
				{
					Connection c = null;
		    		Statement stmt = null;
		    		Class.forName("org.sqlite.JDBC");
		    	    c = DriverManager.getConnection("jdbc:sqlite:payday.db");
		    	    c.setAutoCommit(false);
		    	    stmt = c.createStatement();
		    	    int p = (dbWizard.chckbxPrimary.isSelected()) ? 1 : 0;
		    	    String sql = "UPDATE WEAPON set NAME = '"+dbWizard.nameText.getText()+
		    	    			 "', PRIME="+p+
		    	    			 ", MAG="+dbWizard.magField.getText()+
		    	    			 ", AMMO="+dbWizard.ammoField.getText()+
		    	    			 ", DMG="+dbWizard.wepDmgField.getText()+
		    	    			 ", ACCU="+dbWizard.accuField.getText()+
		    	    			 ", STAB="+dbWizard.stabField.getText()+
		    	    			 ", CON="+dbWizard.wepConField.getText()+
		    	    			 ", THREAT="+dbWizard.threatField.getText()+
		    	    			 " where ID=" + dbWizard.selectedID + ";";
		    	    stmt.executeUpdate(sql);
		    	    stmt.close();
					c.commit();
	                c.close();
					System.out.println("Weapon Edited Successfully");
					refreshLists();
				}
				catch (Exception e)
				{
					System.out.println(e.getMessage());
				}
			}
			else if (dbWizard.list.getSelectedValue() == "Armor")
			{
				try
				{
					Connection c = null;
		    		Statement stmt = null;
		    		Class.forName("org.sqlite.JDBC");
		    	    c = DriverManager.getConnection("jdbc:sqlite:payday.db");
		    	    c.setAutoCommit(false);
		    	    stmt = c.createStatement();
		    	    //(ID,NAME,ARMO,CONC,SPED,DODG,STED,STAM)
		    	    String sql = "UPDATE ARMOR set NAME = '"+dbWizard.nameText.getText()+
	    	    			 "', ARMO="+dbWizard.armorField.getText()+
	    	    			 ", CONC="+dbWizard.armorConField.getText()+
	    	    			 ", SPED="+dbWizard.speedField.getText()+
	    	    			 ", DODG="+dbWizard.dodgeField.getText()+
	    	    			 ", STED="+dbWizard.steadField.getText()+
	    	    			 ", STAM="+dbWizard.textField_1.getText()+
	    	    			 " where ID=" + dbWizard.selectedID + ";";
		    	    stmt.executeUpdate(sql);
		    	    stmt.close();
					c.commit();
	                c.close();
					System.out.println("Armor Edited Successfully");
					refreshLists();
				}
				catch (Exception e)
				{
					System.out.println(e.getMessage());
				}
			}
		}
	}
	
	
	public void refreshLists()
	{
		dbWizard.dlm2.clear();
		dbWizard.clearFields();
		dbWizard.ids = 0;
		if(dbWizard.list.getSelectedValue() == "Armor")
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
	    	         dbWizard.dlm2.addElement(name);
	    	         dbWizard.ids++;
	    	      }
	    	    rs = stmt.executeQuery( "SELECT * FROM WEAPON;" );
	    	  	while ( rs.next() ) 
   	    	{
	    	  		dbWizard.ids++;
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
    	else if (dbWizard.list.getSelectedValue() == "Weapons")
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
  	    	         dbWizard.dlm2.addElement(name);
  	    	         dbWizard.ids++;
  	    	      }
  	    	     rs = stmt.executeQuery( "SELECT * FROM ARMOR;" );
 	    	     while ( rs.next() ) 
 	    	     {
 	    	    	 dbWizard.ids++;
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
	
}
