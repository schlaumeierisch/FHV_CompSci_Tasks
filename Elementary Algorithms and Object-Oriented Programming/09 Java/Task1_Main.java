package at.fhv.mme.exercise09.task01;

import java.time.LocalDate;

/**
 * Ein Fall fürs Standesamt (Exercise 09, Task 01)
 * 
 * @author	Matthias Meier
 * @date	2021-06-25
 */
public class Main {
	public static void main(String[] args) {
		{	/* test case 1: valid marriage */
			System.out.println("test case 1: valid scenario");
			System.out.println("----------------------------");
			Man donald = new Man("Donald", "Duck", LocalDate.of(1980, 1, 1));
			Woman daisy = new Woman("Daisy", "Queen", LocalDate.of(1982, 1, 10));
			Man mickey = new Man("Mickey", "Mouse", LocalDate.of(1979, 5, 5));
			Woman minnie = new Woman("Minnie", "Mouse", LocalDate.of(1981, 3, 15));
			
			System.out.println("Name: " + donald.getFirstName() + " " + donald.getLastName() + "; Age: " + donald.getAge());
			System.out.println("Name: " + daisy.getFirstName() + " " + daisy.getLastName() + "; Age: " + daisy.getAge());
			System.out.println("Name: " + mickey.getFirstName() + " " + mickey.getLastName() + "; Age: " + mickey.getAge());
			System.out.println("Name: " + minnie.getFirstName() + " " + minnie.getLastName() + "; Age: " + minnie.getAge());
			
			mickey.becomeBestManOf(donald);
			minnie.becomeMaidOfHonourOf(daisy);
			
			donald.marry(daisy);
			donald.divorce("Sadness");
			
			if ((donald.getSpouse() == null) && (daisy.getSpouse() == null)) {
				System.out.println("No partner registered anymore.");
			}
			System.out.println("----------------------------");
		}
		
		{ /* test case 2: same-sex */
			System.out.println("test case 2: same-sex");
			System.out.println("----------------------------");
			Man donald = new Man("Donald", "Duck", LocalDate.of(1980, 1, 1));
			Man mickey = new Man("Mickey", "Mouse", LocalDate.of(1979, 5, 5));

			donald.becomeBestManOf(mickey);
			mickey.becomeBestManOf(donald);
			
			donald.marry(mickey);
			mickey.marry(donald);
			
			System.out.println("----------------------------");
		}
		
		{ /* test case 3: invalid ages */
			System.out.println("test case 3: invalid ages");
			System.out.println("----------------------------");
			Man donald = new Man("Donald", "Duck", LocalDate.of(2005, 1, 1));
			Woman daisy = new Woman("Daisy", "Queen", LocalDate.of(2005, 1, 10));
			Man mickey = new Man("Mickey", "Mouse", LocalDate.of(2005, 5, 5));
			Woman minnie = new Woman("Minnie", "Mouse", LocalDate.of(2005, 3, 15));
			
			donald.becomeBestManOf(mickey);
			daisy.becomeMaidOfHonourOf(minnie);
			
			System.out.println("----------------------------");
		}
		
		{ /* test case 4: already married */
			System.out.println("test case 4: already married");
			System.out.println("----------------------------");
			Man donald = new Man("Donald", "Duck", LocalDate.of(1980, 1, 1));
			Woman daisy = new Woman("Daisy", "Queen", LocalDate.of(1982, 1, 10));
			Man mickey = new Man("Mickey", "Mouse", LocalDate.of(1979, 5, 5));
			Woman minnie = new Woman("Minnie", "Mouse", LocalDate.of(1981, 3, 15));
			
			mickey.becomeBestManOf(donald);
			minnie.becomeMaidOfHonourOf(daisy);
			
			donald.marry(daisy);
			
			donald.becomeBestManOf(mickey);
			daisy.becomeMaidOfHonourOf(minnie);
			
			donald.marry(minnie);
			
			System.out.println("----------------------------");
		}
		
		{ /* test case 5: no spouse to divorce or no witness to marry */
			System.out.println("test case 5: no spouse to divorce or no witness to marry");
			System.out.println("----------------------------");
			Man donald = new Man("Donald", "Duck", LocalDate.of(1980, 1, 1));
			Woman daisy = new Woman("Daisy", "Queen", LocalDate.of(1982, 1, 10));
			
			donald.marry(daisy);
			donald.divorce("Loneliness");			
			
			System.out.println("----------------------------");
		}
	}
}