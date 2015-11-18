package src;

import java.util.ArrayList;

/**
 * Class: Room
 * 
 * @author Bhavan Patel and Jacob Piazza 
 * @version 1.0 
 * Course : ITEC 3860 Fall 2015
 * Written: Nov 11, 2015
 *  
 *      This class is the Room  class which stored the question list, available correct answers
 *      for the each of the Room List's Questions and they correct answer as well. Which is stored
 *      into Array List for the each of the attributes. 
 * 
 *      Purpose: 
 * 
 */

public class Room
{
	private String name;
	private String description; 
	private ArrayList<String> nextRoom; 
	private String previousRoom; 
	private int encounterChance;
	private String localMonster;
	private String emptyRoom;

  public Room (String name, String description,  ArrayList<String> nextRoom, String previousRoom, int encounterChance, String localMonster, String emptyRoom)
  {
	 this.name = name; 
	 this.description = description; 
	 this.nextRoom = nextRoom; 
	 this.previousRoom = previousRoom; 
	 this.encounterChance = encounterChance;
	 this.localMonster = localMonster;
	 this.emptyRoom = emptyRoom;
  }
  
  public String getName() 
  {
	  return this.name;
  }
  
  public String getDescription()
  {
	  return this.description;
  }
  
  public ArrayList<String> getNextRoom()
  {
	  return this.nextRoom;
  }
  
  public String getPreviousRoom()
  {
	  return this.previousRoom;
  }
   
  public int getEncounterChance()
  {
	  return this.encounterChance;
  }
  
  public String getLocalMonster()
  {
	  return this.localMonster;
  }
  
  public String getEmptyRoom()
  {
	  return this.emptyRoom;
  }
}




