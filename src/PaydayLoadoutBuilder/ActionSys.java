/*
 * Payday 2 Loadout Builder Developed by Michael Rosenberg
 * http://mikerosenberger.com/blog || http://github.com/miker525
 * Developed for CS350 Final Project
 * Licensed Under GPLv3.0 - http://gnu.org/licenses/gpl-3.0.txt
 */
package PaydayLoadoutBuilder;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import PaydayComparators.*;

public class ActionSys implements ActionListener
{
	public ActionSys() {}

	public void actionPerformed(java.awt.event.ActionEvent ae) 
	{
		if (ae.getActionCommand().equals("btn"))
		{
			if (Wnd.comboBox.getSelectedItem() == "None")
			{
				Wnd.txtSuggestedPrimaryWeapon.setText(findPrimary().getWeaponName());
				Wnd.txtSuggestedSecondaryWeapon.setText(findSecondary().getWeaponName());
				Wnd.txtSuggestedArmor.setText(findArmor(findPrimary(), findSecondary()).getName());
			}
			else
			{
				if (Wnd.comboBox.getSelectedItem() == "Stealth")
				{
					Wnd.txtSuggestedPrimaryWeapon.setText(findStealthPrimary().getWeaponName());
					Wnd.txtSuggestedSecondaryWeapon.setText(findStealthSecondary().getWeaponName());
					Wnd.txtSuggestedArmor.setText(findStealthArmor().getName());
				}
				else if (Wnd.comboBox.getSelectedItem() == "Shoot Out")
				{
					Wnd.txtSuggestedPrimaryWeapon.setText(findShootOutPrimary().getWeaponName());
					Wnd.txtSuggestedSecondaryWeapon.setText(findShootOutSecondary().getWeaponName());
					Wnd.txtSuggestedArmor.setText(findShootOutArmor().getName());
				}
			}
		}
	}
		
	
	public Armor findArmor(Weapon primary, Weapon secondary)
	{
		Armor c = new Armor();
		if(Wnd.comboBox_1.getSelectedItem() == "Light")
		{
			c = ValReceiver.getLowArmor(Wnd.alist);
		}
		else if (Wnd.comboBox_1.getSelectedItem() == "Medium")
		{
			if (findPrimary().getConcealment() >= 17 && findSecondary().getConcealment() >= 24 )
			{
				Armor ax = new Armor();
				ArrayList<Armor> al = Wnd.alist;
				Collections.sort(al, new ArmorComparator());
				int x = al.size();
				ax = al.get((x/2)-1);
				return ax;
			}
			else
			{
				c = ValReceiver.getMiddleArmor(Wnd.alist);
			}
		}
		else if (Wnd.comboBox_1.getSelectedItem() == "Heavy")
		{
			c = ValReceiver.getHighArmor(Wnd.alist);
		}
		return c;
	}
	public Weapon findPrimary()
	{
		Weapon w = new Weapon();
		if (Wnd.comboBox_2.getSelectedItem() == "High Ammo")
		{
			w = ValReceiver.getWeaponHighAmmo(Wnd.wlist);
		}
		else if (Wnd.comboBox_2.getSelectedItem() == "High Damage")
		{
			w = ValReceiver.getWeaponHighDamage(Wnd.wlist);
		}
		else if (Wnd.comboBox_2.getSelectedItem() == "High Accuracy")
		{
			w = ValReceiver.getWeaponHighAccuracy(Wnd.wlist);
		}
		else if (Wnd.comboBox_2.getSelectedItem() == "High Concealment")
		{
			w = ValReceiver.getWeaponHighConcealment(Wnd.wlist);
		}
		else if (Wnd.comboBox_2.getSelectedItem() == "High Threat")
		{
			w = ValReceiver.getWeaponHighThreat(Wnd.wlist);
		}
		return w;
	}
	public Weapon findSecondary()
	{
		Weapon w = new Weapon();
		if (Wnd.comboBox_3.getSelectedItem() == "High Damage")
		{
			w = ValReceiver.getWeaponHighDamage(Wnd.wslist);
		}
		else if (Wnd.comboBox_3.getSelectedItem() == "High Concealment")
		{
			w = ValReceiver.getWeaponHighConcealment(Wnd.wslist);
		}
		else if (Wnd.comboBox_3.getSelectedItem() == "High Threat")
		{
			w = ValReceiver.getWeaponHighThreat(Wnd.wslist);
		}
		return w;
	}
	
