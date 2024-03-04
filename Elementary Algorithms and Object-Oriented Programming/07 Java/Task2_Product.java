package at.fhv.mme.exercise07.task02;

/**
 * Product class for exercise 07, task 02
 * 
 * @author 	Matthias Meier
 * @date	2021-06-08
 */

public class Product {
	private String _name;
	private int _size;
	private Position _currPosition;
	private Position _destPosition;
	
	public Product(String name, int size, Position currPosition, Position destPosition) {
		_name = name;
		_size = size;
		_currPosition = currPosition;
		_destPosition = destPosition;
	}
	
	public String getName() {
		return _name;
	}
	
	public int getSize() {
		return _size;
	}
	
	public Position getCurrPosition() {
		return _currPosition;
	}
	
	public Position getDestPosition() {
		return _destPosition;
	}
}