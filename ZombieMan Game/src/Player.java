package src;



import java.io.Serializable;

/**
 * @author Jonathan Mayran
 *
 */
public class Player implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private int lives;
	private int hitPoints;
	private final int BASE_CTH = 30;
	private Inventory inventory;
	private Room savedRoom;
	
	public Player(String name)
	{
		this.name = name;
		lives = 3;
		hitPoints = 0;
		inventory = new Inventory();
	}
	
	public void setSavedRoom(Room currentRoom)
	{
		this.savedRoom = currentRoom;
	}
	
	public Room getSavedRoom()
	{
		return this.savedRoom;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public void minusLife()
	{
		if(this.lives > 0)
		{
			lives -= 1;
		}
		else
		{
			System.out.println("You are dead! Game over.");
		}
	}
	
	public int getLives()
	{
		return this.lives;
	}
	
	public int getHitPoints()
	{
		return this.hitPoints;
	}
	
	public void plusHitPoints()
	{
		this.hitPoints += 1;
	}
	
	public void resetHitPoints()
	{
		this.hitPoints = 0;
	}
	
	public int getCTH()
	{
		int calculatedCTH = BASE_CTH + (inventory.getSolvedPuzzles() * 10);
		return calculatedCTH;
	}
	
	public Inventory getInventory()
	{
		return inventory;
	}
	
}
