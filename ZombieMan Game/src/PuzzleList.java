package src;

import java.util.ArrayList;

public class PuzzleList
{

	private int numberofquestion; 
	private ArrayList<String> questionList; 
	private ArrayList<String> answer1; 
	private ArrayList<String> answer2; 
	private ArrayList<String>answer3; 
	private ArrayList<Integer> correctAnswer; 
	
	public PuzzleList() 
	
	{
		
		// AarrayList of the Puzzle list are added for each questions and their Possible Answers. 
		
		questionList.add("What pill did Neo get from Morpheus? "); 
		answer1.add("Red Pill");
		answer2.add("Blue Pill");
		answer3.add("Green Pill");
		correctAnswer.add(1);
		
		questionList.add("How did Steve Rogers become Captain America? "); 
		answer1.add("Blasted with Gamma Rays ");
		answer2.add("Came for foreign Planet ");
		answer3.add("Injected with the Super Hero Serum");
		correctAnswer.add(3);
		
		
		questionList.add("The Hindenburg was filled with this gas? "); 
		answer1.add("Helium ");
		answer2.add("Argon ");
		answer3.add("Hydrogen ");
		correctAnswer.add(3);
		
		questionList.add("When cutting steak, a chef uses what kind of knife? "); 
		answer1.add("Pairing Knife");
		answer2.add("Serrated Knife ");
		answer3.add("Chef's Knife");
		correctAnswer.add(3);
		
		questionList.add("The disease that has been eradicated world wide but kept at the CDC?"); 
		answer1.add("Malaria");
		answer2.add("Small Pox");
		answer3.add("Ebola ");
		correctAnswer.add(2);
		
		questionList.add("Knowledge is power. Time is money. Power = work over time. Therefore what? "); 
		answer1.add("The less you know the more money you get");
		answer2.add("Really, a physics problem");
		answer3.add("Really a management problem");
		correctAnswer.add(1);
		
		questionList.add("Vaccine Puzzle"); 
		answer1.add("question 1 answer");
		answer2.add("question 2 answer");
		answer3.add("question 3 answer");
		correctAnswer.add(2);
		
	}	
	
	
	 
    public String getnumberofquestion(int questionNumber)
   {
    return questionList.get ( numberofquestion );
   }	
   
    public String getquestionList() 
    {
	   return questionList; 
    }
   
    public String getanswer1 (String answer1)
    {
	    return answer1.get (answer1);
    }
   
    public String getanswer2 ()
    {
	    return answer2; 
    }
   
    public String getanswer3 ()
    {
	    return answer3; 
    }
   
    public int correctAnswer ()
    {  
    	return correctAnswer;
    }
   
		
  }

