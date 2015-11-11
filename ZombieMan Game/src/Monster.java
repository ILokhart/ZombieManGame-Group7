package src;

import java.util.ArrayList;

/**
 * Class: Monster
 * 
 * @author Bhavan Patel 
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
	private String monsterName;
	private String clue; 
	private String description; 
	private int chanceToHit; 
	private int hitPoints;


public Monster( String monsterName, String clue, String description, int chanceToHit )
{
		   
		   this.monsterName = monsterName; 
		   this.clue = clue;
		   this.description = description;
		   this.chanceToHit = chanceToHit; 
		   this.hitPoints = 0;

}

   
   public String description()
   {
	   return description; 
   }
   
   public int chanceToHit()
   { 
	   return chanceToHit;
   }
   
   public int hitPoints(int hitPoints)
   {  
	   return this.setHitPoints(hitPoints); 
   }

public String getMonsterName() {
	return monsterName;
}

public void setMonsterName(String monsterName) {
	this.monsterName = monsterName;
}

public String getClue() {
	return clue;
}

public void setClue(String clue) {
	this.clue = clue;
}



public int setHitPoints(int hitPoints) {
	this.hitPoints = hitPoints;
	return hitPoints;
}










  }
