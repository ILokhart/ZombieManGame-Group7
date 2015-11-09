package src;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class: Game
 * 
 * @author Jacob Piazza 
 * @version 1.0 
 * Course : ITEC 3150 Fall 2015
 * Written: Nov 4, 2015
 *  
 *      This class ...  
 * 
 *      Purpose:
 * 
 */
public class Game
{
	private final String PLAYERLIST = "PlayerList.txt";
	private Player player;
	private Room currentRoom;
	private MonsterList mL;
	private PuzzleList pL;
	private RoomList rl;
	private boolean passMainMenu = false;

	/** 
	 * Method: startMainMenu
	 * <description>
	 * Note:
	 *  
	 */
	public void startMainMenu()
	{
		//Game title and introduction
		System.out.println("Welcome ZOMBIEMAN!");
		
		//Main menu is kept in a loop until a new game is created or a saved game is loaded
		while (!passMainMenu)
		{
			//Print main menu
			System.out.println("\nMAIN MENU (Select an option):");
			System.out.println("1. Start a new game");
			System.out.println("2. Load a saved game");

			//Get menu selection from the user
			Scanner input = new Scanner(System.in);
			String selection = input.nextLine();
			
			//If 1, start a new game
			if (selection.equals("1"))
			{
				//Ask the user for their name
				System.out.println("\nPlease enter your name:");
				String userName = input.nextLine();
				//User name validation
				if (userName.length() > 0 && userName != null && !userName.contains(" "))
				{
					this.newGame(userName);
				}
				else
				{
					System.out.println("\nUser name must contain contain characters and no spaces.");
				}
			}
			//If 2, load an existing game
			else if (selection.equals("2"))
			{
				// TODO pass this boolean to the loadState method
				passMainMenu = true;
				System.out.println("\nThis will load a new game");
			}
			//If 3, exit the program
			else if (selection.equals("3"))
			{
				System.exit(0);
			}
			//If anything else, restart the main menu loop
			else
			{
				System.out.println("\nThat was not a valid selection.");
				System.out.println("Please choose from the following:");
			}
		}
	}

	/** 
	 * Method: newGame
	 * <description>
	 * Note:
	 *  
	 * @param userName
	 */
	public void newGame(String userName)
	{
		//Declare file reading/writing classes
		FileReader fr = null;
		Scanner fileIn = null;
		PrintWriter pw = null;
		

		//Build a string of users in PlayerList.txt for rewriting
		String userString = "";
		
		try
		{
			//Instantiate file reading objects
			fr = new FileReader(PLAYERLIST);
			fileIn = new Scanner(fr);
			
			//Read through PlayerList.txt in while loop
			while (fileIn.hasNext())
			{
				String nextName = fileIn.nextLine();
				//Check for existing user names
				if (nextName.equals(userName))
				{
					System.out.println("\nA player with this name already exists.");
					fr.close();
					fileIn.close();
					return;
				}
				//userString String builder with new line tags
				userString = userString + nextName + "\n";
			}
			
			//Add new user name to userString for rewriting
			userString = userString + userName;
			
			//Close file reading objects and instantiate file writing objects
			fr.close();
			fileIn.close();
			pw = new PrintWriter(PLAYERLIST);
			
			//Write new user list to PlayerList.txt and close file writing objects
			pw.print(userString);
			pw.close();
			
			//Create a new player object with userName
			//player = new Player(userName);

			passMainMenu = true;
		}
		catch (FileNotFoundException e)
		{
			System.out.println("ERROR: PlayerList.txt is missing!");
		}
		catch (IOException e)
		{
			System.out.println("ERROR: Something went wrong (fr.close)");
		}
		
		//rl = new RoomList();
		//pl = new PuzzleList();
		//ml = new MonsterList();
	}

	/** 
	 * Method: loadState
	 * <description>
	 * Note:
	 *  
	 */
	public void loadState()
	{

	}

	/** 
	 * Method: saveState
	 * <description>
	 * Note:
	 *  
	 */
	public void saveState()
	{

	}

	/** 
	 * Method: moveToRoom
	 * <description>
	 * Note:
	 *  
	 * @param r
	 */
	public void moveToRoom(Room r)
	{
		// print out rooms available to move to
		// replace current room with selected room
		// startEncounter
	}

	/** 
	 * Method: startEncounter
	 * <description>
	 * Note:
	 *  
	 */
	public void startEncounter()
	{
		// generate encounter value
		// based on current room encounterValues start monster/puzzle/nothing
	}

	/** 
	 * Method: main
	 * <description>
	 * Note:
	 *  
	 * @param args
	 */
	public static void main(String[] args)
	{
		Game game = new Game();
		game.startMainMenu();

	}

}
