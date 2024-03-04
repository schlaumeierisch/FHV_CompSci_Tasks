package at.fhv.mme.exercise07.task01;

/**
 * Rectangle class for exercise 07, task 01
 * 
 * @author 	Matthias Meier
 * @date	2021-06-08
 */

public class Rectangle {
	public enum Corner {
		bottomLeft,
		bottomRight,
		topLeft,
		topRight
	}
	
	private Point _bottomLeft;
	private int _length;
	private int _width;
	
	public Rectangle(Point bottomLeft, int length, int width) {
		if ((length > 0) && (width > 0)) {
			_length = length;
			_width = width;
		} else {
			System.out.println("(Rectangle) Error: Invalid length and/or width! The rectangle was created with default values.");
			_length = 1;
			_width = 1;
		}
		
		_bottomLeft = bottomLeft;
	}
	
	public Point getBottomLeft() {
		return _bottomLeft;
	}
	
	public int getLength() {
		return _length;
	}
	
	public int getWidth() {
		return _width;
	}
	
	public void setBottomLeft(int posX, int posY) {
		_bottomLeft.setX(posX);
		_bottomLeft.setY(posY);
	}
	
	public void setLength(int length) {
		_length = length;
	}
	
	public void setWidth(int width) {
		_width = width;
	}
	
	
	/* move rectangle N steps towards X/Y */
	public boolean move(int stepsX, int stepsY) {
		if (((_bottomLeft.getX() + stepsX) >= 0) && ((_bottomLeft.getY() + stepsY) >= 0)) {
			_bottomLeft.move(stepsX, stepsY);
			
			return true;
		}
		
		System.out.println("(Rectangle) Error: Unable to move rectangle!");
		return false;
	}
	
	/* rotate rectangle 90 degrees counterclockwise */
	public void rotate(Corner corner) {
		Point tempPoint = _bottomLeft;
		
		if (_length < _width) {
			switch(corner) {
			case bottomLeft:
				_bottomLeft.move(-(_width), 0);
				break;
			case bottomRight:
				_bottomLeft.move(-(_width - _length), -(_length));
				break;
			case topLeft:
				_bottomLeft.move(0, _width);
				break;
			case topRight:
				_bottomLeft.move(_length, (_width - _length));
				break;
			}
		} else {
			switch(corner) {
			case bottomLeft:
				_bottomLeft.move(-(_width), 0);
				break;
			case bottomRight:
				_bottomLeft.move((_length - _width), -(_length));
				break;
			case topLeft:
				_bottomLeft.move(0, _width);
				break;
			case topRight:
				_bottomLeft.move(_length, -(_length - _width));
				break;
			}			
		}
		
		if ((_bottomLeft.getX() != tempPoint.getX()) && (_bottomLeft.getY() != tempPoint.getY())) {
			// swap length/width after (successfully) rotating rectangle
			int temp = _length;
			_length = _width;
			_width = temp;
		}
	}
	
	public boolean isSquare() {
		if (_length == _width) {
			return true;
		}
		
		return false;
	}
	
	/* create circle around rectangle */
	public Circle createCircle() {
		Point center = new Point((_bottomLeft.getX() + (_length / 2)), (_bottomLeft.getY() + (_width / 2)));
		// rectangle perimeter radius = d / 2 = sqrt((a^2 + b^2)) / 2
		int radius = (int) ((Math.sqrt(Math.pow(_length, 2) + Math.pow(_width, 2))) / 2);
		
		Circle circleAroundRectangle = new Circle(center, radius);
		
		return circleAroundRectangle;
	}
	
	/* "zoom" (enlarge/reduce) rectangle by a certain factor (length and width are increased/decreased) */
	public boolean zoom(int factor) {
		if (factor > 0) {
			_length = _length * factor;
			_width = _width * factor;
			
			return true;
		}
		
		System.out.println("Error: Unable to zoom rectangle!");
		return false;		
	}
	
