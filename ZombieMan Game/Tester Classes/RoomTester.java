

import java.util.ArrayList; 
/**
 * Class: RoomListTester
 * 
 * @author Reuben massaquoi
 * @version 1.0 
 * Course : ITEC 3860 Fall 2015
 * Written: Nov 14, 2015
 *  
 *      This class is the A tester class for Room objects which are objects that hold various attributes associated with a room such as name and description.
 * 
 *Purpose: 
 *
 *		The purpose of this class is to test the Methods of the Room class
 * 
 */


public class RoomTester 
{

	
	
	public static void main(String[] args) 
	{
		ArrayList<String> nextRoom = new ArrayList<String>();
		nextRoom.add("Room 2");
		Room myRoom = new Room("Name", "This is a test room", nextRoom,"Room 3",50, "Monster 1", "This Test Room appears to be empty.");
		
		
		System.out.println("Room Name: " + myRoom.getName());
		
		System.out.println("Room Description: " + myRoom.getDescription());
		
		
		for(int i = 0; i <myRoom.getNextRoom().size(); i++)
		{
			System.out.println("The next room: " + myRoom.getNextRoom().get((i)));
		}
		
		
		System.out.println("The previous room: " + myRoom.getPreviousRoom());
		
		System.out.println("Encounter chance: " + myRoom.getEncounterChance());
		
		System.out.println("Local monster: "+ myRoom.getLocalMonster());
		
		System.out.println("Empty room Description: " + myRoom.getEmptyRoom());
		

	}

}
