package src;

public class MonsterTester {
	
	public static void main(String[] args)
	{
		Monster testMonster = new Monster("Test Monster", "Test Monster Clue", "Test Monster Description", 50);
		System.out.println(testMonster);
		
		System.out.println(testMonster.getName());
		System.out.println(testMonster.getClue());
		System.out.println(testMonster.getDescription());
		System.out.println(testMonster.getCTH());
		System.out.println(testMonster.getHitPoints());
	}

}
