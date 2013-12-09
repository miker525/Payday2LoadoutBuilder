/*
 * Payday 2 Loadout Builder Developed by Michael Rosenberg
 * http://mikerosenberger.com/blog || http://github.com/miker525
 * Developed for CS350 Final Project
 * Licensed Under GPLv3.0 - http://gnu.org/licenses/gpl-3.0.txt
 */


package PaydayLoadoutBuilder;
//This Class is used to systematically find Armors and Weapons with the best, worst or mid
//point of whichever field you are specifically looking for. These methods are used to find
//what the user may be looking for or merged together with extra code to find the best gear 
//for a specific purpose (ex. best stealth setup, etc.)
import java.util.ArrayList;
import java.util.Collections;
import PaydayComparators.*;

public class ValReceiver 
{
	public static Armor getHighArmor(ArrayList<Armor> list)
	{
		Armor ax = new Armor();
		ArrayList<Armor> al = list;
		Collections.sort(al, new ArmorComparator());
		int c = al.size();
		ax = al.get(c-1);
		return ax;
	}
	public static Armor getLowArmor(ArrayList<Armor> list)
	{
		Armor ax = new Armor();
		ArrayList<Armor> al = list;
		Collections.sort(al, new ArmorComparator());
		ax = al.get(0);
		return ax;
	}
	public static Armor getMiddleArmor(ArrayList<Armor> list)
	{
		Armor ax = new Armor();
		ArrayList<Armor> al = list;
		Collections.sort(al, new ArmorComparator());
		int c = al.size();
		ax = al.get(c/2);
		return ax;
	}

	public static Armor getArmorHighConcealment(ArrayList<Armor> list)
	{
		Armor ax = new Armor();
		ArrayList<Armor> al = list;
		Collections.sort(al, new ArmorConcealmentComparator());
		int c = al.size();
		ax = al.get(c-1);
		return ax;
	}
	public static Armor getArmorLowConcealment(ArrayList<Armor> list)
	{
		Armor ax = new Armor();
		ArrayList<Armor> al = list;
		Collections.sort(al, new ArmorComparator());
		ax = al.get(0);
		return ax;
	}
	public static Armor getArmorMiddleConcealment(ArrayList<Armor> list)
	{
		Armor ax = new Armor();
		ArrayList<Armor> al = list;
		Collections.sort(al, new ArmorComparator());
		int c = al.size();
		ax = al.get(c/2);
		return ax;
	}
	
	public static Armor getArmorHighDodge(ArrayList<Armor> list)
	{
		Armor ax = new Armor();
		ArrayList<Armor> al = list;
		Collections.sort(al, new ArmorDodgeComparator());
		int c = al.size();
		ax = al.get(c-1);
		return ax;
	}
	public static Armor getArmorLowDodge(ArrayList<Armor> list)
	{
		Armor ax = new Armor();
		ArrayList<Armor> al = list;
		Collections.sort(al, new ArmorDodgeComparator());
		ax = al.get(0);
		return ax;
	}
	public static Armor getArmorMiddleDodge(ArrayList<Armor> list)
	{
		Armor ax = new Armor();
		ArrayList<Armor> al = list;
		Collections.sort(al, new ArmorDodgeComparator());
		int c = al.size();
		ax = al.get(c/2);
		return ax;
	}
	
	public static Armor getArmorHighSpeed(ArrayList<Armor> list)
	{
		Armor ax = new Armor();
		ArrayList<Armor> al = list;
		Collections.sort(al, new ArmorSpeedComparator());
		int c = al.size();
		ax = al.get(c-1);
		return ax;
	}
	public static Armor getArmorLowSpeed(ArrayList<Armor> list)
	{
		Armor ax = new Armor();
		ArrayList<Armor> al = list;
		Collections.sort(al, new ArmorSpeedComparator());
		ax = al.get(0);
		return ax;
	}
	public static Armor getArmorMiddleSpeed(ArrayList<Armor> list)
	{
		Armor ax = new Armor();
		ArrayList<Armor> al = list;
		Collections.sort(al, new ArmorSpeedComparator());
		int c = al.size();
		ax = al.get(c/2);
		return ax;
	}
	
