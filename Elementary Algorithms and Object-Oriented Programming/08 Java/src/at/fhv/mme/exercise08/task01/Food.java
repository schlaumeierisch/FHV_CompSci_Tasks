package at.fhv.mme.exercise08.task01;

public class Food extends Item {
	public Food(String name, String description) {
		super(name, description);
	}
	
	public void consume() {
		if (getName() == "beer") {
			System.out.println("Although it tastes very good, you should not drink too much of it.");
		} else if (getName() == "water") {
			System.out.println("Healthy, cold water - what could be better?");
		} else if (getName() == "bread") {
			System.out.println("A little snack in between never hurts.");
		}
	}
}