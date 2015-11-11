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
	private String roomName;
	private String description; 
	private  ArrayList<String> nextRoom; 
	private String previousRoom; 
	private int encounterChances; 


  public Room (String roomName, String description,  ArrayList<String> nextRoom, String previousRoom, int encounterChances  )
  {
	 this.roomName = roomName; 
	 this.description = description; 
	 this.nextRoom = nextRoom; 
	 this.previousRoom = previousRoom; 
	 this.encounterChances = encounterChances;
  }
  
  public String getroomName() 
  {
	  return roomName;
  }
  
  public String getdescription()
  {
	  return description;
  }
  
  public ArrayList<String> getnextRoom ()
  {
	  return nextRoom;
  }
  
  public String getpreviousRoom()
  {
	  return previousRoom;
  }
   
  public int getencounterChances()
  {
	  return encounterChances;
  }



}




