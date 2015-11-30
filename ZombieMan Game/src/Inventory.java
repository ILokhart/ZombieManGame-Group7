package src;



import java.io.Serializable;
import java.util.ArrayList;

public class Inventory implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
		boolean newClue = true;
		for (int i = 0; i < clueList.size(); i++)
		{
			if(clueList.get(i).equals(clue))
			{
				newClue = false;
			}
		}
		if(newClue == true)
		{
			clueList.add(clue);
		}
	}
	
	public String getClue(int clueNum)
	{
		return clueList.get(clueNum);
	}
	
	public int getClueListSize()
	{
		return clueList.size();
	}
	
}