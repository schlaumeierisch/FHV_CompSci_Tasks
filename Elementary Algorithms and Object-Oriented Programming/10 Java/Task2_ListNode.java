package at.fhv.mme.exercise10.task02;

public class ListNode {
	private int _value;
	private ListNode _next;
		
	public ListNode(int value) {
		_value = value;
		_next = null;
	}

	public int getValue() {
		return _value;
	}

	public void setValue(int value) {
		_value = value;
	}

	public ListNode getNext() {
		return _next;
	}

	public void setNext(ListNode next) {
		_next = next;
	}
	
	public static void print(ListNode head) {
		ListNode temp = head;

		while (temp != null) {
			System.out.print(temp.getValue() + " ");
			temp = temp.getNext();
		}

		System.out.println();
	}

	public static ListNode merge(ListNode L1, ListNode L2) {
		ListNode L3 = new ListNode(-1);
		ListNode tempNode = L3;
		
		while (L1 != null && L2 != null) {
			// add the next smaller value to L3
			if (L1.getValue() <= L2.getValue()) {
				tempNode.setNext(L1);
				L1 = L1.getNext();
			} else {
				tempNode.setNext(L2);
				L2 = L2.getNext();
			}
			
			tempNode = tempNode.getNext();
		}
		
		// fill L3 with the remaining elements from L1 or L3, if there are any left		
		if (L1 == null) {
			tempNode.setNext(L2);
		} else if (L2 == null) {
			tempNode.setNext(L1);
		}

		return L3.getNext();
	}
}