	public static Armor getArmorHighStamina(ArrayList<Armor> list)
	{
		Armor ax = new Armor();
		ArrayList<Armor> al = list;
		Collections.sort(al, new ArmorStaminaComparator());
		int c = al.size();
		ax = al.get(c-1);
		return ax;
	}
	public static Armor getArmorLowStamina(ArrayList<Armor> list)
	{
		Armor ax = new Armor();
		ArrayList<Armor> al = list;
		Collections.sort(al, new ArmorStaminaComparator());
		ax = al.get(0);
		return ax;
	}
	public static Armor getArmorMiddleStamina(ArrayList<Armor> list)
	{
		Armor ax = new Armor();
		ArrayList<Armor> al = list;
		Collections.sort(al, new ArmorStaminaComparator());
		int c = al.size();
		ax = al.get(c/2);
		return ax;
	}
	
	public static Armor getArmorHighSteadiness(ArrayList<Armor> list)
	{
		Armor ax = new Armor();
		ArrayList<Armor> al = list;
		Collections.sort(al, new ArmorSteadinessComparator());
		int c = al.size();
		ax = al.get(c-1);
		return ax;
	}
	public static Armor getArmorLowSteadiness(ArrayList<Armor> list)
	{
		Armor ax = new Armor();
		ArrayList<Armor> al = list;
		Collections.sort(al, new ArmorSteadinessComparator());
		ax = al.get(0);
		return ax;
	}
	public static Armor getArmorMiddleSteadiness(ArrayList<Armor> list)
	{
		Armor ax = new Armor();
		ArrayList<Armor> al = list;
		Collections.sort(al, new ArmorSteadinessComparator());
		int c = al.size();
		ax = al.get(c/2);
		return ax;
	}
	
	public static Weapon getWeaponHighDamage(ArrayList<Weapon> list)
	{
		Weapon wx = new Weapon();
		ArrayList<Weapon> we = list;
		Collections.sort(we, new WeaponDamageComparator());
		int c = we.size();
		wx = we.get(c-1);
		return wx;
	}
	public static Weapon getWeaponLowDamage(ArrayList<Weapon> list)
	{
		Weapon wx = new Weapon();
		ArrayList<Weapon> we = list;
		Collections.sort(we, new WeaponDamageComparator());
		wx = we.get(0);
		return wx;
	}
	public static Weapon getWeaponMiddleDamage(ArrayList<Weapon> list)
	{
		Weapon wx = new Weapon();
		ArrayList<Weapon> we = list;
		Collections.sort(we, new WeaponDamageComparator());
		int c = we.size();
		wx = we.get(c/2);
		return wx;
	}
	
	public static Weapon getWeaponHighAmmo(ArrayList<Weapon> list)
	{
		Weapon wx = new Weapon();
		ArrayList<Weapon> we = list;
		Collections.sort(we, new WeaponAmmoComparator());
		int c = we.size();
		wx = we.get(c-1);
		return wx;
	}
	public static Weapon getWeaponLowAmmo(ArrayList<Weapon> list)
	{
		Weapon wx = new Weapon();
		ArrayList<Weapon> we = list;
		Collections.sort(we, new WeaponAmmoComparator());
		wx = we.get(0);
		return wx;
	}
	public static Weapon getWeaponMiddleAmmo(ArrayList<Weapon> list)
	{
		Weapon wx = new Weapon();
		ArrayList<Weapon> we = list;
		Collections.sort(we, new WeaponAmmoComparator());
		int c = we.size();
		wx = we.get(c/2);
		return wx;
	}

