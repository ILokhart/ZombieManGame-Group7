package src;

import java.io.File;
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
 *      This class will control the game flow and manage user profiles
 * 
 *      Purpose: To bring together all game objects and conduct game activity
 * 
 */
public class Game
{
	private final String PLAYERLIST = "PlayerList.txt";
	private Player player;
	private Room currentRoom;
	private MonsterList mL;
	private PuzzleList pL;
	private RoomList rL;
	private boolean passMainMenu = false;

	/** 
	 * Method: startMainMenu
	 * Game begins with the main menu. Main menu is passed once a Player object is created or loaded
	 * Note: .java file is UFT-8 encoded to preserve logo art. If encoding is lost and the
	 *    logo art is distorted, revert to the original save or find alternate art from
	 *    "http://patorjk.com/software/taag/#p=display&f=Graffiti&t=Type%20Something%20"
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

		// Main menu is kept in a loop until a new game (Player) is created or a
		// saved
		// game (Player) is loaded
		while (!passMainMenu)
		{
			// Create PlayerList.txt if it doesn't exist
			File playerListFile = new File(PLAYERLIST);
			if (!playerListFile.exists())
			{
				try
				{
					playerListFile.createNewFile();
				}
				catch (IOException e)
				{
					System.out.println("\nERROR: Unable to create PlayerList.txt");
				}
			}

			// Print main menu
			System.out.println("\nMAIN MENU");
			System.out.println("1. Start a new game");
			System.out.println("2. Load a saved game");
			System.out.println("3. Exit");

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
				System.out.println("\nThank you for playing ZombieMan!");
				System.exit(0);
			}
			// If anything else, restart the main menu loop
			else
			{
				System.out.println("\nThat was not a valid selection.");
				System.out.println("Returning to main menu.");
			}

			input.close();
		}

		// Create the remaining game Objects
		this.rL = new RoomList();
		this.pL = new PuzzleList();
		this.mL = new MonsterList();
	}

	/** 
	 * Method: newGame
	 * New game is started from the main menu. It will create a new player.
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
		
		//TODO Change start room to hospital
		currentRoom = rL.getRoom("Test Room 1");
	}

	/** 
	 * Method: loadState
	 * This method is started from the main menu. It will load a user selected player from disk
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
		catch (FileNotFoundException e)
		{
			System.out.println("ERROR: Unable to find player list.");
			System.out.println("ERROR: Please ensure " + PLAYERLIST + " is in the correct location.");
		}

		// Output all users available to load and temp store them in userList AL
		ArrayList<String> userList = new ArrayList<String>();
		int userCount = 1;
		while (inputScan.hasNext())
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
		catch (InputMismatchException e)
		{
			System.out.println("\nThat was not a valid selection.");
			System.out.println("Returning to main menu.");
			return;
		}

		// Load userList selection from data file or return to main menu
		if (selection <= userList.size() && selection > 0)
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
			catch (IOException e)
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
		catch (Exception e)
		{
			System.out.println("ERROR: Something went wrong while closing input objects.");
		}

	}

	/** 
	 * Method: saveState
	 * This method is called when creating a new player, when the game is exited, or at the users will
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
		catch (FileNotFoundException e)
		{
			System.out.println("ERROR: Unable to access user save file.");
			System.out.println("ERROR: Please ensure " + userFile + " file is is the correct location.");
		}
		catch (IOException e)
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
		catch (IOException e)
		{
			System.out.println("ERROR: ObjectOutputStream was never initialized.");
		}
	}

	/** 
	 * Method: moveToRoom
	 * This method is used to control navigation between rooms.
	 * Note:
	 *  
	 * @param room
	 */
	public void moveToRoom()
	{
		// Prompt for direction
		System.out.println("\nWhich direction would you like to go?");
		System.out.println("1. Forward");
		System.out.println("2. Backward");

		// Get direction choice from user
		Scanner input = new Scanner(System.in);
		String selection = input.nextLine();

		// If user selects forward display next rooms and move to selection
		if (selection.equals("1"))
		{
			// Check to see if there are any rooms to move forward into
			if (currentRoom.getNextRoom().size() == 0)
			{
				System.out.println("\nThere doesn't seem to be anything in that direction.");
			}
			else
			{
				// If there are next rooms get the user choice for next room
				int roomChoice;
				System.out.println("\nChoose a location.");
				for (int i = 0; i < currentRoom.getNextRoom().size() - 1; i++)
				{
					System.out.println((i + 1) + ". " + currentRoom.getNextRoom().get(i));
				}

				// Validate user input
				try
				{
					roomChoice = input.nextInt();
				}
				catch (InputMismatchException e)
				{
					System.out.println("\nThat was not a valid selection.");
					input.close();
					return;
				}

				// Move to next room choice
				if (roomChoice <= currentRoom.getNextRoom().size() && roomChoice > 0)
				{
					currentRoom = rL.getRoom(currentRoom.getNextRoom().get(roomChoice - 1));
					// Output the current room descripion before starting an event
					System.out.println("\nYou observe your surroundings: " + currentRoom.getDescription());
				}
			}
		}

		// If user selects backward move to previous room
		else if (selection.equals("2"))
		{
			if (!currentRoom.getName().equals("Hospital"))
			{
				currentRoom = rL.getRoom(currentRoom.getPreviousRoom());
			}
			else
			{
				System.out.println("\nThere doesn't seem to be anything in that direction.");
			}
		}

		// If user enters a non-option...
		else
		{
			System.out.println("\nThat was not a valid selection.");
		}

		input.close();
	}

