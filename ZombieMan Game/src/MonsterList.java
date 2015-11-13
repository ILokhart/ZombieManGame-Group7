

import java.util.ArrayList;

/**
 * Class: MonsterList
 * 
 * @author Bhavan Patel and Jacob Piazza
 * @version 1.0 
 * Course : ITEC 3860 Fall 2015
 * Written: Nov 7, 2015
 *  
 *      This class is the puzzle list class which stored the question list, available correct answers
 *      for the each of the Puzzles List's Questions and they correct answer as well. Which is stored
 *      into Array List for the each of the attributes. 
 * 
 *      Purpose: 
 * 
 */

public class MonsterList
{
	private ArrayList<Monster> mL;

	// this method creates new monster using Monster's class constructor and
	// adds into array List
	public MonsterList()
	{
		mL.add(new Monster("ERROR Monster", "ERROR Clue", "A monster matching that name could not be found.", 100));
		mL.add(new Monster("John Doe", "John doesn't have a clue", "Just your average blue-collar gent", 15));
		mL.add(new Monster("Pharmacist", "Provides the Vaccine color", "monster's des", 24));
		mL.add(new Monster("Pathologist", "provides the confirmation of cure called the vaccine and origin story", "monster's des", 14));
		mL.add(new Monster("Wrestler", "today", "monster's des", 12));
		mL.add(new Monster("Survivalist", " 24 h today", "monster's des", 32));
		mL.add(new Monster("Evil Scientist", " 14 today", "monster's des", 21));
	}

	public Monster getMonster(String name)
	{
		for (int i = 0; i < mL.size() - 1; i++)
		{
			if (mL.get(i).getName().equals(name))
			{
				return mL.get(i);
			}
		}
		return null;
	}
}
