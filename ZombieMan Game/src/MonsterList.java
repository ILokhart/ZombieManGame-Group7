package src;

import java.util.ArrayList;


/**
 * Class: MonsterList
 * 
 * @author Bhavan Patel 
 * @version 1.0 
 * Course : ITEC 3860 Fall 2015
 * Written: Nov 7, 2015
 *  
 *      This class is the Monster list class which stored the Array List of the monster, 
 *      Which creates the new monster Which is stored into Array List by using constructor methord
 *      from the Monster.java class.
 *      
 * 
 */

public class MonsterList
{
	private ArrayList<Monster> mL;
	
	// this method creates new monster using Monster's class constructor and adds into array List
	public MonsterList()
	{
		mL.add(new Monster("ERROR Monster", "ERROR Clue", "A monster matching that name could not be found.", 100));
		mL.add(new Monster("Pharmacist", "Provides the Vaccine color", "monster's des", 24));
		mL.add(new Monster("Pathologist", "provides the confirmation of cure called the vaccine and origin story",
				 "monster's des", 14));
		  mL.add(new Monster("Wrestler", "today", "monster's des", 12));
		  mL.add(new Monster("Survivalist", " 24 h today", "monster's des", 32));
		  mL.add( new Monster("Evil Scientist", " 14 today", "monster's des", 21));
		  mL.add(new Monster("Manager", "gives directions", "primarily at work", 24));
		  mL.add(new Monster("Noisy Neighbor", "helps player", "primarily at Home", 28));
		  mL.add(new Monster("Doctor","gives dirctions how to get vaccine", "founded at begaining of the game", 29));
	}
	
	// this method returns monster Array List by Monster Name 
	public Monster getMonster(String name)
	{
		for (int i = 0; i < mL.size() - 1; i++) 
		{
			if(mL.get(i).getMonsterName().equals(name))
			{
				return mL.get(i);
			}
		}
		return null;
	}
}
