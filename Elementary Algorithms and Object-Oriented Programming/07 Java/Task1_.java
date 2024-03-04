package at.fhv.mme.exercise07.task01;

/**
 * Point class for exercise 07, task 01
 * 
 * @author 	Matthias Meier
 * @date	2021-06-08
 */

public class Point {
	private int _x;
	private int _y;
	
	public Point(int x, int y) {
		if ((x >= 0) && (y >= 0)) {
			_x = x;
			_y = y;
		} else {
			System.out.println("(Point) Error: Invalid X- and Y-values!");
			_x = -1;
			_y = -1;
		}
	}
	
	public int getX() {
		return _x;
	}
	
	public int getY() {
		return _y;
	}
	
	public void setX(int x) {
		_x = x;
	}
	
	public void setY(int y) {
		_y = y;
	}
	
	public boolean move(int stepsX, int stepsY) {
		if (((_x + stepsX) >= 0) && ((_y + stepsY) >= 0)) {
			_x = _x + stepsX;
			_y = _y + stepsY;
			
			return true;
		}
		
		System.out.println("(Point) Error: Unable to move point!");
		return false;
	}
}