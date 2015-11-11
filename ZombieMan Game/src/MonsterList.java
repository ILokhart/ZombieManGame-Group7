package src;

import java.util.ArrayList;

public class MonsterList
{
	private ArrayList<Monster> mL;
	
	public MonsterList()
	{
		mL.add(new Monster("Pharmacist", "Provides the Vaccine color", "monster's des", 24, 52));
		mL.add(new Monster("Pathologist", "provides the confirmation of cure called the vaccine and origin story",
				 "monster's des", 14, 28));
		  mL.add(new Monster("Wrestler", "today", "monster's des", 12, 25));
		  mL.add(new Monster("Survivalist", " 24 h today", "monster's des", 32, 45));
		  mL.add( new Monster("Evil Scientist", " 14 today", "monster's des", 21, 49));
	}
}
