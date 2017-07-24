/*  	
	Deleting a node from a linked list. We have 2 functions for this :
	
	1. Deleting a node whose value is given
	2. Deleting a node whose position is given
	
	Author : Aman Kimothi
	E-mail : kimothiaman@gmail.com
	Github : https://github.com/Aman-Kimothi/DSA
*/

class DeletionOfNodes {
	
	static class Node {
		int data;
		Node next;
		Node(int d) {
			data = d;
			next = null;
		}
	}
	
	Node addFront(int data , Node head)  {
		
		Node new_node = new Node(data);
		new_node.next = head;
		head = new_node;
		return head;
	}
	
	Node deleteByValue(int data, Node head)  {			
		
		Node curr = head;
		Node prev = null;
		
		while(curr.next != null && curr.data != data) {
			prev = curr;
			curr = curr.next;
		}
		
		if(prev == null)					// first element if to be deleted
			head = head.next;
		else if(curr.next == null && curr.data != data)		// value not found
			System.out.println(" Value not found");
		else 
			prev.next = curr.next;				// all other cases
		return head;
	}
	
	Node deleteByIndex(int pos , Node head) {
		
		if(pos == 0) {
			System.out.println("Invalid Position");
			return head;
		}
		
		if(pos == 1) {
			head = head.next;
			return head;
		}
		
		Node curr = head;
		Node prev = null;
		
		for(int  i = 1 ; curr != null && i < pos ; i++) {
			prev = curr;
			curr = curr.next;
		}
		
		if(curr == null) {
			System.out.println("Position given is greater than the length of the list");
			return head;
		}
		
		prev.next = curr.next;
		return head;
	}
	
	void printList(Node head)  {
		
		Node temp = head ;
		
		while(temp != null) {
			System.out.print(temp.data + "  ");
			temp = temp.next;
		}
	}
	public static void main(String args[]) {
		
		DeletionOfNodes obj = new DeletionOfNodes();
		
		Node head = null;
		
		head = obj.addFront( 44 , head);
		head = obj.addFront( 11, head);
		head = obj.addFront( 32 , head);
		head = obj.addFront( 1, head);
		head = obj.addFront( 2333 , head);
		head = obj.addFront( 11223, head);
				
		
		System.out.println("Before deletion : " );
		obj.printList(head);
		
		System.out.println("\nAfter deletion :" );
		
		head = obj.deleteByIndex(1, head);     		// Deleting from a position
		head = obj.deleteByValue(44, head);		// Deleting a value 
		obj.printList(head);
	}
}
