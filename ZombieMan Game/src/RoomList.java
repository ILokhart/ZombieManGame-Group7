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
 *      This class is the Room  class which stored the question list, available correct answers
 *      for the each of the Room List's Questions and they correct answer as well. Which is stored
 *      into Array List for the each of the attributes. 
 * 
 *      Purpose: 
 * 
 */


public class RoomList
{
	private ArrayList<Room> rL; 
	
	// this method creates new monster using Monster's class constructor and adds into array List
		public RoomList()
		{
			ArrayList<String> nextRoom1 = new ArrayList<String>();
			nextRoom1.add("Test Room 2");
			rL.add(new Room("Test Room 1", "This is the first test room.", nextRoom1, "Test Room 3", 50));
			
			ArrayList<String> nextRoom2 = new ArrayList<String>();
			nextRoom2.add("Test Room 3");
			rL.add(new Room("Test Room 2", "This is the second test room.", nextRoom2, "Test Room 1", 50));
			
			ArrayList<String> nextRoom3 = new ArrayList<String>();
			nextRoom3.add("Test Room 1");
			rL.add(new Room("Test Room 3", "This is the third test room.", nextRoom3, "Test Room 2", 50));
		}
		
		public ArrayList<Room> getroomList()
		{
			return rL;
		}
		
		public Room getRoom(String name)
		{
			for (int i = 0; i < rL.size() - 1; i++) 
			{
				if(rL.get(i).getroomName().equals(name))
				{
					return rL.get(i);
				}
			}
			return null;
		}
}


