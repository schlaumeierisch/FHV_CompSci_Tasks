package at.fhv.mme.exercise10.task02;

/**
 * Merge (Exercise 10, Task 02)
 * 
 * @author	Matthias Meier
 * @date	2021-06-28
 */
public class Main {
	public static void main(String[] args) {
		{	/* test case 1 */
			System.out.println("test case 1");
			System.out.println("-----------");
			ListNode L1 = new ListNode(1);
			L1.setNext(new ListNode(3));
			L1.getNext().setNext(new ListNode(5));
			System.out.print("L1: "); ListNode.print(L1);
			
			ListNode L2 = new ListNode(2);
			L2.setNext(new ListNode(4));
			L2.getNext().setNext(new ListNode(6));
			System.out.print("L2: "); ListNode.print(L2);
			
			ListNode L3 = ListNode.merge(L1, L2);
			System.out.print("L3: "); ListNode.print(L3);
			System.out.println("-----------");
		}
		
		{	/* test case 2: one list has only one value */
			System.out.println("test case 2");
			System.out.println("-----------");
			ListNode L1 = new ListNode(1);
			L1.setNext(new ListNode(2));
			L1.getNext().setNext(new ListNode(3));
			L1.getNext().getNext().setNext(new ListNode(4));
			L1.getNext().getNext().getNext().setNext(new ListNode(5));
			System.out.print("L1: "); ListNode.print(L1);
			
			ListNode L2 = new ListNode(2);
			System.out.print("L2: "); ListNode.print(L2);
						
			ListNode L3 = ListNode.merge(L1, L2);
			System.out.print("L3: "); ListNode.print(L3);
			System.out.println("-----------");
		}
		
		{	/* test case 3: one list is null */
			System.out.println("test case 3");
			System.out.println("-----------");
			ListNode L1 = new ListNode(1);
			L1.setNext(new ListNode(2));
			L1.getNext().setNext(new ListNode(3));
			L1.getNext().getNext().setNext(new ListNode(4));
			L1.getNext().getNext().getNext().setNext(new ListNode(5));
			System.out.print("L1: "); ListNode.print(L1);
			
			ListNode L2 = null;
			System.out.print("L2: "); ListNode.print(L2);
						
			ListNode L3 = ListNode.merge(L1, L2);
			System.out.print("L3: "); ListNode.print(L3);
			System.out.println("-----------");
		}
	}
}