	/* divide rectangle into four equal parts */
	public Rectangle[] divide() {
		Rectangle[] quarteredRectangles = new Rectangle[4];
		
		// [0]: rectangle bottom left
		Point bottomLeftRectangle1 = new Point(_bottomLeft.getX(), _bottomLeft.getY());
		quarteredRectangles[0] = new Rectangle(bottomLeftRectangle1, (_length / 2), (_width / 2));
		
		// [1]: rectangle bottom right
		Point bottomLeftRectangle2 = new Point((_bottomLeft.getX() + (_length / 2)), _bottomLeft.getY());
		quarteredRectangles[1] = new Rectangle(bottomLeftRectangle2, (_length / 2), (_width / 2));
		
		// [2]: rectangle top left
		Point bottomLeftRectangle3 = new Point(_bottomLeft.getX(), (_bottomLeft.getY() + (_width / 2)));
		quarteredRectangles[2] = new Rectangle(bottomLeftRectangle3, (_length / 2), (_width / 2));
		
		// [3]: rectangle top right
		Point bottomLeftRectangle4 = new Point((_bottomLeft.getX() + (_length / 2)), (_bottomLeft.getY() + (_width / 2)));
		quarteredRectangles[3] = new Rectangle(bottomLeftRectangle4, (_length / 2), (_width / 2));
		
		
		return quarteredRectangles;
	}
	
	/* determines the intersection of two rectangles */
	public static Rectangle createCutSurface(Rectangle a, Rectangle b) {
		// auxiliary variables for clarity
		int aMinX = a._bottomLeft.getX();
		int aMaxX = a._bottomLeft.getX() + a._length;
		int aMinY = a._bottomLeft.getY();
		int aMaxY = a._bottomLeft.getY() + a._width;

		int bMinX = b._bottomLeft.getX();
		int bMaxX = b._bottomLeft.getX() + b._length;
		int bMinY = b._bottomLeft.getY();
		int bMaxY = b._bottomLeft.getY() + b._width;
		
		if (surfacesIntersect(aMinX, aMaxX, aMinY, aMaxY, bMinX, bMaxX, bMinY, bMaxY) == true) {
			int newRectangleMinX;
			int newRectangleMaxX;
			int newRectangleMinY;
			int newRectangleMaxY;
			
			if (aMinX > bMinX) {
				newRectangleMinX = aMinX;
			} else {
				newRectangleMinX = bMinX;
			}
			
			if (aMaxX > bMaxX) {
				newRectangleMaxX = bMaxX;
			} else {
				newRectangleMaxX = aMaxX;
			}
			
			if (aMinY > bMinY) {
				newRectangleMinY = aMinY;
			} else {
				newRectangleMinY = bMinY;
			}
			
			if (aMaxY > bMaxY) {
				newRectangleMaxY = bMaxY;
			} else {
				newRectangleMaxY = aMaxY;
			}
			
			Point newRectangleBottomLeft = new Point(newRectangleMinX, newRectangleMinY);
			Rectangle newRectangle = new Rectangle(newRectangleBottomLeft, (newRectangleMaxX - newRectangleMinX), (newRectangleMaxY - newRectangleMinY));
		
			return newRectangle;
		}
		
		System.out.println("Error: The intersection of the rectangles does not coincide! An invalid rectangle was returned.");
		return (new Rectangle(new Point(0, 0), 0, 0));
	}
	
	/* do the rectangles intersect? */	
	public static boolean surfacesIntersect(int aMinX, int aMaxX, int aMinY, int aMaxY, int bMinX, int bMaxX, int bMinY, int bMaxY) {		
		// check all combinations of the four X values and the four Y values to see if they lie in both rectangles
		if ((((aMinX <= bMinX) && (aMaxX >= bMinX)) || ((aMinX >= bMinX) && (aMaxX <= bMaxX)) || ((aMinX >= bMinX) && (aMaxX >= bMaxX)) || ((aMinX <= bMinX) && (aMaxX >= bMaxX))) &&
			(((aMinY <= bMinY) && (aMaxY >= bMinY)) || ((aMinY >= bMinY) && (aMaxY <= bMaxY)) || ((aMinY >= bMinY) && (aMaxY >= bMaxY)) || ((aMinY <= bMinY) && (aMaxY >= bMaxY)))) {

			return true;
		}
		
		return false;
	}
}
