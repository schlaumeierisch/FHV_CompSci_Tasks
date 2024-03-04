package at.fhv.mme.exercise09.task01;

import java.time.LocalDate;

public class Man extends Person {
	private Person _bestMan; 
	
	public Man(String firstName, String lastName, LocalDate dateOfBirth) {
		super(firstName, lastName, Gender.male, dateOfBirth);
	}
	
	public Person getBestMan() {
		return _bestMan;
	}
	
	public void setBestMan(Person bestMan) {
		_bestMan = bestMan;
	}
	
	public boolean becomeBestManOf(Man man) {
		if ((this.getAge() >= 18) && (man.getAge() >= 18)) {
			man.setBestMan(this);
			
			System.out.println(this.getFirstName() + " is now " + man.getFirstName() + "'s best man.");
			return true;
		}
		
		System.out.println("This person or the person you want to be best man for is still too young!");
		return false;
	}
	
	public boolean marry(Person person) {
		if (person instanceof Woman) {
			if ((this.getSpouse() == null) && (person.getSpouse() == null)) {
				if ((this.getBestMan() != null) && (((Woman) person).getMaidOfHonour() != null)) {
					if ((this.getAge()) >= 18 && (person.getAge() >= 18)) {
						this.setSpouse(person);
						person.setSpouse(this);
						person.setLastName(this.getLastName());
						
						System.out.println(this.getFirstName() + " and " + person.getFirstName() + " got married! The witnesses are: " + this.getBestMan().getFirstName() + " and " + ((Woman) person).getMaidOfHonour().getFirstName());
						
						return true;
					} else {
						System.out.println("This person or the person to be married is not yet 18!");
					}
				} else {
					System.out.println("This person and/or the person to be married do not yet have witnesses!");
				}
			} else {
				System.out.println("This person or the person you want to marry already has a spouse!");
			}
		} else {
			System.out.println("Same-sex people cannot marry each other!");
		}
		
		return false;
	}
}