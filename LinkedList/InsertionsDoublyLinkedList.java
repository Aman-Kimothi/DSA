/*
	http://www.geeksforgeeks.org/doubly-linked-list/

	Author : Aman Kimothi
	E-mail : kimothiaman@gmail.com
	Github : https://github.com/Aman-Kimothi/DSA
*/

class InsertionsDoublyLinkedList  {
	
	static class Node {
		int data;
		Node prev;
		Node next;
		
		public Node(int d) {
			data = d;
						prev = null;
			next = null;    
		}
	}
	
	Node add_first_node(int data , Node head) {
		
		Node new_node = new Node(data);
		return new_node;
	}
	
	Node add_front(int data , Node head ) {
		
		if(head == null)                        // If DLL is empty
			return add_first_node(data , head);
		
		Node new_node = new Node(data);
		head.prev = new_node;                   // Putting the links in the prev and the next
		new_node.next = head;
		head = new_node;                  
		return head;
	}
	
	Node add_end(int data , Node head ) {
		
		if(head == null)                        // If DLL is empty
			return add_first_node(data , head);
		
		Node temp = head;
		
		while(temp.next != null)
			temp = temp.next;
			   
		Node new_node = new Node(data);
		new_node.prev = temp;                   // Putting the links in the prev and the next
		temp.next = new_node;                  
		return head;
	}
	
	Node add_before_node(int data , Node head, Node node) {
		
		if(head == null) {                       // If DLL is empty
			System.out.println("The doubly linked list is empty");
			return head;
		}
		
		Node temp = head;
				 
		while(temp != null && temp != node)     // Traversing to check whether the node is present or not
			temp = temp.next;
		
		if(temp == null){                       // The given node is not present in the DLL
			System.out.println("The node is not present in the doubly linked list ");
			return head;
		}
		
		Node new_node = new Node(data);
		
		new_node.next = node;                   // Putting the links in the prev and the next
		
		if(node != head)  {                 // If it's NOT being added at the head
			new_node.prev = node.prev; 
			node.prev.next = new_node;
		}
		else
			head = new_node;                // If it's getting ADDED at the head
		
		node.prev = new_node;
		return head;
	}
	
	Node add_after_node(int data , Node head, Node node) {
		
		if(head == null) {                       // If DLL is empty
			System.out.println("The doubly linked list is empty");
			return head;
		}
		
		Node temp = head;
				 
		while(temp != null && temp != node)     // Traversing to check whether the node is present or not
			temp = temp.next;
		
		if(temp == null){                       // The given node is not present in the DLL
			System.out.println("The node is not present in the doubly linked list ");
			return head;
		}
		
		Node new_node = new Node(data);
		new_node.prev = node;                   // Putting the links in the prev and the next
		new_node.next = node.next; 
		
		if(node.next != null)                   // If it's NOT being added at the end
			node.next.prev = new_node;
		
		node.next = new_node;                  
		return head;
	}
	
	
	void print(Node head) {
		
		if(head == null) {
			System.out.println("Doubly Linked List is empty");
			return ;
		}
		
		Node curr = head;
		Node prev = null;
		
		System.out.println("\nFrom the first element to the head element\n");
		
		while( curr != null) {
			System.out.print(curr.data + "\t");
			prev = curr;
			curr  = curr.next;
		}
		
		System.out.println("\nFrom the head element to the first element\n");
					
		while(prev != null) {
			System.out.print(prev.data + "\t");
			prev = prev.prev;
		}
	}
	
	public static void main(String args[]) {
	
	InsertionsDoublyLinkedList  list = new InsertionsDoublyLinkedList();
			
		Node head = null;           // Double Linked List
	
		head = list.add_front(5 , head);
		head = list.add_front(4 , head);
		head = list.add_front(3 , head);
		head = list.add_front(2 , head);
		head = list.add_front(1 , head);
		head = list.add_end(9 , head);
		head = list.add_end(8 , head);
		head = list.add_end(7 , head);
		head = list.add_end(6 , head);
			
		list.print(head);	
		
		head = list.add_before_node(6 , head , head);                       // at 1st positiom
		head = list.add_after_node(10 , head , head.next.next);             // at 4th position    
		head = list.add_before_node(11 , head , head.next.next.next.next);  // at 5th position
		head = list.add_after_node(98 , head , head.next.next.next.next.next.next); // at 8th position
		
		System.out.println("\n\n");
		list.print(head);	
	
	}
}
	