	public Weapon findStealthPrimary()
	{
		ArrayList<Weapon> we = Wnd.wlist;
		Collections.sort(we, new WeaponConcealmentComparator());
		ArrayList<Weapon> we2 = new ArrayList<Weapon>();
		we2.add(we.get(we.size()-1));we2.add(we.get(we.size()-2));
		Collections.sort(we2, new WeaponThreatComparator());
		return we2.get(0);
	}
	public Weapon findStealthSecondary()
	{
		ArrayList<Weapon> we = Wnd.wslist;
		Collections.sort(we, new WeaponConcealmentComparator());
		ArrayList<Weapon> we2 = new ArrayList<Weapon>();
		we2.add(we.get(we.size()-1));we2.add(we.get(we.size()-2));
		Collections.sort(we2, new WeaponThreatComparator());
		return we2.get(0);
	}
	public Armor findStealthArmor()
	{
		ArrayList<Armor> ar = Wnd.alist;
		Collections.sort(ar, new ArmorConcealmentComparator());
		ArrayList<Armor> ar2 = new ArrayList<Armor>();
		ar2.add(ar.get(ar.size()-1));ar2.add(ar.get(ar.size()-2));
		Collections.sort(ar2, new ArmorConcealmentComparator());
		if(findStealthPrimary().getConcealment() >= 17 && findStealthSecondary().getConcealment() >= 22)
		{
			return ar2.get(0);
		}
		else
		{
			return ar2.get(1);
		}
	}

	public Weapon findShootOutPrimary()
	{
		ArrayList<Weapon> we = Wnd.wlist;
		Collections.sort(we, new WeaponDamageComparator());
		ArrayList<Weapon> we2 = new ArrayList<Weapon>();
		we2.add(we.get(we.size()-1));we2.add(we.get(we.size()-2));we2.add(we.get(we.size()-3));we2.add(we.get(we.size()-4));
		Collections.sort(we2, new WeaponAmmoComparator());
		ArrayList<Weapon> we3 = new ArrayList<Weapon>();
		we3.add(we2.get(we2.size()-1));we3.add(we2.get(we2.size()-2));we3.add(we2.get(we2.size()-3));
		we=we3;
		Collections.sort(we, new WeaponAccuracyComparator());
		we2.add(we.get(we.size()-1));we2.add(we.get(we.size()-2));
		Collections.sort(we2, new WeaponStabilityComparator());
		return we2.get(we2.size()-1);
	}
	public Weapon findShootOutSecondary()
	{
		ArrayList<Weapon> we = Wnd.wslist;
		Collections.sort(we, new WeaponDamageComparator());
		ArrayList<Weapon> we2 = new ArrayList<Weapon>();
		we2.add(we.get(we.size()-1));we2.add(we.get(we.size()-2));we2.add(we.get(we.size()-3));we2.add(we.get(we.size()-4));
		Collections.sort(we2, new WeaponAmmoComparator());
		ArrayList<Weapon> we3 = new ArrayList<Weapon>();
		we3.add(we2.get(we2.size()-1));we3.add(we2.get(we2.size()-2));we3.add(we2.get(we2.size()-3));
		we=we3;
		Collections.sort(we, new WeaponAccuracyComparator());
		we2.add(we.get(we.size()-1));we2.add(we.get(we.size()-2));
		Collections.sort(we2, new WeaponStabilityComparator());
		return we2.get(we2.size()-1);
	}
	public Armor findShootOutArmor()
	{
		ArrayList<Armor> ar = Wnd.alist;
		Collections.sort(ar, new ArmorComparator());
		ArrayList<Armor> ar2 = new ArrayList<Armor>();
		ar2.add(ar.get(ar.size()-1));ar2.add(ar.get(ar.size()-2));ar2.add(ar.get(ar.size()-3));
		Collections.sort(ar2, new ArmorDodgeComparator());
		ArrayList<Armor> ar3 = new ArrayList<Armor>();
		ar3.add(ar2.get(ar2.size()-1));ar3.add(ar2.get(ar2.size()-2));ar3.add(ar2.get(ar2.size()-3));
		ar=ar3;
		Collections.sort(ar, new ArmorSpeedComparator());
		ar2.add(ar.get(ar.size()-1));ar2.add(ar.get(ar.size()-2));
		Collections.sort(ar2, new ArmorStaminaComparator());
		return ar2.get(ar2.size()-1);
	}

}