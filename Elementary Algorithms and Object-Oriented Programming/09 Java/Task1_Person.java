package at.fhv.mme.exercise09.task01;

import java.time.LocalDate;
import java.time.Period;

public abstract class Person {
	enum Gender {
		female, male;
	}
	
	private String _firstName;
	private String _lastName;
	private Gender _gender;
	private LocalDate _dateOfBirth;
	private Person _spouse;
	
	public Person(String firstName, String lastName, Gender gender, LocalDate dateOfBirth) {
		_firstName = firstName;
		_lastName = lastName;
		_gender = gender;
		_dateOfBirth = dateOfBirth;
	}
	
	public String getFirstName() {
		return _firstName;
	}

	public String getLastName() {
		return _lastName;
	}

	public Gender getGender() {
		return _gender;
	}

	public LocalDate getDateOfBirth() {
		return _dateOfBirth;
	}
	
	public int getAge() {
		return Period.between(_dateOfBirth, LocalDate.now()).getYears();
	}

	public Person getSpouse() {
		return _spouse;
	}
	
	public void setLastName(String lastName) {
		_lastName = lastName;
	}
	
	public void setSpouse(Person spouse) {
		_spouse = spouse;
	}

	public abstract boolean marry(Person person);
	
	public boolean divorce(String reason) {
		if (this.getSpouse() != null) {
			this.getSpouse().setSpouse(null);
			this.setSpouse(null);
			System.out.println("Successfully divorced! Reason: '" + reason + "'");
			
			return true;
		} else {
			System.out.println("This person does not yet have a spouse from whom she/he can divorce!");
		}
		
		return false;
	}
}