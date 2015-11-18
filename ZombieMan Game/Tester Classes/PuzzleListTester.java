import java.util.ArrayList;


public class PuzzleListTester extends PuzzleList {
	private static final int num = 0;
	private ArrayList<String> questionList;
	private ArrayList<String> answer1;
	private ArrayList<String> answer2;
	private ArrayList<String> answer3;
	private ArrayList<Integer> correctAnswer;


	public PuzzleListTester() {
	
		PuzzleList testPuzzleList = new PuzzleList();
		{
		questionList.add("What pill did Neo get from Morpheus? ");
		answer1.add("Red Pill");
		answer2.add("Blue Pill");
		answer3.add("Green Pill");
		correctAnswer.add(1);
		}
		
		{
			System.out.println(testPuzzleList);
			System.out.println(this.getQuestion(num));
			System.out.println(this.getAnswer1(num));
			System.out.println(this.getAnswer2(num));
			System.out.println(this.getAnswer3(num));
			
		}


	}
}