	public static Weapon getWeaponHighAccuracy(ArrayList<Weapon> list)
	{
		Weapon wx = new Weapon();
		ArrayList<Weapon> we = list;
		Collections.sort(we, new WeaponAccuracyComparator());
		int c = we.size();
		wx = we.get(c-1);
		return wx;
	}
	public static Weapon getWeaponLowAccuracy(ArrayList<Weapon> list)
	{
		Weapon wx = new Weapon();
		ArrayList<Weapon> we = list;
		Collections.sort(we, new WeaponAccuracyComparator());
		wx = we.get(0);
		return wx;
	}
	public static Weapon getWeaponMiddleAccuracy(ArrayList<Weapon> list)
	{
		Weapon wx = new Weapon();
		ArrayList<Weapon> we = list;
		Collections.sort(we, new WeaponAccuracyComparator());
		int c = we.size();
		wx = we.get(c/2);
		return wx;
	}

	public static Weapon getWeaponHighConcealment(ArrayList<Weapon> list)
	{
		Weapon wx = new Weapon();
		ArrayList<Weapon> we = list;
		Collections.sort(we, new WeaponConcealmentComparator());
		int c = we.size();
		wx = we.get(c-1);
		return wx;
	}
	public static Weapon getWeaponLowConcealment(ArrayList<Weapon> list)
	{
		Weapon wx = new Weapon();
		ArrayList<Weapon> we = list;
		Collections.sort(we, new WeaponAmmoComparator());
		wx = we.get(0);
		return wx;
	}
	public static Weapon getWeaponMiddleConcealment(ArrayList<Weapon> list)
	{
		Weapon wx = new Weapon();
		ArrayList<Weapon> we = list;
		Collections.sort(we, new WeaponAmmoComparator());
		int c = we.size();
		wx = we.get(c/2);
		return wx;
	}
	
	public static Weapon getWeaponHighThreat(ArrayList<Weapon> list)
	{
		Weapon wx = new Weapon();
		ArrayList<Weapon> we = list;
		Collections.sort(we, new WeaponThreatComparator());
		int c = we.size();
		wx = we.get(c-1);
		return wx;
	}
	public static Weapon getWeaponLowThreat(ArrayList<Weapon> list)
	{
		Weapon wx = new Weapon();
		ArrayList<Weapon> we = list;
		Collections.sort(we, new WeaponThreatComparator());
		wx = we.get(0);
		return wx;
	}
	public static Weapon getWeaponMiddleThreat(ArrayList<Weapon> list)
	{
		Weapon wx = new Weapon();
		ArrayList<Weapon> we = list;
		Collections.sort(we, new WeaponThreatComparator());
		int c = we.size();
		wx = we.get(c/2);
		return wx;
	}
	
	public static Weapon getWeaponHighStability(ArrayList<Weapon> list)
	{
		Weapon wx = new Weapon();
		ArrayList<Weapon> we = list;
		Collections.sort(we, new WeaponStabilityComparator());
		int c = we.size();
		wx = we.get(c-1);
		return wx;
	}
	public static Weapon getWeaponLowStability(ArrayList<Weapon> list)
	{
		Weapon wx = new Weapon();
		ArrayList<Weapon> we = list;
		Collections.sort(we, new WeaponStabilityComparator());
		wx = we.get(0);
		return wx;
	}
	public static Weapon getWeaponMiddleStability(ArrayList<Weapon> list)
	{
		Weapon wx = new Weapon();
		ArrayList<Weapon> we = list;
		Collections.sort(we, new WeaponStabilityComparator());
		int c = we.size();
		wx = we.get(c/2);
		return wx;
	}
	
	public static Weapon getWeaponHighMagazine(ArrayList<Weapon> list)
	{
		Weapon wx = new Weapon();
		ArrayList<Weapon> we = list;
		Collections.sort(we, new WeaponMagazineComparator());
		int c = we.size();
		wx = we.get(c-1);
		return wx;
	}
	public static Weapon getWeaponLowMagazine(ArrayList<Weapon> list)
	{
		Weapon wx = new Weapon();
		ArrayList<Weapon> we = list;
		Collections.sort(we, new WeaponMagazineComparator());
		return wx;
	}
	public static Weapon getWeaponMiddleMagazine(ArrayList<Weapon> list)
	{
		Weapon wx = new Weapon();
		ArrayList<Weapon> we = list;
		Collections.sort(we, new WeaponMagazineComparator());
		int c = we.size();
		wx = we.get(c/2);
		return wx;
	}
	
	
}
