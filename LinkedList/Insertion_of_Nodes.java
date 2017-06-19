/*  	
	Insertion of a node into a linked list. We have 3 functions for this :
	
	1. Insertion of a node at the beginning .
	2. Insertion of a node at the end.
	3. Insertion of a node after a Node whose value is given.
	
	Author : Aman Kimothi
	Github : https://github.com/Aman-Kimothi/DSA
*/

class Insertion_of_Nodes {
	
	static class Node {
		int data;
		Node next;
		Node(int d) {
			data = d;
			next = null;
		}
	}
	
	Node add_front(int data , Node head)  {
		
		Node new_node = new Node(data);
		new_node.next = head;
		head = new_node;
		return head;
	}
	
	Node add_end(int data , Node head)  {
		
		Node new_node = new Node(data);
		
		if(head == null) {            // empty list
			head = new_node;
			return head;
		}
			
		Node temp = head;
			
		while( temp.next != null)
			temp = temp.next;
			
		temp.next = new_node;	
		return head;	
	}
	Node add_index(int data , Node head , int pos)  {
		
		Node new_node = new Node(data);
		
		if(pos == 0) {      // for position 0
			System.out.println("Invalid position");
			return head;
		}
		
		if(head == null) {    // when the list is empty
			if(pos == 1)
				head = new_node;
			else
				System.out.println("Cannot add at the specified position as the list is empty");
			return head;	
		}
		
		if(pos == 1) {         // when the position is 1
			new_node.next = head;
			head = new_node;
			return head;
		}
		
		Node temp = head;      // all the other index cases        
		
		for(int i=1 ; temp != null && i < pos - 1 ; i++ )
			temp = temp.next;
			
		if(temp == null) {       // When the position given is greater than the length of the list
			System.out.println("Cannot add at the specified position as it is greater than the length of the list");
			return head;	
		}
			
		new_node.next = temp.next;
		temp.next = new_node;
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
		
		Insertion_of_Nodes obj = new Insertion_of_Nodes();
		
		Node head = null;
		
		head = obj.add_front( 44 , head);
		head = obj.add_front( 11, head);
		head = obj.add_end( 2333, head);
		head = obj.add_end( 5000, head);
		head = obj.add_index( 13, head , 1);
		head = obj.add_index( 77 , head, 2);
		
		System.out.println("The linked list is : " );
		obj.printList(head);
	}
}