	/** 
	 * Method: startEncounter
	 * This method is called after the user navigates into a new room. It will generate a random type of encounter
	 * Note:
	 *  
	 */
	public void startEncounter()
	{		
		int encounterChance = (int) (Math.random() * 100);
		// TODO Remove encounterChance SOP
		System.out.println("\nEncounter chance roll: " + encounterChance);

		if (encounterChance >= currentRoom.getEncounterChance())
		{
			this.solvePuzzle();
			// TODO Complete encounter feedback
			System.out.println("\nYou got a Puzzle.");
		}
		else if (encounterChance >= 80)
		{
			this.fightMonster();
			// TODO Complete encounter feedback
			System.out.println("\nYou got a Monster.");
		}
		else
		{
			System.out.println("\n" + currentRoom.getEmptyRoom());
		}
	}

	/** 
	 * Method: solvePuzzle
	 * 
	 * Note:
	 *  
	 */
	public void solvePuzzle()
	{
		// Puzzle intro
		System.out.println("\nGlyphs appear out of thin air.");
		System.out.println("They float in front you and begin to form a question.");

		// Generate int to pull a random puzzle
		int questionNum = (int) (Math.random() * pL.getNumberOfQuestion());
		// TODO remove questionNum output
		System.out.println("Generated question number: " + questionNum);

		// Display question and answers
		System.out.println("\n" + pL.getQuestion(questionNum));
		System.out.println("1. " + pL.getAnswer1(questionNum));
		System.out.println("2. " + pL.getAnswer2(questionNum));
		System.out.println("3. " + pL.getAnswer3(questionNum));
		System.out.println("\nChoose wisely: ");

		// Get user choice and evaluate
		Scanner puzzleInput = new Scanner(System.in);
		int puzzleChoice;
		try
		{
			puzzleChoice = puzzleInput.nextInt();
		}
		catch (InputMismatchException e)
		{
			puzzleChoice = -1;
		}
		
		if(puzzleChoice == pL.correctAnswer(questionNum))
		{
			System.out.println("\nYou chose wisely.");
			System.out.println("\nThe question begins to disolve and seeps into your flesh.");
			System.out.println("You feel more powerful.");
			player.getInventory().addSolvedPuzzles();
		}
		else if(puzzleChoice < 0 && puzzleChoice < 4)
		{
			System.out.println("\nYou chose poorly.");
			System.out.println("\nThe question disolves into the air around you.");
		}
		else
		{
			System.out.println("\nYour response is unclear.");
			System.out.println("\nThe question disolves into the air around you.");
		}
		puzzleInput.close();
	}

	/** 
	 * Method: fightMonster
	 * <description>
	 * Note:
	 *  
	 */
	public void fightMonster()
	{
		// Get monster associated with currentRoom and output descriptions
		Monster monster = mL.getMonster(currentRoom.getLocalMonster());
		//TODO chage this announcement to something legit
		System.out.println("\nA wild " + monster.getName() + " has appeared.");
		System.out.println(monster.getDescription());
		
		for (int i = 0; i < 5; i++)
		{
			System.out.println("\nRound " + (i + 1) + " of 5.");
			// Generate hit value and compare
			int mHitValue = (int)(Math.random() * 101);
			int pHitValue = (int)(Math.random() * 101);
			
			// Wait x000 seconds
			try
			{
				Thread.sleep(2000);
			}
			catch(InterruptedException e)
			{
			}
			
			// Player turn per round
			if(pHitValue < player.getCTH())
			{
				System.out.println("\nYou attack the " + monster.getName() + " and HIT.");
				player.plusHitPoints();
			}
			else
			{
				System.out.println("\nYou attack the " + monster.getName() + " and MISS.");
			}
			
			// Monster turn per round
			if(mHitValue < monster.getCTH())
			{
				System.out.println("\nThe " + monster.getName() + " attacks you and HITS.");
				monster.plusHitPoints();
			}
			else
			{
				System.out.println("\nThe " + monster.getName() + " and MISSES.");
			}
			
			// Wait x000 seconds
			try
			{
				Thread.sleep(2000);
			}
			catch(InterruptedException e)
			{
			}
		}
		
		// Evaluate fight outcome
		if(player.getHitPoints() >= monster.getHitPoints())
		{
			System.out.println("\nYou have killed the " + monster.getName());
			System.out.println("As you consume him you can feel his knowledge coursing through your veins.");
			System.out.println("A voice in the back of your mind whispers: " + monster.getClue());
			player.getInventory().addClue(monster.getClue());
		}
		else
		{
			System.out.println("The " + monster.getName() + " has injured you gravely and you loose 1 life.");
			player.minusLife();
		}
	}
	
	public int getPlayerLives()
	{
		return this.player.getLives();
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
		
		boolean gameOver = false;
		while(!gameOver)
		{
			game.moveToRoom();
			game.startEncounter();
			if(game.getPlayerLives() == 0)
			{
				gameOver = true;
			}
		}
		System.out.println("GAME OVER");
		
	}

}
