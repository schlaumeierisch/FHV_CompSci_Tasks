package at.fhv.mme.exercise07.task02;

import at.fhv.mme.exercise07.task02.Trolley.Direction;

public class Main {
	public static void main(String[] args) {
		
		/* test case 1: random product */
		{
			System.out.println("--- Test Case 1 starts ---");
			Field testField1 = new Field(10, 10);
			Product testProduct1 = new Product("Kartoffeln", 10, new Position(1, 5), new Position(1, 10));
			testField1._productsOnField.add(testProduct1);
			Trolley testTrolley1 = new Trolley(new Position(5, 5), 20);
			
			System.out.println("Size of testField1: " + testField1.getWidth() + " x " + testField1.getHeight());
			System.out.println("currPosition testTrolley1: " + "(" + testTrolley1.getCurrPosition().getPosX() + "|" + testTrolley1.getCurrPosition().getPosY() + ")");
			System.out.println("currPosition testProduct1: " + "(" + testProduct1.getCurrPosition().getPosX() + "|" + testProduct1.getCurrPosition().getPosY() + ")");
			System.out.println("destPosition testProduct1: " + "(" + testProduct1.getDestPosition().getPosX() + "|" + testProduct1.getDestPosition().getPosY() + ")");
	
			// drive in the direction where the product is located
			while ((testTrolley1.getCurrPosition().getPosX() != testField1._productsOnField.get(0).getCurrPosition().getPosX()) ||
				   (testTrolley1.getCurrPosition().getPosY() != testField1._productsOnField.get(0).getCurrPosition().getPosY())) {
				
				if (testTrolley1.getCurrPosition().getPosX() < testField1._productsOnField.get(0).getCurrPosition().getPosX()) {
					testTrolley1.move(Direction.East, testField1);
				} else if (testTrolley1.getCurrPosition().getPosX() > testField1._productsOnField.get(0).getCurrPosition().getPosX()) {
					testTrolley1.move(Direction.West, testField1);
				} else if (testTrolley1.getCurrPosition().getPosY() < testField1._productsOnField.get(0).getCurrPosition().getPosY()) {
					testTrolley1.move(Direction.North, testField1);
				} else if (testTrolley1.getCurrPosition().getPosY() > testField1._productsOnField.get(0).getCurrPosition().getPosY()) {
					testTrolley1.move(Direction.South, testField1);
				}
				
				System.out.println("currPosition testTrolley1: " + "(" + testTrolley1.getCurrPosition().getPosX() + "|" + testTrolley1.getCurrPosition().getPosY() + ")");
			}
			
			if (testTrolley1.load(testField1._productsOnField.get(0))) {
				testField1._productsOnField.remove(0);
				System.out.println("Product loaded.");
				
				
				// drive in the direction where the product must be unloaded
				while ((testTrolley1.getCurrPosition().getPosX() != testTrolley1._loadedProducts.get(0).getDestPosition().getPosX()) ||
					   (testTrolley1.getCurrPosition().getPosY() != testTrolley1._loadedProducts.get(0).getDestPosition().getPosY())) {
					
					if (testTrolley1.getCurrPosition().getPosX() < testTrolley1._loadedProducts.get(0).getDestPosition().getPosX()) {
						testTrolley1.move(Direction.East, testField1);
					} else if (testTrolley1.getCurrPosition().getPosX() > testTrolley1._loadedProducts.get(0).getDestPosition().getPosX()) {
						testTrolley1.move(Direction.West, testField1);
					} else if (testTrolley1.getCurrPosition().getPosY() < testTrolley1._loadedProducts.get(0).getDestPosition().getPosY()) {
						testTrolley1.move(Direction.North, testField1);
					} else if (testTrolley1.getCurrPosition().getPosY() > testTrolley1._loadedProducts.get(0).getDestPosition().getPosY()) {
						testTrolley1.move(Direction.South, testField1);
					}
					
					System.out.println("currPosition testTrolley1: " + "(" + testTrolley1.getCurrPosition().getPosX() + "|" + testTrolley1.getCurrPosition().getPosY() + ")");
				}
				
				// when destination reached, unload products
				if (testTrolley1.unloadAll()) {
					System.out.println("Product unloaded.");
					System.out.println("--- Test Case 1 ended ---");
				}
			}
		}
		
		
		/* test case 2: random product */
		{
			System.out.println("--- Test Case 2 starts ---");
			Field testField1 = new Field(10, 10);
			Product testProduct1 = new Product("Kartoffeln", 10, new Position(1, 1), new Position(1, 5));
			testField1._productsOnField.add(testProduct1);
			Trolley testTrolley1 = new Trolley(new Position(10, 10), 20);
			
			System.out.println("Size of testField1: " + testField1.getWidth() + " x " + testField1.getHeight());
			System.out.println("currPosition testTrolley1: " + "(" + testTrolley1.getCurrPosition().getPosX() + "|" + testTrolley1.getCurrPosition().getPosY() + ")");
			System.out.println("currPosition testProduct1: " + "(" + testProduct1.getCurrPosition().getPosX() + "|" + testProduct1.getCurrPosition().getPosY() + ")");
			System.out.println("destPosition testProduct1: " + "(" + testProduct1.getDestPosition().getPosX() + "|" + testProduct1.getDestPosition().getPosY() + ")");
	
			// drive in the direction where the product is located
			while ((testTrolley1.getCurrPosition().getPosX() != testField1._productsOnField.get(0).getCurrPosition().getPosX()) ||
				   (testTrolley1.getCurrPosition().getPosY() != testField1._productsOnField.get(0).getCurrPosition().getPosY())) {
				
				if (testTrolley1.getCurrPosition().getPosX() < testField1._productsOnField.get(0).getCurrPosition().getPosX()) {
					testTrolley1.move(Direction.East, testField1);
				} else if (testTrolley1.getCurrPosition().getPosX() > testField1._productsOnField.get(0).getCurrPosition().getPosX()) {
					testTrolley1.move(Direction.West, testField1);
				} else if (testTrolley1.getCurrPosition().getPosY() < testField1._productsOnField.get(0).getCurrPosition().getPosY()) {
					testTrolley1.move(Direction.North, testField1);
				} else if (testTrolley1.getCurrPosition().getPosY() > testField1._productsOnField.get(0).getCurrPosition().getPosY()) {
					testTrolley1.move(Direction.South, testField1);
				}
				
				System.out.println("currPosition testTrolley1: " + "(" + testTrolley1.getCurrPosition().getPosX() + "|" + testTrolley1.getCurrPosition().getPosY() + ")");
			}
			
			if (testTrolley1.load(testField1._productsOnField.get(0))) {
				testField1._productsOnField.remove(0);
				System.out.println("Product loaded.");
				
				
				// drive in the direction where the product must be unloaded
				while ((testTrolley1.getCurrPosition().getPosX() != testTrolley1._loadedProducts.get(0).getDestPosition().getPosX()) ||
					   (testTrolley1.getCurrPosition().getPosY() != testTrolley1._loadedProducts.get(0).getDestPosition().getPosY())) {
					
					if (testTrolley1.getCurrPosition().getPosX() < testTrolley1._loadedProducts.get(0).getDestPosition().getPosX()) {
						testTrolley1.move(Direction.East, testField1);
					} else if (testTrolley1.getCurrPosition().getPosX() > testTrolley1._loadedProducts.get(0).getDestPosition().getPosX()) {
						testTrolley1.move(Direction.West, testField1);
					} else if (testTrolley1.getCurrPosition().getPosY() < testTrolley1._loadedProducts.get(0).getDestPosition().getPosY()) {
						testTrolley1.move(Direction.North, testField1);
					} else if (testTrolley1.getCurrPosition().getPosY() > testTrolley1._loadedProducts.get(0).getDestPosition().getPosY()) {
						testTrolley1.move(Direction.South, testField1);
					}
					
					System.out.println("currPosition testTrolley1: " + "(" + testTrolley1.getCurrPosition().getPosX() + "|" + testTrolley1.getCurrPosition().getPosY() + ")");
				}
				
				// when destination reached, unload products
				if (testTrolley1.unloadAll()) {
					System.out.println("Product unloaded.");
					System.out.println("--- Test Case 2 ended ---");
				}
			}
		}
		
		
		/* test case 3: product's capacity is bigger than trolley's capacity */
		{
			System.out.println("--- Test Case 3 starts ---");
			Field testField1 = new Field(10, 10);
			Product testProduct1 = new Product("Kartoffeln", 30, new Position(1, 1), new Position(1, 5));
			testField1._productsOnField.add(testProduct1);
			Trolley testTrolley1 = new Trolley(new Position(10, 10), 20);
			
			System.out.println("Size of testField1: " + testField1.getWidth() + " x " + testField1.getHeight());
			System.out.println("currPosition testTrolley1: " + "(" + testTrolley1.getCurrPosition().getPosX() + "|" + testTrolley1.getCurrPosition().getPosY() + ")");
			System.out.println("currPosition testProduct1: " + "(" + testProduct1.getCurrPosition().getPosX() + "|" + testProduct1.getCurrPosition().getPosY() + ")");
			System.out.println("destPosition testProduct1: " + "(" + testProduct1.getDestPosition().getPosX() + "|" + testProduct1.getDestPosition().getPosY() + ")");
	
			// drive in the direction where the product is located
			while ((testTrolley1.getCurrPosition().getPosX() != testField1._productsOnField.get(0).getCurrPosition().getPosX()) ||
				   (testTrolley1.getCurrPosition().getPosY() != testField1._productsOnField.get(0).getCurrPosition().getPosY())) {
				
				if (testTrolley1.getCurrPosition().getPosX() < testField1._productsOnField.get(0).getCurrPosition().getPosX()) {
					testTrolley1.move(Direction.East, testField1);
				} else if (testTrolley1.getCurrPosition().getPosX() > testField1._productsOnField.get(0).getCurrPosition().getPosX()) {
					testTrolley1.move(Direction.West, testField1);
				} else if (testTrolley1.getCurrPosition().getPosY() < testField1._productsOnField.get(0).getCurrPosition().getPosY()) {
					testTrolley1.move(Direction.North, testField1);
				} else if (testTrolley1.getCurrPosition().getPosY() > testField1._productsOnField.get(0).getCurrPosition().getPosY()) {
					testTrolley1.move(Direction.South, testField1);
				}
				
				System.out.println("currPosition testTrolley1: " + "(" + testTrolley1.getCurrPosition().getPosX() + "|" + testTrolley1.getCurrPosition().getPosY() + ")");
			}
			
			if (testTrolley1.load(testField1._productsOnField.get(0))) {
				testField1._productsOnField.remove(0);
				System.out.println("Product loaded.");
			
				
				// drive in the direction where the product must be unloaded
				while ((testTrolley1.getCurrPosition().getPosX() != testTrolley1._loadedProducts.get(0).getDestPosition().getPosX()) ||
					   (testTrolley1.getCurrPosition().getPosY() != testTrolley1._loadedProducts.get(0).getDestPosition().getPosY())) {
					
					if (testTrolley1.getCurrPosition().getPosX() < testTrolley1._loadedProducts.get(0).getDestPosition().getPosX()) {
						testTrolley1.move(Direction.East, testField1);
					} else if (testTrolley1.getCurrPosition().getPosX() > testTrolley1._loadedProducts.get(0).getDestPosition().getPosX()) {
						testTrolley1.move(Direction.West, testField1);
					} else if (testTrolley1.getCurrPosition().getPosY() < testTrolley1._loadedProducts.get(0).getDestPosition().getPosY()) {
						testTrolley1.move(Direction.North, testField1);
					} else if (testTrolley1.getCurrPosition().getPosY() > testTrolley1._loadedProducts.get(0).getDestPosition().getPosY()) {
						testTrolley1.move(Direction.South, testField1);
					}
					
					System.out.println("currPosition testTrolley1: " + "(" + testTrolley1.getCurrPosition().getPosX() + "|" + testTrolley1.getCurrPosition().getPosY() + ")");
				}
				
				// when destination reached, unload products
				if (testTrolley1.unloadAll()) {
					System.out.println("Product unloaded.");
					System.out.println("--- Test Case 3 ended ---");
				}
			}
		}
		
		
		/* test case 4: product's current or destination location is outside the border */
		{
			System.out.println("--- Test Case 3 starts ---");
			Field testField1 = new Field(10, 10);
			Product testProduct1 = new Product("Kartoffeln", 10, new Position(1, 1), new Position(1, 11));
			testField1._productsOnField.add(testProduct1);
			Trolley testTrolley1 = new Trolley(new Position(10, 10), 20);
			
			System.out.println("Size of testField1: " + testField1.getWidth() + " x " + testField1.getHeight());
			System.out.println("currPosition testTrolley1: " + "(" + testTrolley1.getCurrPosition().getPosX() + "|" + testTrolley1.getCurrPosition().getPosY() + ")");
			System.out.println("currPosition testProduct1: " + "(" + testProduct1.getCurrPosition().getPosX() + "|" + testProduct1.getCurrPosition().getPosY() + ")");
			System.out.println("destPosition testProduct1: " + "(" + testProduct1.getDestPosition().getPosX() + "|" + testProduct1.getDestPosition().getPosY() + ")");
	
			// drive in the direction where the product is located
			while ((testTrolley1.getCurrPosition().getPosX() != testField1._productsOnField.get(0).getCurrPosition().getPosX()) ||
				   (testTrolley1.getCurrPosition().getPosY() != testField1._productsOnField.get(0).getCurrPosition().getPosY())) {
				
				if (testTrolley1.getCurrPosition().getPosX() < testField1._productsOnField.get(0).getCurrPosition().getPosX()) {
					testTrolley1.move(Direction.East, testField1);
				} else if (testTrolley1.getCurrPosition().getPosX() > testField1._productsOnField.get(0).getCurrPosition().getPosX()) {
					testTrolley1.move(Direction.West, testField1);
				} else if (testTrolley1.getCurrPosition().getPosY() < testField1._productsOnField.get(0).getCurrPosition().getPosY()) {
					testTrolley1.move(Direction.North, testField1);
				} else if (testTrolley1.getCurrPosition().getPosY() > testField1._productsOnField.get(0).getCurrPosition().getPosY()) {
					testTrolley1.move(Direction.South, testField1);
				}
				
				System.out.println("currPosition testTrolley1: " + "(" + testTrolley1.getCurrPosition().getPosX() + "|" + testTrolley1.getCurrPosition().getPosY() + ")");
			}
			
			if (testTrolley1.load(testField1._productsOnField.get(0))) {
				testField1._productsOnField.remove(0);
				System.out.println("Product loaded.");
			
				
				// drive in the direction where the product must be unloaded
				while ((testTrolley1.getCurrPosition().getPosX() != testTrolley1._loadedProducts.get(0).getDestPosition().getPosX()) ||
					   (testTrolley1.getCurrPosition().getPosY() != testTrolley1._loadedProducts.get(0).getDestPosition().getPosY())) {
					
					if (testTrolley1.getCurrPosition().getPosX() < testTrolley1._loadedProducts.get(0).getDestPosition().getPosX()) {
						testTrolley1.move(Direction.East, testField1);
					} else if (testTrolley1.getCurrPosition().getPosX() > testTrolley1._loadedProducts.get(0).getDestPosition().getPosX()) {
						testTrolley1.move(Direction.West, testField1);
					} else if (testTrolley1.getCurrPosition().getPosY() < testTrolley1._loadedProducts.get(0).getDestPosition().getPosY()) {
						testTrolley1.move(Direction.North, testField1);
					} else if (testTrolley1.getCurrPosition().getPosY() > testTrolley1._loadedProducts.get(0).getDestPosition().getPosY()) {
						testTrolley1.move(Direction.South, testField1);
					}
					
					System.out.println("currPosition testTrolley1: " + "(" + testTrolley1.getCurrPosition().getPosX() + "|" + testTrolley1.getCurrPosition().getPosY() + ")");
				}
				
				// when destination reached, unload products
				if (testTrolley1.unloadAll()) {
					System.out.println("Product unloaded.");
					System.out.println("--- Test Case 3 ended ---");
				}
			}
		}
	}
}