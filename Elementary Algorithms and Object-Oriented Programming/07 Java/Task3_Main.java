package at.fhv.mme.exercise07.task03;

import java.util.List;

/**
 * Main class for exercise 07, task 03
 * 
 * @author 	Matthias Meier
 * @date	2021-06-08
 */

public class Main {
	public static void main(String[] args) {
		Cheese testCheese = new Cheese();
		testCheese.printCheeseStructure();
		List<Integer> testCheeseHoles = testCheese.searchForHoles();
		
		int testCheeseBiggestHole = 0;
		for (Integer i : testCheeseHoles) {
			if (i > testCheeseBiggestHole) {
				testCheeseBiggestHole = i;
			}
		}
		
		System.out.println("Number of holes: " + testCheeseHoles.size());
		System.out.println("Biggest hole:    " + testCheeseBiggestHole);
	}
}