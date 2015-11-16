import java.util.ArrayList; 

/**
 * Class: RoomListTester
 * 
 * @author Reuben massaquoi
 * @version 1.0 
 * Course : ITEC 3860 Fall 2015
 * Written: Nov 14, 2015
 *  
 *      This class is the A tester class for RoomList objects which are objects that hold a list of room objects. 
 * 
 *Purpose: 
 *
 *		The purpose of this class is to test the Methods of the RoomList class
 * 
 */
public class RoomListTester 
{

	public static void main(String[] args) 
	{
		RoomList myRL = new RoomList();
		
		System.out.println("Current Rooms in List: ");
		for(int i = 0; i< myRL.getroomList().size();i++)
		{
		
			System.out.println(myRL.getroomList().get(i).getName()+ "\n Description of Room: " + myRL.getRoom(myRL.getroomList().get(i).getName()).getDescription()
					
																  + "\n The next Room: " + myRL.getRoom(myRL.getroomList().get(i).getName()).getNextRoom()
																  
																  + "\n The previous Room: " + myRL.getRoom(myRL.getroomList().get(i).getName()).getPreviousRoom()
																  
																  + "\n The encounter chance: " + myRL.getRoom(myRL.getroomList().get(i).getName()).getEncounterChance()
																  
																  + "\n The local monster in the room: " + myRL.getRoom(myRL.getroomList().get(i).getName()).getLocalMonster()
																  
																  + "\n Empty room Description: " + myRL.getRoom(myRL.getroomList().get(i).getName()).getEmptyRoom() + "\n");
			
		}
		
		
		System.out.println("Error Room Test: ");
		System.out.println(myRL.getRoom("Not Room").getName()
				
							+ "\n Description of Room: " + myRL.getRoom("Not Room").getDescription()
							
							+ "\n The next Room: " + myRL.getRoom("Not Room").getNextRoom()
							
							+ "\n The previous Room: " + myRL.getRoom("Not Room").getPreviousRoom()
							
							+ "\n The encounter chance: " + myRL.getRoom("Not Room").getEncounterChance()
							
							+ "\n The local monster in the room: " + myRL.getRoom("Not Room").getLocalMonster()
							
							+ "\n Empty room Description: " + myRL.getRoom("Not Room").getEmptyRoom());
		
		
	
		// TODO Auto-generated method stub*/

	}

}
