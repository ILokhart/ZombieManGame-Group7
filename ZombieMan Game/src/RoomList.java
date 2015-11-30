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
		
		ArrayList<String> noNextRoom = new ArrayList<String>();
		String noLocalMonster = "";
		String noPreviousRoom = "";
		String emptyRoom = "You find nothing of interest.";
		
		// Hospital is the starting point for all new players
		ArrayList<String> nextRoom1 = new ArrayList<String>();
		nextRoom1.add("Downtown");
		nextRoom1.add("The Suburbs");
		rL.add(new Room("Hospital", "You enter the hospital lobby. Furniture, medical supplies, and patient records are strewn everywhere. It looks like everyone left in a hurry.",
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
		rL.add(new Room("The Suburbs", "You stand at a crossroad between your old neighborhood and a small strip mall.", nextRoom3, "Hospital", 70, noLocalMonster, 
				"A few empty cars are parked in the street and the street lights still work intermittently. Some of the homes and shops are dimly lit but you don't see a single soul."));
		
		// Warehouse is path 1 from Downtown
		ArrayList<String> nextRoom4 = new ArrayList<String>();
		nextRoom4.add("Storage");
		nextRoom4.add("Offices");
		nextRoom4.add("Dock");
		rL.add(new Room("Warehouse", "You approach the warehouse near large, open bay doors and see rows shelves loaded with boxes of varying sizes.", nextRoom4, "Downtown", 60,
				"Wrestler's Assistant", emptyRoom));
		// Three rooms from Warehouse
		rL.add(new Room("Storage", "You you enter a smaller storage area filled with various business supplies.", noNextRoom, "Warehouse", 40, "Wrestler's Assistant", emptyRoom));
		rL.add(new Room("Offices", "You enter", noNextRoom, "Warehouse", 0, "Wrestler", emptyRoom));
		rL.add(new Room("Dock", "You enter", noNextRoom, "Warehouse", 40, "Wrestler's Assistant", emptyRoom));
		
		// Work is path 2 from Downtown
		ArrayList<String> nextRoom5 = new ArrayList<String>();
		nextRoom5.add("Your Office");
		nextRoom5.add("Data Center");
		nextRoom5.add("Managers Office");
		rL.add(new Room("Work", "You approach your old place of work, a tall office building surrounded by smaller local businesses.", nextRoom5, "Downtown", 60, "Manager's Assistant", emptyRoom));
		// Three rooms from Work
		rL.add(new Room("Your Office", "You enter your old office. You recognize the name plate and a photo of your family.", noNextRoom, "Work", 70, noLocalMonster, emptyRoom));
		rL.add(new Room("Data Center", "You enter the data center. Tall rows of computer cabinets wind around the room, hard drives clicking.", noNextRoom, "Work", 40, "Manager's Assistant", emptyRoom));
		rL.add(new Room("Managers Office", "You enter your old bosses office.", noNextRoom, "Work", 0, "Manager", emptyRoom));
		
		// CDC is path 3 from Downtoan
		ArrayList<String> nextRoom6 = new ArrayList<String>();
		nextRoom6.add("Toxicology");
		nextRoom6.add("Pathology");
		nextRoom6.add("Restricted Lab");
		rL.add(new Room("CDC", "You approach the front of the CDC. As you gaze through the tall, glass windows you can see a few bodies in white jumpsuits laying motionless on the lobby floor.", nextRoom6, "Downtown", 60, "Lab Assistant", emptyRoom));
		// Three rooms from CDC
		rL.add(new Room("Toxicology", "You enter the toxicology lab and notice the walls are lined with glass containers filled with substances of various colors and consistencies.", noNextRoom, "CDC", 40, "Pathologist", emptyRoom));
		rL.add(new Room("Pathology", "You enter the pathology lab. All of the animals are missing or dead but you notice an active terminal. Someone must have been here recently.", noNextRoom, "CDC", 0, "Pathologist", emptyRoom));
		ArrayList<String> nextRoom7 = new ArrayList<String>();
		nextRoom7.add("Basement");
		rL.add(new Room("Restricted Lab", "You enter a restricted lab through a decontamination unit that was left open. A bright red door in the back of the room catches your eye, above it: AUTHORIZED PERSONEL ONLY.", nextRoom7, "CDC", 0, "Lab Assistant", emptyRoom));
		// End game branch from Lab
		ArrayList<String> nextRoom8 = new ArrayList<String>();
		nextRoom8.add("Security");
		rL.add(new Room("Basement", "You enter the basement. A long flight of stairs leads to an even longer hallway.", nextRoom8, "Restricted Lab", 0, "Lab Assistant", emptyRoom));
		ArrayList<String> nextRoom9 = new ArrayList<String>();
		nextRoom9.add("Containment");
		rL.add(new Room("Security", "You enter a secured area bottlenecked by checkpoints and scanners. You pass through each one as they beep with a bright red light.", nextRoom9, "Basement", 0, "Evil Scientist", emptyRoom));
		rL.add(new Room("Containment", "You enter a small refrigerated room with a single container centered on the only table. Within it you find multiple samples labled CURE.", noNextRoom, "Security", 70, noLocalMonster, emptyRoom));
		
		// Home is path 1 from The Suburbs
		ArrayList<String> nextRoom10 = new ArrayList<String>();
		nextRoom10.add("Kitchen");
		nextRoom10.add("Bedroom");
		nextRoom10.add("Cellar");
		rL.add(new Room("Home", "You approach your old house. You remember a key left under the mat but the door is already wide open.", nextRoom10, "The Suburbs", 70, noLocalMonster, emptyRoom));
		// Three rooms from Home
		rL.add(new Room("Kitchen", "You enter the kitchen and search for supplies but it looks like someone else already had the same idea.", noNextRoom, "Home", 40, "John Doe", emptyRoom));
		rL.add(new Room("Bedroom", "You enter the bedroom and briefly recognize a photo of your family. The infection clouds your memory.", noNextRoom, "Home", 40, "John Doe", emptyRoom));
		rL.add(new Room("Cellar", "You enter the dark cellar. In one of the basement rooms you can hear some shuffling and muffled speech.", noNextRoom, "Home", 0, "Noisy Neighbor", emptyRoom));
		
		// Woods is path 2 from The Suburbs
		ArrayList<String> nextRoom11 = new ArrayList<String>();
		nextRoom11.add("Campsite");
		nextRoom11.add("Creek");
		nextRoom11.add("Trail");
		rL.add(new Room("Woods", "You approach the edge of the woods. You can hear movement deep inside the forrest. Maybe it's just the wind.", nextRoom11, "The Suburbs", 60, "Survivalist", emptyRoom));
		// Three rooms from Woods
		rL.add(new Room("Campsite", "You enter a campsite you used to visit with your family. The fire pit is still smoking. Someone was here recently.", noNextRoom, "Woods", 30, "Camper", emptyRoom));
		rL.add(new Room("Creek", "You enter the creek area. Much further down the creek you can barely see the outline of a figure in the dark, standing in the water.", noNextRoom, "Woods", 0, "Ron Raymondous", emptyRoom));
		rL.add(new Room("Trail", "You enter the hiking trail. You can barely see the outline of a figure moving in and out of the shadows. Maybe it's just an animal.", noNextRoom, "Woods", 0, "Survivalist", emptyRoom));
		
		// Pharmacy is path 3 from the Suburbs
		ArrayList<String> nextRoom12 = new ArrayList<String>();
		nextRoom12.add("Drug Room");
		nextRoom12.add("Pharmacists Office");
		nextRoom12.add("Record Room");
		rL.add(new Room("Pharmacy", "You approach the pharmacy lobby. Furniture, medical supplies, and patient records are strewn everywhere. It looks like everyone left in a hurry.",
				nextRoom12, "The Suburbs", 40, "Assistant Pharmacist", emptyRoom));
		// Three rooms from Pharmacy
		rL.add(new Room("Drug Room", "You enter the drug storage area. Maybe one of the bottles could help you if you knew what any of them were.", noNextRoom, "Pharmacy", 30, "Assistant Pharmacist", emptyRoom));
		rL.add(new Room("Pharmacists Office", "You enter the pharmacists office and see a body resting in the chair facing away from you.", noNextRoom, "Pharmacy", 0, "Pharmacist", emptyRoom));
		rL.add(new Room("Record Room", "You enter patient record room. It is lined with shelves containing countless manila folders.", noNextRoom, "Pharmacy", 30, "Nurse", emptyRoom));
		
		
		
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
		return null;
	}
}
