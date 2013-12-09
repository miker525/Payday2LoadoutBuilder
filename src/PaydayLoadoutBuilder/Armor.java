/*
 * Payday 2 Loadout Builder Developed by Michael Rosenberg
 * http://mikerosenberger.com/blog || http://github.com/miker525
 * Developed for CS350 Final Project
 * Licensed Under GPLv3.0 - http://gnu.org/licenses/gpl-3.0.txt
 */
package PaydayLoadoutBuilder;
//This Class sets up and defines what an Armor is and what information it can store.
public class Armor 
{
	private String Name;
	private int ID,ARMOR,CONCEALMENT,SPEED,DODGE,STEADINESS,STAMINA;
	
	public Armor(){}
	
	public Armor(String name){this.Name = name;}
	
	public Armor(int id){this.ID = id;}	
	
	public Armor(String name, int id, int armor, int concealment, int speed, int dodge, int steadiness, int stamina)
	{this.Name = name;this.ID = id;this.ARMOR = armor;this.CONCEALMENT = concealment;this.SPEED = speed;
	 this.DODGE = dodge;this.STEADINESS = steadiness;this.STAMINA = stamina;}
	
	public int getID()
	{
		return this.ID;
	}
	
	public String getName()
	{
		return this.Name;
	}
	
	public int getArmorVal()
	{
		return this.ARMOR;
	}
	
	public int getConcealment()
	{
		return this.CONCEALMENT;
	}
	
	public int getSpeed()
	{
		return this.SPEED;
	}
	
	public int getDodge()
	{
		return this.DODGE;
	}
	
	public int getStamina()
	{
		return this.STAMINA;
	}
	
	public int getSteadiness()
	{
		return this.STEADINESS;
	}
	
	public void setName(String name)
	{
		this.Name = name;
	}
	
	public void setID(int id)
	{
		this.ID = id;
	}
	
	public void setConcealment(int conc)
	{
		this.CONCEALMENT = conc;
	}
	
	public void setArmorVal(int armor)
	{
		this.ARMOR = armor;
	}
	
	public void setSpeed(int speed)
	{
		this.SPEED = speed;
	}
	
	public void setDodge(int dodge)
	{
		this.DODGE = dodge;
	}
	
	public void setStamina(int stamina)
	{
		this.STAMINA = stamina;
	}
	
	public void setSteadiness(int steadiness)
	{
		this.STEADINESS = steadiness;
	}
}
