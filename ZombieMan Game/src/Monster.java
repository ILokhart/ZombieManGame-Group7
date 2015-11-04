package src;

public class Monster
{
	private String monsterName;
	private String clue; 
	private String description; 
	private double chanceToHit; 
	private int hitPoints;


public Monster (String monsterName, String clue, String description,
		             double chanceToHit)
{
		   
		             hitPoints = 0; 

}

   public String monsterName()
   {
	   return monsterName;
   }
   
   public String clue()
   {
	   return clue;
   }
   
   public String description()
   {
	   return description; 
   }
   
   public double chanceToHit()
   { 
	   return chanceToHit;
   }
   
   public int hitPoints()
   {  
	   this.hitPoints = hitPoints; 
   }










  }
}