/*
	Insertion of Nodes in a Circular Linked List in a SORTED manner. We can have 3 cases :
	
	1. Insertion of a node in an empty list.
	2. Insertion of a node at the beginning.
	3. Insertion of a node at the end.
	4. Insertion of a node at all the other positions.
	
	Example  :
	
	Circular Linked List  			:   4->8->11->20->4(circular)
	
	After insertion of 6 and 32		:   4->6->8->11->20->32->4(circular)
	
	Author : Aman Kimothi
	E-mail : kimothiaman@gmail.com
	Github : https://github.com/Aman-Kimothi/DSA
*/

class SortedInsertionCircularLinkedList  {
	
    static class Node {
		int data;
		Node next;
		
		public Node(int d) {
			data = d;
			next = null;    
		}
	}
        
	Node addFront(int data , Node last)  {
		
		Node new_node = new Node(data);
		
		if(last == null) {               // When there is only one node. It should point to itself
			last = new_node;
			new_node.next = last;
			return last;
		}
		
		new_node.next = last.next;
		last.next = new_node;           
		return last;
	}
	
	Node addEnd(int data , Node last)  {
		
		Node new_node = new Node(data) ;
		
		if(last == null) {               // When there is only one node. It should point to itself
			last = new_node;
			new_node.next = last;
			return last;
		}
		
		new_node.next = last.next;      // Putting the node at the end
		last.next = new_node;
		last = new_node;                // Making the last element as the last node         
		return last;
	}
	
	Node sortedInsert(int data, Node last) {
		
		Node new_node = new Node(data);
		
		if(last == null) {                  // If no element is present in the CLL
			new_node.next = last;
			last = new_node;
			last.next = new_node;
			return last;
		}
		
		if(last.next.data >= data) {        // Adding at the first position of the CLL
			new_node.next = last.next;
			last.next = new_node;
			return last;   
		}
		
		if(last.data <= data) {             // Adding at the last position of the CLL
			new_node.next = last.next;
			last.next = new_node;
			last = new_node;
			return last;
		}
		
		Node curr = last.next;              // Adding at all the other places
		Node prev = null;
		
		while(curr.data < data && curr.next != last.next) {
			prev = curr;
			curr = curr.next;
		}
		
		new_node.next = prev.next;          // Changing the links of the objects
		prev.next = new_node;
		return last;            
	}
	
	void print(Node last) {
		
			if(last == null) {
				System.out.println("Linked List is empty");
				return ;
			}                    
		
		Node temp = last.next;
		
		do  {                      // Printing all nodes except the last node  
			System.out.print(temp.data + "\t");     
			temp = temp.next;
			
		}   while( temp != last.next );       // Using do while so that last can be printed, otherwise it will have to be printed in a new statement
		System.out.println();                
	}
	
	public static void main(String args[]) {
		
		SortedInsertionCircularLinkedList list = new SortedInsertionCircularLinkedList();
                
		Node last = null;           // Circular Linked List

		last = list.sortedInsert(5 , last);
		last = list.sortedInsert(4 , last);
		last = list.sortedInsert(3 , last);
		last = list.sortedInsert(2 , last);
		last = list.sortedInsert(1 , last);
		last = list.sortedInsert(9 , last);
		last = list.sortedInsert(8 , last);
		last = list.sortedInsert(7 , last);
		last = list.sortedInsert(6 , last);
		
		System.out.println("The Circular Linked List using Sorted Insert is : " );
		list.print(last);	
    }
}
	
