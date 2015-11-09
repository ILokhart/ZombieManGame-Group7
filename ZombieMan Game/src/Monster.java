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
	private double chanceToHit; 
	private int hitPoints;


public Monster( String monsterName, String clue, String description, double chanceToHit )
{
		   
		             setHitPoints(0); 

}
//
//     monsterName.add("Pharmacist");
//     clue.add (" Provides the Vaccine color");
//     description.add ("monster's des"); 
//     chanceToHit.add ("24");
//     hitPoints.add ("52");
//     
//     monsterName.add("Pathologist");
//     clue.add ("provides the confirmation of cure called the vaccine and origin story");
//     description.add ("monster's des"); 
//     chanceToHit.add ("14");
//     hitPoints.add ("28");
//     
//     monsterName.add("Wrestler");
//     clue.add ("today");
//     description.add ("monster's des"); 
//     chanceToHit.add ("12");
//     hitPoints.add ("29");
//     
//     monsterName.add("Survivalist");
//     clue.add (" 24 h today");
//     description.add ("monster's des"); 
//     chanceToHit.add ("4");
//     hitPoints.add ("10");
//     
//     monsterName.add("Evil Scientist ");
//     clue.add ("14 today");
//     description.add ("monster's des"); 
//     chanceToHit.add ("4");
//     hitPoints.add ("25");
//}
//     

   
   public String description()
   {
	   return description; 
   }
   
   public double chanceToHit()
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
