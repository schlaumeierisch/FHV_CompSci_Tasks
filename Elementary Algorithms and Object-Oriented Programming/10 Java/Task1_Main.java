package at.fhv.mme.exercise10.task01;

import java.util.Scanner;

/**
 * Hashtabelle (Exercise 10, Task 01)
 * 
 * @author	Matthias Meier
 * @date	2021-06-28
 */
public class Main {
	
	public static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		{	/* test case 1: best case */
			Hashtable ht = new Hashtable(10);
			
			ht.insert(1);
			ht.insert(2);
			ht.insert(3);
			ht.insert(4);
			ht.insert(5);
			ht.insert(6);
			ht.insert(7);
			ht.insert(8);
			ht.insert(9);
			ht.insert(10);
			
			ht.getCurrSize();
			ht.print();
			
			ht.remove(5);
			ht.remove(6);
			
			ht.getCurrSize();
			ht.print();
		}
		
		{	/* text case 2: full table */
			Hashtable ht = new Hashtable(10);
			
			ht.insert(1);
			ht.insert(2);
			ht.insert(3);
			ht.insert(4);
			ht.insert(5);
			ht.insert(6);
			ht.insert(7);
			ht.insert(8);
			ht.insert(9);
			ht.insert(10);
			ht.insert(100);
		}
		
		{	/* test case 3: empty table */
			Hashtable ht = new Hashtable(10);
			
			ht.getCurrSize();
			ht.remove(10);
		}		
		
		{	/* text case 4: collisions (try different collision strategies) */
			Hashtable ht = new Hashtable(100);
			
			ht.insert(10);
			ht.insert(10);
			ht.insert(10);
			ht.insert(25);
			ht.insert(25);
			ht.insert(25);
			ht.insert(50);
			ht.insert(50);
			ht.insert(50);
			ht.insert(100);
			ht.insert(100);
			
			ht.getCurrSize();
			ht.print();
		}
		
		{	/* text case 5: collisions in a almost full table */
			Hashtable ht = new Hashtable(10);
			
			ht.insert(1);
			ht.insert(1);
			ht.insert(3);
			ht.insert(4);
			ht.insert(5);
			ht.insert(6);
			ht.insert(7);
			ht.insert(8);
			ht.insert(9);
			
			ht.insert(2);
			
			ht.clear();
			
			
			ht.insert(1);
			ht.insert(1);
			ht.insert(3);
			ht.insert(4);
			ht.insert(5);
			ht.insert(6);
			ht.insert(7);
			ht.insert(8);
			ht.insert(9);
			
			ht.insert(2);
			
			ht.clear();
			
			
			ht.insert(1);
			ht.insert(1);
			ht.insert(3);
			ht.insert(4);
			ht.insert(5);
			ht.insert(6);
			ht.insert(7);
			ht.insert(8);
			ht.insert(9);
			
			ht.insert(2);
		}		
		
		scanner.close();
	}
}