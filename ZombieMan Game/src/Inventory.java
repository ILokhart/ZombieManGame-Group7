


import java.io.Serializable;
import java.util.ArrayList;

public class Inventory implements Serializable
{
	private int solvedPuzzles;
	private ArrayList<String> clueList;
	
	public Inventory()
	{
		solvedPuzzles = 0;
		clueList = new ArrayList<String>();
	}
	
	public int getSolvedPuzzles()
	{
		return solvedPuzzles;
	}
	
	public void addSolvedPuzzles()
	{
		this.solvedPuzzles += 1;
	}
	
	public void addClue(String clue)
	{
		clueList.add(clue);
	}
	
	public int getClueListSize()
	{
		return clueList.size();
	}
	
	public String getClue(int clueNum)
	{
		return clueList.get(clueNum);
	}
}