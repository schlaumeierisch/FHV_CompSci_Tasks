package at.fhv.mme.exercise07.task02;

import java.util.LinkedList;

/**
 * Terminal class for exercise 07, task 02
 * 
 * @author 	Matthias Meier
 * @date	2021-06-08
 */

public class Field {
	private int _width;
	private int _height;
	public LinkedList<Product> _productsOnField;
	
	public Field(int width, int height) {
		_width = width;
		_height = height;
		
		_productsOnField = new LinkedList<>();
	}
	
	public int getWidth() {
		return _width;
	}
	
	public int getHeight() {
		return _height;
	}
	
	public boolean addProduct(Product product) {
		if ((product.getCurrPosition().getPosX() <= _width) && (product.getCurrPosition().getPosY() <= _height)) {
			if ((product.getDestPosition().getPosX() <= _width) && (product.getDestPosition().getPosY() <= _height)) {
				_productsOnField.add(product);
				
				return true;
			}
		}
		
		System.out.println("Error: Unable to add product!");
		return false;
	}
	
	
	
	/* if there's a product located, send product's index; else send -1
	 * this function was needed to add more products to the trolley, but unfortunately, nothing really worked
	 * after hours of trying I then gave up
	 */
	public int isProductLocated(Position currPosition) {
		for (int i = 0; i < _productsOnField.size(); i++) {
			if ((_productsOnField.get(i).getCurrPosition().getPosX() == currPosition.getPosX()) &&
				(_productsOnField.get(i).getCurrPosition().getPosY() == currPosition.getPosY())) {
				
				return i;
			}	
		}
		
		return -1;
	}
}