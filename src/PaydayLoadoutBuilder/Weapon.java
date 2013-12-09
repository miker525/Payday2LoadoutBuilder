/*
 * Payday 2 Loadout Builder Developed by Michael Rosenberg
 * http://mikerosenberger.com/blog || http://github.com/miker525
 * Developed for CS350 Final Project
 * Licensed Under GPLv3.0 - http://gnu.org/licenses/gpl-3.0.txt
 */


package PaydayLoadoutBuilder;
//This Class sets up and defines what a Weapon is and what information it can store.
public class Weapon 
{
	private String weaponName;
	private int ID,MAG,AMMO,DMG,ACCU,STAB,CON,THREAT;
	private boolean Primary = true;
	
	public Weapon(){}
	
	public Weapon(String name){this.weaponName = name;}
	
	public Weapon(int id){this.ID = id;}	
	
	public Weapon(String name, boolean prime, int id, int mag, int ammo, int dmg, int accu, int stab, int con, int threat)
	{this.weaponName = name;this.Primary = prime;this.ID = id;this.MAG = mag;this.AMMO = ammo;this.DMG=dmg;
	 this.ACCU = accu;this.STAB = stab;this.CON = con;this.THREAT = threat;}
	
	public int getID()
	{
		return this.ID;
	}

	public int getMagazineSize()
	{
		return this.MAG;
	}
	
	public int getAmmo()
	{
		return this.AMMO;
	}
	
	public int getDamage()
	{
		return this.DMG;
	}
	
	public int getAccuracy()
	{
		return this.ACCU;
	}
	
	public int getStability()
	{
		return this.STAB;
	}
	
	public int getConcealment()
	{
		return this.CON;
	}
	
	public int getThreat()
	{
		return this.THREAT;
	}
	
	public boolean isPrimary()
	{
		return this.Primary;
	}
	
	public String getWeaponName()
	{
		return this.weaponName;
	}
	
	public void setWeaponName(String name)
	{
		this.weaponName = name;
	}
	
	public void setID(int id)
	{
		this.ID = id;
	}
	
	public void setPrimary(boolean prime)
	{
		this.Primary = prime;
	}
	
	public void setMagazineSize(int mag)
	{
		this.MAG = mag;
	}
	
	public void setAmmo(int ammo)
	{
		this.AMMO = ammo;
	}
	
	public void setDamage(int dmg)
	{
		this.DMG = dmg;
	}
	
	public void setConcealment(int con)
	{
		this.CON = con;
	}
	
	public void setStability(int stab)
	{
		this.STAB = stab;
	}
	
	public void setAccuracy(int accu)
	{
		this.ACCU = accu;
	}
	
	public void setThreat(int threat)
	{
		this.THREAT = threat;
	}
}
