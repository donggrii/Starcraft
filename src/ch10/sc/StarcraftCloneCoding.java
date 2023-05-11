package ch10.sc;

import java.util.Arrays;

import ch10.sc.unit.Marine;
import ch10.sc.unit.Unit;
import ch10.sc.unit.Zealot;
import ch10.sc.unit.Zergling;

public class StarcraftCloneCoding {
	
	static Marine[] marines;
	static Zergling[] zerglings;
	static Zealot[] zealots;
	
	public static void main(String[] args) {
//		int numOfMarines = 5;
//		Marine[] marines = new Marine[numOfMarines]; // 배열 객체만 담은 것
//		
//		for (int i = 0; i < numOfMarines; i++) {
//			marines[i] = new Marine(i + 1);
//		}
		
		initUnits();
		reportAllUnits();
		
		System.out.println("마린이 저글링에 대해 2회 공격 후\n");
		marines[0].attack(zerglings[0], 2);
		zerglings[0].reportStatus();
		
	}
	
	static void initUnits() {
		marines = new Marine[] {
				new Marine(1), new Marine(2), new Marine(3), new Marine(4), new Marine(5)	
		};
		
		zerglings = new Zergling[] {
				new Zergling(1)
		};
		
		zealots = new Zealot[] {
				new Zealot(), new Zealot(2)
		};
	}
	
	static void reportAllUnits() {
//		reportUnits(marines);
//		reportUnits(zerglings);
//		reportUnits(zealots);
		System.out.println(zerglings[0]);
	}
	
	static void reportUnits(Unit[] units) {
		for (Unit unit : units) {
			unit.reportStatus();
		}
	}

}
