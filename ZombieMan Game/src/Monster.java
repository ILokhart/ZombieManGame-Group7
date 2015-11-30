package src;


/**
 * Class: Monster
 * 
 * @author Bhavan Patel and Jacob Piazza
 * @version 1.0 
 * Course : ITEC 3860 Fall 2015
 * Written: Nov 7, 2015
 *  
 *      This class is the Monster list class which stored the question list, available correct answers
 *      for the each of the Monster List's Questions and they correct answer as well. Which is stored
 *      into Array List for the each of the attributes. 
 * 
 *      Purpose: 
 * 
 */

public class Monster
{
	private String name;
	private String clue;
	private String description;
	private int chanceToHit;
	private int hitPoints;

	public Monster(String name, String clue, String description, int chanceToHit)
	{

		this.name = name;
		this.clue = clue;
		this.description = description;
		this.chanceToHit = chanceToHit;
		this.hitPoints = 0;
	}

	public String getName()
	{
		return name;
	}
	
	public String getClue()
	{
		return clue;
	}
	
	public String getDescription()
	{
		return this.description;
	}

	public int getCTH()
	{
		return this.chanceToHit;
	}

	public int getHitPoints()
	{
		return this.hitPoints;
	}

	public void plusHitPoints()
	{
		this.hitPoints += 1;
	}
	
	public void resetHitPoints()
	{
		this.hitPoints = 0;
	}
}
