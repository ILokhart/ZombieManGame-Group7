package src;

import java.util.ArrayList;

public class Inventory
{
	private int solvedPuzzles;
	ArrayList<String> clueList = new ArrayList<String>();
	
	public int getSolvedPuzzles()
	{
		return solvedPuzzles;
	}
	public void addSolvedPuzzles()
	{
		this.solvedPuzzles += 1;
	}
}