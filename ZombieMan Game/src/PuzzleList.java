package src;

public class PuzzleList
{

	private int numberofquestion; 
	private String questionList; 
	private String answer1; 
	private String answer2; 
	private String answer3; 
	private int correctAnswer; 
	
	public PuzzleList ( int numberofquestion, String questionList, String answer1, 
			              String answer2, String answer3, int correctAnswer){
}
	 
    public int getnumberofquestion()
   {
    return numberofquestion;
   }	
   
    public String getquestionList() 
    {
	   return questionList; 
    }
   
    public String getanswer1 ()
    {
	    return answer1;
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

