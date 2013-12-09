/*
 * Payday 2 Loadout Comparators Developed by Michael Rosenberg
 * http://mikerosenberger.com/blog || http://github.com/miker525
 * Developed for CS350 Final Project
 * Licensed Under GPLv3.0 - http://gnu.org/licenses/gpl-3.0.txt
 */
package PaydayComparators;

import java.util.Comparator;
import PaydayLoadoutBuilder.Armor;

public class ArmorDodgeComparator  implements Comparator<Armor> 
{
	public int compare(Armor arm, Armor arm2) 
	{
		return arm.getDodge() - arm2.getDodge();
	}
}
