package src;



import java.util.ArrayList;

/**
 * Class: RoomList
 * 
 * @author Bhavan Patel and Jacob Piazza 
 * @version 1.0 
 * Course : ITEC 3860 Fall 2015
 * Written: Nov 11, 2015
 * 
 *      This class will populate the local room list with all rooms present in ZombieMan.
 *      It also provides tools for retreiving rooms for use in navigation throughout ZombieMan
 * 
 *      Purpose: To manage the creation of rooms and interact with the Game class for navigation within ZombieMan
 * 
 */

public class RoomList
{
	private ArrayList<Room> rL;

	// this method creates new monster using Monster's class constructor and
	// adds into array List
	public RoomList()
	{
		rL = new ArrayList<Room>();
		ArrayList<Room> noNextRoom = new ArrayList<Room>();
		String noLocalMonster = "";
		String noPreviousRoom = "";
		
		// Hospital is the starting point for all new players
		ArrayList<String> nextRoom1 = new ArrayList<String>();
		nextRoom1.add("Downtown");
		nextRoom1.add("The Suburbs");
		rL.add(new Room("Hospital", "You enter the lobby. Furniture, medical supplies, and patient records are strewn everywhere. It looks like everyone left in a hurry.",
				nextRoom1, noPreviousRoom, 40, "Nurse", "You see lifeless bodies piled in front of every exit."));
		
		// Downtown is left branch from Hospital
		ArrayList<String> nextRoom2 = new ArrayList<String>();
		nextRoom2.add("Warehouse");
		nextRoom2.add("Office");
		nextRoom2.add("CDC");
		rL.add(new Room("Downtown", "You stand at the top of a hill on the edge of town. From here you can see the silhouettes of several buildings against the dimly lit horizon.",
				nextRoom2, "Hospital", 70, noLocalMonster, "Normally you could hear the bustle of the city from here, but now... silence."));
		
		// The Suburbs is right branch from Hospital
		ArrayList<String> nextRoom3 = new ArrayList<String>();
		nextRoom3.add("Home");
		nextRoom3.add("Woods");
		nextRoom3.add("Pharmacy");
		rL.add(new Room("The Suburbs", "You stand at a crossroad between your neighborhood and a small strip mall.", nextRoom3, "Hospital", 70, noLocalMonster, 
				"A few empty cars are parked in the street and the street lights still work intermittently. Some of the homes and shops are dimly lit but you don't see a single soul."));
		
		// Warehouse is path 1 from Downtown
		ArrayList<String> nextRoom4 = new ArrayList<String>();
		nextRoom4.add("Storage");
		nextRoom4.add("Offices");
		nextRoom4.add("Dock");
		rL.add(new Room("Warehouse", "You enter the warehouse through large, open bay doors and see rows shelves loaded with boxes of varying sizes.", nextRoom4, "Downtown", 50,
				localMonster, emptyRoom));
		// Three rooms from Warehouse
		rL.add(new Room("Storage", description, noNextRoom, "Warehouse", encounterChance, localMonster, emptyRoom));
		rL.add(new Room("Offices", description, noNextRoom, "Warehouse", encounterChance, localMonster, emptyRoom));
		rL.add(new Room("Dock", description, noNextRoom, "Warehouse", encounterChance, localMonster, emptyRoom));
		
		// Work is path 2 from Downtown
		ArrayList<String> nextRoom5 = new ArrayList<String>();
		nextRoom5.add("Your Office");
		nextRoom5.add("Data Center");
		nextRoom5.add("Managers Office");
		rL.add(new Room("Work", description, nextRoom5, "Downtown", encounterChance, localMonster, emptyRoom));
		// Three rooms from Work
		rL.add(new Room("Your Office", description, noNextRoom, "Work", encounterChance, localMonster, emptyRoom));
		rL.add(new Room("Data Center", description, noNextRoom, "Work", encounterChance, localMonster, emptyRoom));
		rL.add(new Room("Managers Office", description, noNextRoom, "Work", encounterChance, localMonster, emptyRoom));
		
		// CDC is path 3 from Downtoan
		ArrayList<String> nextRoom6 = new ArrayList<String>();
		nextRoom6.add("Toxicology");
		nextRoom6.add("Pathology");
		nextRoom6.add("Lab");
		rL.add(new Room("CDC", description, nextRoom6, "Downtown", encounterChance, localMonster, emptyRoom));
		// Three rooms from CDC
		rL.add(new Room("Toxicology", description, noNextRoom, "CDC", encounterChance, localMonster, emptyRoom));
		rL.add(new Room("Pathology", description, noNextRoom, "CDC", encounterChance, localMonster, emptyRoom));
		ArrayList<String> nextRoom7 = new ArrayList<String>();
		nextRoom7.add("Basement");
		rL.add(new Room("Lab", description, nextRoom7, "CDC", encounterChance, localMonster, emptyRoom));
		// End game branch from Lab
		ArrayList<String> nextRoom8 = new ArrayList<String>();
		nextRoom8.add("Security");
		rL.add(new Room("Basement", description, nextRoom8, "Lab", encounterChance, localMonster, emptyRoom));
		ArrayList<String> nextRoom9 = new ArrayList<String>();
		nextRoom9.add("Containment");
		rL.add(new Room("Security", description, nextRoom9, "Basement", encounterChance, localMonster, emptyRoom));
		rL.add(new Room("Containment", description, noNextRoom, "Security", encounterChance, localMonster, emptyRoom));
		
		// Home is path 1 from The Suburbs
		ArrayList<String> nextRoom10 = new ArrayList<String>();
		nextRoom10.add("Kitchen");
		nextRoom10.add("Bedroom");
		nextRoom10.add("Cellar");
		rL.add(new Room("Home", description, nextRoom10, "The Suburbs", encounterChance, localMonster, emptyRoom));
		// Three rooms from Home
		rL.add(new Room("Kitchen", description, noNextRoom, "Home", encounterChance, localMonster, emptyRoom));
		rL.add(new Room("Bedroom", description, noNextRoom, "Home", encounterChance, localMonster, emptyRoom));
		rL.add(new Room("Cellar", description, noNextRoom, "Home", encounterChance, localMonster, emptyRoom));
		
		// Woods is path 2 from The Suburbs
		ArrayList<String> nextRoom11 = new ArrayList<String>();
		nextRoom11.add("Campsite");
		nextRoom11.add("Creek");
		nextRoom11.add("Trail");
		rL.add(new Room("Woods", description, nextRoom11, "The Suburbs", encounterChance, localMonster, emptyRoom));
		// Three rooms from Woods
		rL.add(new Room("Campsite", description, noNextRoom, "Woods", encounterChance, localMonster, emptyRoom));
		rL.add(new Room("Creek", description, noNextRoom, "Woods", encounterChance, localMonster, emptyRoom));
		rL.add(new Room("Trail", description, noNextRoom, "Woods", encounterChance, localMonster, emptyRoom));
		
		// Pharmacy is path 3 from the Suburbs
		ArrayList<String> nextRoom12 = new ArrayList<String>();
		nextRoom12.add("Drug Room");
		nextRoom12.add("Pharmacists Office");
		nextRoom12.add("Record Room");
		rL.add(new Room("Pharmacy", "You enter the lobby. Furniture, medical supplies, and patient records are strewn everywhere. It looks like everyone left in a hurry.",
				nextRoom1, "", 40, "Nurse", "You see lifeless bodies piled in front of every exit."));
		// Three rooms from Pharmacy
		rL.add(new Room("Drug Room", description, noNextRoom, "Pharmacy", encounterChance, localMonster, emptyRoom));
		rL.add(new Room("Pharmacists Office", description, noNextRoom, "Pharmacy", encounterChance, localMonster, emptyRoom));
		rL.add(new Room("Record Room", description, noNextRoom, "Pharmacy", encounterChance, localMonster, emptyRoom));
		
		
		
	}

	public ArrayList<Room> getroomList()
	{
		return rL;
	}

	public Room getRoom(String name)
	{
		for (int i = 0; i < rL.size() - 1; i++)
		{
			if (rL.get(i).getName().equals(name))
			{
				return rL.get(i);
			}
		}
		ArrayList<String> nextError = new ArrayList<String>();
		return new Room("ERROR ROOM", "You have entered a state of limbo.", nextError, "ERROR ROOM", 50, "ERROR MONSTER", "It is quiet in ERROR ROOM");
	}
}
