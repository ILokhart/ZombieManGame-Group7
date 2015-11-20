package src;



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
		mL = new ArrayList<Monster>();
		
		mL.add(new Monster("ERROR Monster", "ERROR Clue", "A monster matching that name could not be found.", 100));
		mL.add(new Monster("John Doe", "John doesn't have a clue", "Just your average blue-collar gent", 15));
		mL.add(new Monster("Pharmacist", "Pharmacist to seek out the Pathologist and Wrestler, Also provides clour for the Vaccine",
				"primarily at the Pharmacy", 24));
		mL.add(new Monster("Pathologist", "inform the player that there is in fact a cure know as the Vaccine", "primarily at the Lab", 14));
		mL.add(new Monster("Wrestler", "Doesn't know the location or color, but know the composition of the Vaccine", 
				"works in the warehouse", 12));
		mL.add(new Monster ("Wrestler's Assitant","instruct the player to seek out the Survivalist", "This Monster is Secrectroy for the Westler",24));
		mL.add(new Monster("Survivalist", " 24 h today", "primarily in the woods", 32));
		mL.add(new Monster("Evil Scientist", " 14 today", "located in the CDC", 21));
        mL.add(new Monster("Manager", "gives directions", "primarily at work", 24));
        mL.add(new Monster("Noisy Neighbor", "helps player", "primarily at Home", 28));
        mL.add(new Monster("Doctor","gives dirctions how to get vaccine", "founded at begaining of the game", 29));
        mL.add(new Monster("Pharmacist Assistant", "Vaccine is drinkable as it is a liquid", "This Monster is right hand man for the Pharmacist", 17));
        mL.add(new Monster("Camper", "No clue", "This monster is helper monster for their leader Survialist Ron Raymondous", 18 ));
        mL.add(new Monster("Ron Raymondous", "Vaccine is behind the Evil Scientist that must be killed to get to the safe the Vaccine is located",
        		"This is the leader Monster for the camper's and Survivalist", 41));
        mL.add(new Monster("Nurse","provides directions and clue for vaccine to seek out for Pharamacist", "This Monster is secrectory for the Doctor", 12 ));
	
	}
    // this method returns monster Array List by Monster Name 

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
