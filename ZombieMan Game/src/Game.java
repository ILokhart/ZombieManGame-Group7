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
	private Monster currentMonster;
	private MonsterList mL = new MonsterList();
	private PuzzleList pL = new PuzzleList();
	private RoomList rL = new RoomList();
	private boolean passMainMenu = false;
	private boolean gameOver = false;
	private Scanner userInput = new Scanner(System.in);

	/** 
	 * Method: startMainMenu
	 * Game begins with the main menu. Main menu is passed once a Player object is created or loaded
	 * Note: .java file is UFT-8 encoded to preserve logo art. If encoding is lost and the
	 *    logo art is distorted, revert to the original save or find alternate art from
	 *    "http://patorjk.com/software/taag/#p=display&f=Graffiti&t=Type%20Something%20"
	 *  
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
		// saved game (Player) is loaded
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
			int selection;
			try
			{
				selection = userInput.nextInt();
				userInput.nextLine();
			}
			catch(InputMismatchException e)
			{
				selection = -1;
			}

			// If 1, start a new game
			if (selection == 1)
			{
				// Ask the user for their name
				System.out.println("\nPlease enter your name:");
				String userName = userInput.nextLine();
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
			else if (selection == 2)
			{
				this.loadState();
			}
			// If 3, exit the program
			else if (selection == 3)
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
		}

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

		// Starting room is set to Hospital
		currentRoom = rL.getRoom("Hospital");

		// Intro dialog
		System.out.println("\nYou wipe your eyes and open them.");
		System.out.println("As your vision comes into focus you are overcome with a piercing migrane that blurs your vision again.");
		System.out.println("A sharp ringing tone lingers in your ears.");
		System.out.println("You regain your senses and realize that you're laying in a hospital bed and your hands are covered in blood.");
		System.out.println("You sit up and notice a doctor on the floor, wearing a blood soaked white coat, reaching desperately towards the room door.");
		System.out.println("Some unknown, dark instinct consumes your body as you lunge onto his back and tear at his flesh...");

		//TODO Fix continue
		System.out.println("\nPress enter to continue...");
		userInput.nextLine();

		// Initiate fight with the doctor
		this.setMonster(mL.getMonster("Doctor"));
		this.fightMonster();
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
		ObjectInputStream inputStream = null;

		// Initiate load dialog
		System.out.println("\nWho are you? (enter a number)");

		// Initialize file reading objects
		try
		{
			fr = new FileReader(PLAYERLIST);
			inputScan = new Scanner(fr);
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
			userInput.nextLine();
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
				System.out.println("\nLoading game. . . ");
				inputStream = new ObjectInputStream(new FileInputStream(userFile));
				this.player = (Player) inputStream.readObject();
				this.currentRoom = this.player.getSavedRoom();
				System.out.print("Done.\n");
				System.out.println("\nCurrent location: " + this.currentRoom.getName());
				System.out.println(this.currentRoom.getDescription());
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
		//System.out.println("\nSaving game. . . ");
		this.player.setSavedRoom(currentRoom);

		// Build userFile string based on player name
		String userFile = player.getName() + ".dat";

		// Declare file writing object
		ObjectOutputStream output = null;

		// Initialize file writing objects and write user data to file
		try
		{
			output = new ObjectOutputStream(new FileOutputStream(userFile));
			output.writeObject(player);
			//System.out.print("Done.\n");
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
		boolean moved = false;
		while (!moved)
		{
			System.out.println("\nWhich direction would you like to go?");
			System.out.println("FORWARD or BACKWARD?");

			// Get direction choice from user
			String selection = userInput.nextLine();

			// If user selects forward display next rooms and move to selection
			if (selection.equalsIgnoreCase("forward"))
			{
				// Check to see if there are any rooms to move forward into
				if (currentRoom.getNextRoom().size() == 0)
				{
					System.out.println("\nThere doesn't seem to be anything in that direction.");
				}
				else
				{
					// If there are next rooms get the user choice for next room
					System.out.println("\nChoose a location.");
					for (int i = 0; i < currentRoom.getNextRoom().size(); i++)
					{
						System.out.println((i + 1) + ". " + currentRoom.getNextRoom().get(i));
					}

					// Get user room choice and validate input
					int roomNumber;
					try
					{
						roomNumber = userInput.nextInt();
						//TODO Tag CR clear
						userInput.nextLine();
					}
					catch(InputMismatchException e)
					{
						roomNumber = -1;
					}
					catch (NumberFormatException e)
					{
						roomNumber = -1;
					}

					// Move to next room choice
					if (roomNumber <= currentRoom.getNextRoom().size() && roomNumber > 0)
					{
						this.currentRoom = rL.getRoom(currentRoom.getNextRoom().get(roomNumber - 1));
						System.out.println("\nCurrent Location: " + this.currentRoom.getName());
						System.out.println(currentRoom.getDescription());
						moved = true;
					}
				}
			}

			// If user selects backward move to previous room
			else if (selection.equalsIgnoreCase("backward"))
			{
				if (currentRoom.getPreviousRoom().length() == 0)
				{
					System.out.println("\nThere doesn't seem to be anything in that direction.");
				}
				else
				{
					currentRoom = rL.getRoom(currentRoom.getPreviousRoom());
					currentMonster = mL.getMonster(currentRoom.getLocalMonster());
					System.out.println("\n" + currentRoom.getDescription());
					moved = true;
				}
			}
			else if(selection.equalsIgnoreCase("help"))
			{
				System.out.println("\nYou must type FORWARD or BACKWARD to continue. EXIT to save and quit");
			}
			else if(selection.equalsIgnoreCase("exit"))
			{
				this.saveState();
				System.exit(0);
			}
			// If user enters a non-option...
			else
			{
				System.out.println("\nInvalid input.");
			}
		}

	}

	/** 
	 * Method: startEncounter
	 * This method is called after the user navigates into a new room. It will generate a random type of encounter
	 * Note:
	 *  
	 */
	public void startEncounter()
	{
		// Generate a random encounter chance betwen 0 and 100 and apply to encounter
		boolean initEncounter = false;
		int encounterChance = (int) (Math.random() * 100);
		System.out.println("Encounter chance: " + encounterChance);
		if (encounterChance >= 70)
		{
			System.out.println("\n" + currentRoom.getEmptyRoom());
		}
		else if (encounterChance >= currentRoom.getEncounterChance())
		{
			// Get monster associated with currentRoom and output descriptions
			this.setMonster(mL.getMonster(currentRoom.getLocalMonster()));
			while(!initEncounter)
			{
				System.out.println("\nYou sense a nearby threat.");
				System.out.println("FIGHT or FLEE?");
				
				// Determine if the user would rather fight or flee the encounter
				String selection = userInput.nextLine();
				if(selection.equalsIgnoreCase("fight"))
				{
					initEncounter = true;
					this.fightMonster();
				}
				else if(selection.equalsIgnoreCase("flee"))
				{
					initEncounter = true;
					System.out.println("\nYou quietly shuffle your body into the shadows....");
				}
				else if(selection.equalsIgnoreCase("help"))
				{
					System.out.println("\nYou must type FIGHT or FLEE to continue. EXIT to save and quit.");
				}
				else if(selection.equalsIgnoreCase("exit"))
				{
					this.saveState();
					System.exit(0);
				}
				else
				{
					System.out.println("\nInvalid input.");
				}
			}
		}
		else
		{
			while(!initEncounter)
			{
				System.out.println("\nYou sense a strange presence nearby.");
				System.out.println("SEARCH or IGNORE?");
				
				// Determine if the user would rather fight or flee the encounter
				String selection = userInput.nextLine();
				if(selection.equalsIgnoreCase("search"))
				{
					initEncounter = true;
					this.solvePuzzle();
				}
				else if(selection.equalsIgnoreCase("ignore"))
				{
					initEncounter = true;
					System.out.println("\nYou quietly pass through the area, eyes forward...");
					
				}
				else if(selection.equalsIgnoreCase("help"))
				{
					System.out.println("\nYou must type SEARCH or IGNORE to continue.");
				}
				else
				{
					System.out.println("\nInvalid input.");
				}
			}
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

		// Display question and answers
		System.out.println("\n" + pL.getQuestion(questionNum));
		System.out.println("1. " + pL.getAnswer1(questionNum));
		System.out.println("2. " + pL.getAnswer2(questionNum));
		System.out.println("3. " + pL.getAnswer3(questionNum));
		System.out.println("\nChoose wisely: ");

		// Get user choice and evaluate
		int puzzleNum;
		try
		{
			puzzleNum = userInput.nextInt();
			//TODO tag CR clear
			userInput.nextLine();

		}
		catch(InputMismatchException e)
		{
			puzzleNum = -1;
		}

		if (puzzleNum == pL.correctAnswer(questionNum))
		{
			System.out.println("\nYou chose wisely.");
			System.out.println("\nThe question begins to disolve and seeps into your flesh.");
			System.out.println("You feel more powerful.");
			System.out.println("(chance to hit +10%)");
			player.getInventory().addSolvedPuzzles();
		}
		else if (puzzleNum > 0 && puzzleNum < 4)
		{
			System.out.println("\nYou chose poorly.");
			System.out.println("The question disolves into the air around you.");
		}
		else
		{
			System.out.println("\nYour response is unclear.");
			System.out.println("The question disolves into the air around you.");
		}
	}

	/** 
	 * Method: fightMonster
	 * <description>
	 * Note:
	 *  
	 */
	public void fightMonster()
	{
		player.resetHitPoints();
		currentMonster.resetHitPoints();
		
		// Introduce the monster to fight
		System.out.println("\nYou have encountered the " + currentMonster.getName() + "!");
		System.out.println(currentMonster.getDescription());
		System.out.println("\n" + this.player.getName() + " chance to hit: " + this.player.getCTH() + "%");
		System.out.println(this.currentMonster.getName() + " chance to hit: " + this.currentMonster.getCTH() + "%");
		System.out.println("Prepare to fight!");


		//TODO Fix continue
		System.out.println("\nContinue...");
		userInput.nextLine();

		for (int i = 0; i < 5; i++)
		{
			System.out.println("\nRound " + (i + 1) + " of 5...");
			// Generate hit value and compare
			int mHitValue = (int) (Math.random() * 101);
			int pHitValue = (int) (Math.random() * 101);


			// Player turn per round
			if (pHitValue < player.getCTH())
			{
				System.out.println("\nYou attack the " + currentMonster.getName() + " and HIT.");
				player.plusHitPoints();
			}
			else
			{
				System.out.println("\nYou attack the " + currentMonster.getName() + " and MISS.");
			}

			// Monster turn per round
			if (mHitValue < currentMonster.getCTH())
			{
				System.out.println("The " + currentMonster.getName() + " attacks you and HITS.");
				currentMonster.plusHitPoints();
			}
			else
			{
				System.out.println("The " + currentMonster.getName() + " attacks you and MISSES.");
			}

			// Wait x000 seconds
			try
			{
				Thread.sleep(2000);
			}
			catch (InterruptedException e)
			{
			}
		}

		System.out.println("\n" + this.player.getName() + " hit " + this.player.getHitPoints() + " times.");
		System.out.println(currentMonster.getName() + " hit " + currentMonster.getHitPoints() + " times.");


		// Evaluate fight outcome
		if (player.getHitPoints() >= currentMonster.getHitPoints())
		{
			System.out.println("\nYou have killed the " + currentMonster.getName() + "!");
			System.out.println(this.player.getLives() + " lives remaining.");

			//TODO Fix continue
			System.out.println("\nContinue...");
			userInput.nextLine();

			System.out.println("\nYour body is driven to consume the brains of your victim and you feel their knowledge course through your veins...");

			if (currentMonster.getClue().length() > 0)
			{
				System.out.println("You can hear the " + currentMonster.getName() + " in the back of your mind...");
				for (int i = 0; i < currentMonster.getClue().length() + 4; i++)
				{
					System.out.print("~");
				}
				System.out.println("\n  " + currentMonster.getClue());
				for (int i = 0; i < currentMonster.getClue().length() + 4; i++)
				{
					System.out.print("~");
				}
				System.out.print("\n");
				player.getInventory().addClue(currentMonster.getClue());
			}
			else
			{
				System.out.println("Their memories become your own.");
			}
		}
		else
		{
			System.out.println("\nThe " + currentMonster.getName() + " has injured you gravely and you loose 1 life.");
			player.minusLife();
			System.out.println("You have " + this.player.getLives() + " lives remaining.");

			this.checkGameOver();
		}
		

	}

	/** 
	 * Method: getGameOver
	 * <description>
	 * Note:
	 *  
	 * @return
	 */
	public boolean getGameOver()
	{
		return this.gameOver;
	}
	
	/** 
	 * Method: setMonster
	 * <description>
	 * Note:
	 *  
	 * @param monster
	 */
	public void setMonster(Monster monster)
	{
		this.currentMonster = monster;
	}
	
	/** 
	 * Method: getPlayer
	 * <description>
	 * Note:
	 *  
	 * @return
	 */
	public Player getPlayer()
	{
		return this.player;
	}
	
	/** 
	 * Method: getCurrentRoom
	 * <description>
	 * Note:
	 *  
	 * @return
	 */
	public Room getCurrentRoom()
	{
		return this.currentRoom;
	}
	
	/** 
	 * Method: getMonsterList
	 * <description>
	 * Note:
	 *  
	 * @return
	 */
	public MonsterList getMonsterList()
	{
		return this.mL;
	}
	
	/** 
	 * Method: checkGameOver
	 * <description>
	 * Note:
	 *  
	 */
	public boolean checkGameOver()
	{
		if(this.player.getLives() <= 0)
		{
			this.gameOver = true;
		}
		return this.gameOver;
	}
	
	public Scanner getScanner()
	{
		return userInput;
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
		// Get things going
		Game game = new Game();
		game.startMainMenu();

		while (!game.getGameOver())
		{
			game.saveState();
			game.moveToRoom();
			if(game.getCurrentRoom().getName().equals("Security"))
			{
				game.setMonster(game.getMonsterList().getMonster("Evil Scientist"));
				game.fightMonster();
			}
			else if(game.getCurrentRoom().getName().equals("Containment"))
			{
				while(!game.checkGameOver())
				{
					System.out.println("\nYou open the cabinet and see multiple vials. Each vial is different.");
					System.out.println("Which one will you take?");
					System.out.println("1. Green crystals");
					System.out.println("2. Green paste");
					System.out.println("3. Red syrup");
					System.out.println("4. Red crystals");
					System.out.println("5. Yellow paste");
					System.out.println("6. Yellow syrup");
					System.out.println("7. LIST ALL CLUES");
					
					String selection = game.getScanner().nextLine();
					int numSelection;
					try
					{
						numSelection = Integer.parseInt(selection);
					}
					catch(NumberFormatException e)
					{
						numSelection = -1;
					}
					
					if(numSelection == 3)
					{
						//TODO finish the outro
						System.out.println("GJ on not dying!");
						System.exit(0);						
					}
					else if(numSelection == 7)
					{
						for (int i = 0; i < game.getPlayer().getInventory().getClueListSize(); i++)
						{
							System.out.println(game.getPlayer().getInventory().getClue(i));
						}
					}
					else if(numSelection > 0 && numSelection < 8)
					{
						System.out.println("\nYou open the vial and consume its contents.");
						System.out.println("Your body wretches in pain.");
						game.getPlayer().minusLife();
					}
					else
					{
						System.out.println("That was not a valid selection. Choose a number 1-6.");
					}
					
				}
			}
			else
			{
				game.startEncounter();
			}
		}
		System.out.println("\nYour body falls to the ground, too weak to support itself. You lay motionless, undead and eternally tormented as the disease ravages your body and your flesh decays.");
		System.out.println("\n~Thank you for playing ZombieMan!~");
	}

}
