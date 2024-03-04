package at.fhv.mme.exercise07.task01;

import at.fhv.mme.exercise07.task01.Rectangle.Corner;

public class Main {
	public static void main(String[] args) {
		
		/* create */
		System.out.println("--- create ---");
		
		// r1 & r2 are valid
		Rectangle r1 = new Rectangle(new Point(10, 10), 50, 20);
		System.out.println("Rectangle r1: bottomLeft (" + r1.getBottomLeft().getX() + "|" + r1.getBottomLeft().getY() + "), Length (" + r1.getLength() + "), Width (" + r1.getWidth() + ")");
		Rectangle r2 = new Rectangle(new Point(10, 10), 10, 40);
		System.out.println("Rectangle r2: bottomLeft (" + r2.getBottomLeft().getX() + "|" + r2.getBottomLeft().getY() + "), Length (" + r2.getLength() + "), Width (" + r2.getWidth() + ")");
		
		// r3 & r4 are invalid (invalid x-/y-value or invalid width/length)
		Rectangle r3 = new Rectangle(new Point(-10, 10), 200, 50);
		Rectangle r4 = new Rectangle(new Point(10, 10), -200, 50);
		
		
		/* move */
		System.out.println("--- move ---");
		
		r1.move(20, 60);
		System.out.println("Rectangle r1: bottomLeft (" + r1.getBottomLeft().getX() + "|" + r1.getBottomLeft().getY() + "), Length (" + r1.getLength() + "), Width (" + r1.getWidth() + ")");
		r2.move(-40, 0);
		System.out.println("Rectangle r2: bottomLeft (" + r2.getBottomLeft().getX() + "|" + r2.getBottomLeft().getY() + "), Length (" + r2.getLength() + "), Width (" + r2.getWidth() + ")");
		
		
		/* rotate */
		System.out.println("--- rotate ---");
		
		r1.rotate(Corner.bottomLeft);
		System.out.print("bottomLeft: "); System.out.println("Rectangle r1: bottomLeft (" + r1.getBottomLeft().getX() + "|" + r1.getBottomLeft().getY() + "), Length (" + r1.getLength() + "), Width (" + r1.getWidth() + ")");
		r1.setBottomLeft(30, 70);
		r1.setLength(50);
		r1.setWidth(20);
		
		r1.rotate(Corner.bottomRight);
		System.out.print("bottomRight: "); System.out.println("Rectangle r1: bottomLeft (" + r1.getBottomLeft().getX() + "|" + r1.getBottomLeft().getY() + "), Length (" + r1.getLength() + "), Width (" + r1.getWidth() + ")");
		r1.setBottomLeft(30, 70);
		r1.setLength(50);
		r1.setWidth(20);
		
		r1.rotate(Corner.topLeft);
		System.out.print("topLeft: "); System.out.println("Rectangle r1: bottomLeft (" + r1.getBottomLeft().getX() + "|" + r1.getBottomLeft().getY() + "), Length (" + r1.getLength() + "), Width (" + r1.getWidth() + ")");
		r1.setBottomLeft(30, 70);
		r1.setLength(50);
		r1.setWidth(20);
		
		r1.rotate(Corner.topRight);
		System.out.print("topRight: "); System.out.println("Rectangle r1: bottomLeft (" + r1.getBottomLeft().getX() + "|" + r1.getBottomLeft().getY() + "), Length (" + r1.getLength() + "), Width (" + r1.getWidth() + ")");
		r1.setBottomLeft(30, 70);
		r1.setLength(50);
		r1.setWidth(20);
		
		r2.rotate(Corner.bottomLeft);
		System.out.print("bottomLeft: "); System.out.println("Rectangle r2: bottomLeft (" + r2.getBottomLeft().getX() + "|" + r2.getBottomLeft().getY() + "), Length (" + r2.getLength() + "), Width (" + r2.getWidth() + ")");
		r2.setBottomLeft(10, 10);
		r2.setLength(10);
		r2.setWidth(40);
		
		r2.rotate(Corner.bottomRight);
		System.out.print("bottomRight: "); System.out.println("Rectangle r2: bottomLeft (" + r2.getBottomLeft().getX() + "|" + r2.getBottomLeft().getY() + "), Length (" + r2.getLength() + "), Width (" + r2.getWidth() + ")");
		r2.setBottomLeft(10, 10);
		r2.setLength(10);
		r2.setWidth(40);
		
		r2.rotate(Corner.topLeft);
		System.out.print("topLeft: "); System.out.println("Rectangle r2: bottomLeft (" + r2.getBottomLeft().getX() + "|" + r2.getBottomLeft().getY() + "), Length (" + r2.getLength() + "), Width (" + r2.getWidth() + ")");
		r2.setBottomLeft(10, 10);
		r2.setLength(10);
		r2.setWidth(40);
		
		r2.rotate(Corner.topRight);
		System.out.print("topRight: "); System.out.println("Rectangle r2: bottomLeft (" + r2.getBottomLeft().getX() + "|" + r2.getBottomLeft().getY() + "), Length (" + r2.getLength() + "), Width (" + r2.getWidth() + ")");
		r2.setBottomLeft(10, 10);
		r2.setLength(10);
		r2.setWidth(40);
		
		
		/* isSquare */
		System.out.println("--- isSquare ---");
		System.out.println("Rectangle r2: bottomLeft (" + r2.getBottomLeft().getX() + "|" + r2.getBottomLeft().getY() + "), Length (" + r2.getLength() + "), Width (" + r2.getWidth() + ")");
		if (r2.isSquare() == true) {
			System.out.println("(before changing length) Rectangle r2: isSquare true");
		} else {
			System.out.println("(before changing length) Rectangle r2: isSquare false");
		}
		
		r2.setLength(40);
		System.out.println("Rectangle r2: bottomLeft (" + r2.getBottomLeft().getX() + "|" + r2.getBottomLeft().getY() + "), Length (" + r2.getLength() + "), Width (" + r2.getWidth() + ")");
		if (r2.isSquare() == true) {
			System.out.println("(after changing length) Rectangle r2: isSquare true");
		} else {
			System.out.println("(after changing length) Rectangle r2: isSquare false");
		}
		
		/* createCircle */
		System.out.println("--- createCircle ---");
		System.out.println("Rectangle r1: bottomLeft (" + r1.getBottomLeft().getX() + "|" + r1.getBottomLeft().getY() + "), Length (" + r1.getLength() + "), Width (" + r1.getWidth() + ")");
		Circle r1Circle = r1.createCircle();
		System.out.println("r1Circle: Center (" + r1Circle.getCenter().getX() + "|" + r1Circle.getCenter().getY() + "), Radius (" + r1Circle.getRadius() + ")");
		
		System.out.println("Rectangle r2: bottomLeft (" + r2.getBottomLeft().getX() + "|" + r2.getBottomLeft().getY() + "), Length (" + r2.getLength() + "), Width (" + r2.getWidth() + ")");
		Circle r2Circle = r2.createCircle();
		System.out.println("r2Circle: Center (" + r2Circle.getCenter().getX() + "|" + r2Circle.getCenter().getY() + "), Radius (" + r2Circle.getRadius() + ")");
		
		
		
		/* zoom */
		System.out.println("--- zoom ---");
		System.out.println("Rectangle r2: bottomLeft (" + r2.getBottomLeft().getX() + "|" + r2.getBottomLeft().getY() + "), Length (" + r2.getLength() + "), Width (" + r2.getWidth() + ")");
		r2.zoom(2);
		System.out.println("Rectangle r2: bottomLeft (" + r2.getBottomLeft().getX() + "|" + r2.getBottomLeft().getY() + "), Length (" + r2.getLength() + "), Width (" + r2.getWidth() + ")");
		r2.zoom(-2);		
		
		
		/* divide */
		System.out.println("--- divide ---");
		System.out.println("Rectangle r1: bottomLeft (" + r1.getBottomLeft().getX() + "|" + r1.getBottomLeft().getY() + "), Length (" + r1.getLength() + "), Width (" + r1.getWidth() + ")");
		Rectangle[] r1Divided = r1.divide();
		System.out.println("r1Divided[0]: bottomLeft (" + r1Divided[0].getBottomLeft().getX() + "|" + r1Divided[0].getBottomLeft().getY() + "), Length (" + r1Divided[0].getLength() + "), Width (" + r1Divided[0].getWidth() + ")");
		System.out.println("r1Divided[1]: bottomLeft (" + r1Divided[1].getBottomLeft().getX() + "|" + r1Divided[1].getBottomLeft().getY() + "), Length (" + r1Divided[1].getLength() + "), Width (" + r1Divided[1].getWidth() + ")");
		System.out.println("r1Divided[2]: bottomLeft (" + r1Divided[2].getBottomLeft().getX() + "|" + r1Divided[2].getBottomLeft().getY() + "), Length (" + r1Divided[2].getLength() + "), Width (" + r1Divided[2].getWidth() + ")");
		System.out.println("r1Divided[3]: bottomLeft (" + r1Divided[3].getBottomLeft().getX() + "|" + r1Divided[3].getBottomLeft().getY() + "), Length (" + r1Divided[3].getLength() + "), Width (" + r1Divided[3].getWidth() + ")");
		
		
		/* createCutSurface */
		System.out.println("--- createCutSurface ---");
		r3 = new Rectangle(new Point(10, 10), 40, 40);
		r4 = new Rectangle(new Point(30, 40), 50, 20);
		System.out.println("Rectangle r3: bottomLeft (" + r3.getBottomLeft().getX() + "|" + r3.getBottomLeft().getY() + "), Length (" + r3.getLength() + "), Width (" + r3.getWidth() + ")");
		System.out.println("Rectangle r4: bottomLeft (" + r4.getBottomLeft().getX() + "|" + r4.getBottomLeft().getY() + "), Length (" + r4.getLength() + "), Width (" + r4.getWidth() + ")");
		
		Rectangle r3r4CutSurface = Rectangle.createCutSurface(r3, r4);
		System.out.println("Rectangle r3r4CutSurface: bottomLeft (" + r3r4CutSurface.getBottomLeft().getX() + "|" + r3r4CutSurface.getBottomLeft().getY() + "), Length (" + r3r4CutSurface.getLength() + "), Width (" + r3r4CutSurface.getWidth() + ")");
		
		
		Rectangle r5 = new Rectangle(new Point(90, 40), 60, 20);
		Rectangle r6 = new Rectangle(new Point(100, 10), 40, 40);
		System.out.println("Rectangle r5: bottomLeft (" + r5.getBottomLeft().getX() + "|" + r5.getBottomLeft().getY() + "), Length (" + r5.getLength() + "), Width (" + r5.getWidth() + ")");
		System.out.println("Rectangle r6: bottomLeft (" + r6.getBottomLeft().getX() + "|" + r6.getBottomLeft().getY() + "), Length (" + r6.getLength() + "), Width (" + r6.getWidth() + ")");
		
		Rectangle r5r6CutSurface = Rectangle.createCutSurface(r5, r6);
		System.out.println("Rectangle r5r6CutSurface: bottomLeft (" + r5r6CutSurface.getBottomLeft().getX() + "|" + r5r6CutSurface.getBottomLeft().getY() + "), Length (" + r5r6CutSurface.getLength() + "), Width (" + r5r6CutSurface.getWidth() + ")");
		
	}
}