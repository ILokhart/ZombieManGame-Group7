package src;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
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
		// Game title and introduction
		System.out.println("");
		System.out.println("");
		System.out.println("▒███████▒ ▒█████   ███▄ ▄███▓ ▄▄▄▄    ██▓▓█████  ███▄ ▄███▓ ▄▄▄       ███▄    █ ");
		System.out.println("▒ ▒ ▒ ▄▀░▒██▒  ██▒▓██▒▀█▀ ██▒▓█████▄ ▓██▒▓█   ▀ ▓██▒▀█▀ ██▒▒████▄     ██ ▀█   █ ");
		System.out.println("░ ▒ ▄▀▒░ ▒██░  ██▒▓██    ▓██░▒██▒ ▄██▒██▒▒███   ▓██    ▓██░▒██  ▀█▄  ▓██  ▀█ ██▒");
		System.out.println("  ▄▀▒   ░▒██   ██░▒██    ▒██ ▒██░█▀  ░██░▒▓█  ▄ ▒██    ▒██ ░██▄▄▄▄██ ▓██▒  ▐▌██▒");
		System.out.println("▒███████▒░ ████▓▒░▒██▒   ░██▒░▓█  ▀█▓░██░░▒████▒▒██▒   ░██▒ ▓█   ▓██▒▒██░   ▓██░");
		System.out.println("░▒▒ ▓░▒░▒░ ▒░▒░▒░ ░ ▒░   ░  ░░▒▓███▀▒░▓  ░░ ▒░ ░░ ▒░   ░  ░ ▒▒   ▓▒█░░ ▒░   ▒ ▒ ");
		System.out.println("░░▒ ▒ ░ ▒  ░ ▒ ▒░ ░  ░      ░▒░▒   ░  ▒ ░ ░ ░  ░░  ░      ░  ▒   ▒▒ ░░ ░░   ░ ▒░");
		System.out.println("░ ░ ░ ░ ░░ ░ ░ ▒  ░      ░    ░    ░  ▒ ░   ░   ░      ░     ░   ▒      ░   ░ ░ ");
		System.out.println("  ░ ░        ░ ░         ░    ░       ░     ░  ░       ░         ░  ░         ░ ");
		System.out.println("░                                  ░                                            ");
		// Main menu is kept in a loop until a new game is created or a saved
		// game is loaded
		while (!passMainMenu)
		{
			// Print main menu
			System.out.println("\n\t\t\t     MAIN MENU");
			System.out.println("\t\t\t1. Start a new game");
			System.out.println("\t\t\t2. Load a saved game");
			System.out.println("\t\t\t3. Exit");

			// Get menu selection from the user
			Scanner input = new Scanner(System.in);
			String selection = input.nextLine();

			// If 1, start a new game
			if (selection.equals("1"))
			{
				// Ask the user for their name
				System.out.println("\nPlease enter your name:");
				String userName = input.nextLine();
				// User name validation
				if (userName.length() > 0 && userName != null && !userName.contains(" "))
				{
					this.newGame(userName);
				}
				else
				{
					System.out.println("\nUser name must contain contain characters and no spaces.");
					System.out.println("Returning to main menu.");

				}
			}
			// If 2, load an existing game
			else if (selection.equals("2"))
			{
				this.loadState();
			}
			// If 3, exit the program
			else if (selection.equals("3"))
			{
				System.out.println("\n\t\t\tThank you for playing ZombieMan!");
				System.exit(0);
			}
			// If anything else, restart the main menu loop
			else
			{
				System.out.println("\nThat was not a valid selection.");
				System.out.println("Returning to main menu.");
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
		// Declare file reading/writing classes
		FileReader fr = null;
		Scanner fileIn = null;
		PrintWriter pw = null;

		// Build a string of users in PlayerList.txt for rewriting
		String userString = "";

		try
		{
			// Instantiate file reading objects
			fr = new FileReader(PLAYERLIST);
			fileIn = new Scanner(fr);

			// Read through PlayerList.txt in while loop
			while (fileIn.hasNext())
			{
				String nextName = fileIn.nextLine();
				// Check for existing user names
				if (nextName.equals(userName))
				{
					System.out.println("\nA player with this name already exists.");
					System.out.println("Returning to main menu.");
					fr.close();
					fileIn.close();
					return;
				}
				// userString String builder with new line tags
				userString = userString + nextName + "\n";
			}

			// Add new user name to userString for rewriting
			userString = userString + userName;

			// Close file reading objects and instantiate file writing objects
			fr.close();
			fileIn.close();
			pw = new PrintWriter(PLAYERLIST);

			// Write new user list to PlayerList.txt and close file writing
			// objects
			pw.print(userString);
			pw.close();

			// Create a new Player with userName entered
			player = new Player(userName);
			this.saveState();

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

		// TODO finish the following for testing
		// rl = new RoomList();
		// pl = new PuzzleList();
		// ml = new MonsterList();
	}

	/** 
	 * Method: loadState
	 * <description>
	 * Note:
	 *  
	 */
	public void loadState()
	{
		// Declare file reading objects
		FileReader fr = null;
		Scanner inputScan = null;
		Scanner userInput = null;
		ObjectInputStream inputStream = null;
		
		// Initiate load dialog
		System.out.println("\nWho are you? (enter a number)");
		
		// Initialize file reading objects
		try
		{
			fr = new FileReader(PLAYERLIST);
			inputScan = new Scanner(fr);
			userInput = new Scanner(System.in);
		}
		catch(FileNotFoundException e)
		{
			System.out.println("ERROR: Unable to find player list.");
			System.out.println("ERROR: Please ensure " + PLAYERLIST + " is in the correct location.");
		}
		
		// Output all users available to load and temp store them in userList AL
		ArrayList<String> userList = new ArrayList<String>();
		int userCount = 1;
		while(inputScan.hasNext())
		{
			String user = inputScan.nextLine();
			System.out.println(userCount + ". " + user);
			userList.add(user);
			userCount += 1;
		}
		
		// Get user name selection
		int selection;
		try
		{
			selection = userInput.nextInt();			
		}
		catch(InputMismatchException e)
		{
			System.out.println("\nThat was not a valid selection.");
			System.out.println("Returning to main menu.");
			return;
		}
		
		// Load selection from player list or return to main menu
		if(selection <= userList.size() && selection > 0)
		{
			String userFile = userList.get(selection - 1) + ".dat";
			try
			{
				System.out.println("\n\tLoading . . . ");
				inputStream = new ObjectInputStream(new FileInputStream(userFile));
				this.player = (Player) inputStream.readObject();
				System.out.print("\tComplete!\n");
				passMainMenu = true;
			}
			catch(IOException e)
			{
				System.out.println("ERROR: There was a problem reading " + userFile + ".");
			}
			catch (ClassNotFoundException e)
			{
				System.out.println("ERROR: Cannot read file. Player object is missing or corrupt.");
			}
		}
		else
		{
			System.out.println("\nThat was not a valid selection.");
			System.out.println("Returning to main menu.");
			return;
		}
		
		// Close file reading objects
		try
		{
			fr.close();
			inputScan.close();
			userInput.close();
			inputStream.close();
		}
		catch(Exception e)
		{
			System.out.println("ERROR: Something went wrong while closing input objects.");
		}
		
	}

	/** 
	 * Method: saveState
	 * <description>
	 * Note:
	 *  
	 */
	public void saveState()
	{
		System.out.println("\n\tSaving . . . ");
		
		// Build userFile string based on player name
		String userFile = player.getName() + ".dat";
		
		// Declare file writing object
		ObjectOutputStream output = null;
		
		// Initialize file writing objects and write user data to file
		try
		{
			output = new ObjectOutputStream(new FileOutputStream(userFile));
			output.writeObject(player);
			System.out.print("\tComplete!\n");
		}
		catch(FileNotFoundException e)
		{
			System.out.println("ERROR: Unable to access user save file.");
			System.out.println("ERROR: Please ensure " + userFile + " file is is the correct location.");
		}
		catch(IOException e)
		{
			System.out.println("ERROR: Unable to write user save file.");
			System.out.println("ERROR: Please ensure " + userFile + " file is not being used by another program.");
			e.printStackTrace();
		}
		
		// Close file writing objects
		try
		{
			output.close();
		}
		catch(IOException e)
		{
			System.out.println("ERROR: ObjectOutputStream was never initialized.");
		}
	}

	/** 
	 * Method: moveToRoom
	 * <description>
	 * Note:
	 *  
	 * @param room
	 */
	public void moveToRoom(String room)
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
		System.out.println("\nPerhaps we should start from the begining...\n");
	}

}
