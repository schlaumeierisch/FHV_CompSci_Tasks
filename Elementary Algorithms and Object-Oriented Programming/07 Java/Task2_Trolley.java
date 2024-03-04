package at.fhv.mme.exercise07.task02;

import java.util.LinkedList;

/**
 * Trolley class for exercise 07, task 02
 * 
 * @author 	Matthias Meier
 * @date	2021-06-08
 */

public class Trolley {
	public enum Direction {
		North,
		East,
		South,
		West
	}
	
	public LinkedList<Product> _loadedProducts;
	private Position _currPosition;
	private int _currCapacity;
	private int _maxCapacity;
	
	public Trolley(Position currPosition, int maxCapacity) {
		_currPosition = currPosition;
		_maxCapacity = maxCapacity;
		
		_currCapacity = 0;
		_loadedProducts = new LinkedList<>();
	}
	
	public Position getCurrPosition() {
		return _currPosition;
	}
	
	public int getCurrCapacity() {
		return _currCapacity;
	}
	
	public int getMaxCapacity() {
		return _maxCapacity;
	}
		
	public void setCurrCapacity(int currCapacity) {
		_currCapacity = currCapacity;
	}
	
	
	public boolean load(Product product) {
		if ((_currCapacity + product.getSize()) <= _maxCapacity) {
			// check if the destination positions match
			if (_loadedProducts.isEmpty() || (_loadedProducts.get(0).getDestPosition() == product.getDestPosition())) {
				_loadedProducts.add(product);
				_currCapacity = _currCapacity + product.getSize();
				
				return true;
			}
		}
		
		System.out.println("Error: Unable to load certain product!");
		return false;
	}
	
	public boolean unloadAll() {
		if (_loadedProducts.size() > 0) {
			_loadedProducts.clear();
			_currCapacity = 0;
			
			return true;
		}
		
		System.out.println("Error: Unable to unload product(s)!");
		return false;
	}
	
	public boolean move(Direction direction, Field field) {
		switch(direction) {
		case North:
			if (_currPosition.getPosY() < field.getHeight()) {
				_currPosition.move(0, 1);
				
				return true;
			}
			
			break;
		case East:
			if (_currPosition.getPosX() < field.getWidth()) {
				_currPosition.move(1, 0);
				
				return true;
			}
			
			break;
		case South:
			if (_currPosition.getPosY() > 0) {
				_currPosition.move(0, -1);
				
				return true;
			}
			
			break;
		case West:
			if (_currPosition.getPosX() > 0) {
				_currPosition.move(-1, 0);
				
				return true;
			}
			
			break;
		}
		
		System.out.println("Error: Unable to move in certain direction!");
		return false;
	}
}