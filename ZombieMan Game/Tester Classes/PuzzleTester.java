
import java.util.ArrayList;

/**
 * Class: PuzzleList
 * 
 * @author Bhavan Patel 
 * @version 1.0 
 * Course : ITEC 3860 Fall 2015
 * Written: Nov 7, 2015
 *  
 *      This class is the puzzle list class which stored the question list, available correct answers
 *      for the each of the Puzzles List's Questions and they correct answer as well. Which is stored
 *      into Array List for the each of the attributes. 
 * 
 *      Purpose: 
 * 
 */

public class PuzzleTester
{

	@SuppressWarnings("unused")
	private int numberofquestions;
	private ArrayList<String> questionList;
	private ArrayList<String> answer1;
	private ArrayList<String> answer2;
	private ArrayList<String> answer3;
	private ArrayList<Integer> correctAnswer; 

	public PuzzleTester()

	{
		// AarrayList of the Puzzle list are added for each questions and their
		// Possible Answers.

		questionList.add("What pill did Neo get from Morpheus? ");
		answer1.add("Red Pill");
		answer2.add("Blue Pill");
		answer3.add("Green Pill");
		correctAnswer.add(1);

	System.out.println(questionList,answer1, answer2, answer3,  )
	 
	}
	
}