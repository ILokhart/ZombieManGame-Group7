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
		String noClue = "";
		mL = new ArrayList<Monster>();
		
		mL.add(new Monster("Doctor", "...must warn...infected patient...there's going to be...outbreak...find the PHARMACIST...", "Bloodied and dying on the floor. You are compelled to rend his flesh.", 0));
		mL.add(new Monster("John Doe", noClue, "Just your average blue-collar gent", 15));
		mL.add(new Monster("Pharmacist", "...it must be...red...PATHOLOGIST knows...", "An old, balding man in a long white lab coat. He lunges towards you.", 30));
		mL.add(new Monster("Pathologist", "...there is a cure...the WRESTLER helped...STAY OUT OF THE BASEMENT!!!...", "The nervous young man inches away from you as you move closer towards him.", 20));
		mL.add(new Monster("Lab Assistant", noClue, "A tall, thin figure wearing a lab coat and glasses. He stands his ground.", 30));
		mL.add(new Monster("Wrestler", "...liquid...tastes awful...SURVIVALIST took it...", "If he were wearing plaid you would mistake him for a lumberjack. This will be a challenge", 50));
		mL.add(new Monster("Wrestler's Assistant", noClue, "This Monster is Secrectroy for the Westler", 20));
		mL.add(new Monster("Survivalist", "...the cure...he took it to the basement...CDC...HE'S GONE MAD!!!...", "The athletic young woman has piled equipment on her back. She weilds a camping spade.", 50));
		mL.add(new Monster("Evil Scientist", noClue, "His twisted body and black eyes stare straight into your soul. There is no way around him.", 70));
        mL.add(new Monster("Manager", "...my family...get the children out... RUN!!!...", "Your old boss. Under different circumstances you'd give him a piece of YOUR mind.", 40));
        mL.add(new Monster("Manager's Assistant", "...i only work here...", "The young intern looks determined. He's holding a pen but wishes it were a knife.", 20));
        mL.add(new Monster("Noisy Neighbor", noClue, "Your old slob for a neighbor. Even as he rifles through your belogings he rambles loudly.", 30));
        mL.add(new Monster("Assistant Pharmacist", noClue, "An assistant to the Pharmacist. She eyes the pharmacists office before charging you.", 20));
        mL.add(new Monster("Camper", noClue, "Your average family guy. He's dressed like a tourist.", 20 ));
        mL.add(new Monster("Ron Raymondous", noClue, "This guy was all over the news. He's been missing for weeks.", 40));
        mL.add(new Monster("Nurse", noClue, "She cowers in the corner. You want to leave, but your infected body won't let you.", 10 ));
	
	}
    // this method returns monster Array List by Monster Name 

	public Monster getMonster(String name)
	{
		for (int i = 0; i < mL.size(); i++)
		{
			if (mL.get(i).getName().equals(name))
			{
				return mL.get(i);
			}
		}
		return new Monster("ERROR Monster", "ERROR Clue", "A monster matching that name could not be found.", 100);
	}
}
