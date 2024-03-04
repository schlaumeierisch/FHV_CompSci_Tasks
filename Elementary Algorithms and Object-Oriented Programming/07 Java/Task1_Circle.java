package at.fhv.mme.exercise07.task01;

/**
 * Circle class for exercise 07, task 01
 * 
 * @author 	Matthias Meier
 * @date	2021-06-08
 */

public class Circle {
	private Point _center;
	private int _radius;
	
	public Circle(Point center, int radius) {
		_center = center;
		_radius = radius;
	}
	
	public Point getCenter() {
		return _center;
	}
	
	public int getRadius() {
		return _radius;
	}
	
	public double area() {
		double A = Math.pow(_radius, 2) * Math.PI;
		
		return A;
	}
	
	public double circumference() {
		double u = 2 * _radius * Math.PI;
		
		return u;
	}
}