package src;

import java.util.ArrayList;

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




