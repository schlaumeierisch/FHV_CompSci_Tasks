package at.fhv.mme.exercise09.task01;

import java.time.LocalDate;

public class Woman extends Person {
	private String _maidenName;
	private Person _maidOfHonour;
	
	public Woman(String firstName, String lastName, LocalDate dateOfBirth) {
		super(firstName, lastName, Gender.female, dateOfBirth);
		_maidenName = lastName;
	}
	
	public String getMaidenName() {
		return _maidenName;
	}
	
	public Person getMaidOfHonour() {
		return _maidOfHonour;
	}
	
	public void setMaidenName(String maidenName) {
		_maidenName = maidenName;
	}
	
	public void setMaidOfHonour(Person maidOfHonour) {
		_maidOfHonour = maidOfHonour;
	}
	
	
	public boolean becomeMaidOfHonourOf(Woman woman) {
		if ((this.getAge() >= 18) && (woman.getAge() >= 18)) {
			woman.setMaidOfHonour(this);
			
			System.out.println(this.getFirstName() + " is now " + woman.getFirstName() + "'s maid of honour.");
			return true;
		}
		
		System.out.println("This person or the person you want to be maid of honour for is still too young!");
		return false;
	}
	
	public boolean marry(Person person) {
		if (person instanceof Man) {
			if ((this.getSpouse() == null) && (person.getSpouse() == null)) {
				if ((this.getMaidOfHonour() != null) && (((Man) person).getBestMan() != null)) {
					this.setSpouse(person);
					person.setSpouse(this);
					this.setLastName(person.getLastName());
					
					System.out.println(this.getFirstName() + " and " + person.getFirstName() + " got married! The witnesses are: " + this.getMaidOfHonour().getFirstName() + " and " + ((Man) person).getBestMan().getFirstName());
					
					return true;
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