package src;

import java.util.ArrayList;

/**
 * @author Jonathan Mayran
 *
 */
public class Player
{
	private String name;
	private static int minusLives;
	private static int playerHP;
	private final int baseCTH = 30;
	private Inventory playerInventory;
	private int playerCTH = baseCTH + (playerInventory.getSolvedPuzzles() * 10);
	
	
	public String setName()
	{
		return name;
	}
	
	public int setMinusLives()
	{
		return minusLives--;
	}
	
	public int setPlayerHP()
	{
		return playerHP++;
	}
	


}
