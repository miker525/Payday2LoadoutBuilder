/*
 * Payday 2 Loadout Comparators Developed by Michael Rosenberg
 * http://mikerosenberger.com/blog || http://github.com/miker525
 * Developed for CS350 Final Project
 * Licensed Under GPLv3.0 - http://gnu.org/licenses/gpl-3.0.txt
 */
package PaydayComparators;

import java.util.Comparator;
import PaydayLoadoutBuilder.Weapon;

public class WeaponDamageComparator implements Comparator<Weapon> 
{
	public int compare(Weapon wep, Weapon wep2) 
	{
		return wep.getDamage() - wep2.getDamage();
	}
}
