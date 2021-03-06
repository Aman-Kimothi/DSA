/*  	
	Swapping of a node in a linked list. We have 3 cases for this :
	
	1. One of the elements may not be present in the Linked List.
	2. One of the elements is the head node of the Linked List.
	3. One of the elements is the last node of the Linked List.
	4. Both the elements are present in the Linked List
	
	Author : Aman Kimothi
	E-mail : kimothiaman@gmail.com
	Github : https://github.com/Aman-Kimothi/DSA
*/

class SwappingOfNodes {
	
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
		
	Node swapValues(int data1 , int data2 , Node head)  {
		
		Node prev1 = null , curr1 = head;
		Node prev2 = null , curr2 = head;
		
		while(curr1 != null && curr1.data != data1) {
			prev1 = curr1;
			curr1 = curr1.next;
		}
			
		while(curr2 != null && curr2.data != data2) {
			prev2 = curr2;
			curr2 = curr2.next;
		}
		
		if(curr1 == null || curr2 == null) {
			System.out.println("\nCannot swap the values as one(or both) values are missing");
			return head;
		}
		
		if(prev1 == null)   		// if data1 is at 1st position (head)
			head = curr2;
		else
			prev1.next = curr2;
		
		if(prev2 == null)  			// if data2 is at 1st position (head)
			head = curr1;
		else
			prev2.next = curr1;
			
		Node temp = curr1.next;   	// swapping the next values of the nodes
		curr1.next = curr2.next;
		curr2.next = temp;
		
		return head;
	}
	
	Node swapNodes(Node data1 , Node data2 , Node head)  {
		
		Node prev1 = null , curr1 = head;
		Node prev2 = null , curr2 = head;
		
		while(curr1 != null && curr1 != data1) {
			prev1 = curr1;
			curr1 = curr1.next;
		}
			
		while(curr2 != null && curr2 != data2) {
			prev2 = curr2;
			curr2 = curr2.next;
		}
		
		if(curr1 == null || curr2 == null) {
			System.out.println("\nCannot swap the nodes as one(or both) nodes are missing");
			return head;
		}
		
		if(prev1 == null)   		// if data1 is at 1st position (head)
			head = curr2;
		else
			prev1.next = curr2;
		
		if(prev2 == null)  			// if data2 is at 1st position (head)
			head = curr1;
		else
			prev2.next = curr1;
			
		Node temp = curr1.next;   	// swapping the next values of the nodes
		curr1.next = curr2.next;
		curr2.next = temp;
		
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
		
		SwappingOfNodes obj = new SwappingOfNodes();
		
		Node head = null;
		
		head = obj.addFront( 6, head);
		head = obj.addFront( 5 , head);
		head = obj.addFront( 4, head);
		head = obj.addFront( 3 , head);
		head = obj.addFront( 2, head);
		head = obj.addFront( 1 , head);
		
		System.out.print("Linked List is  :  " );
		obj.printList(head);
		
		// Using swap_value to swap the nodes
		
		if(head == null) {
			System.out.print("The Linked List is empty" );
			return ;
		}
		
		System.out.print("\nAfter swapping  :  " ); 		// Case 2
		head = obj.swapValues(1 , 2, head);
		obj.printList(head);
		
		System.out.print("\nAfter swapping  :  " ); 		// Case 3
		head = obj.swapValues(5 , 6, head);
		obj.printList(head);
		
		System.out.print("\nAfter swapping  :  " ); 		// Case 4
		head = obj.swapValues(3 , 4, head);
		obj.printList(head);
		
		System.out.print("\nAfter swapping  :  " ); 		// Case 1
		head = obj.swapValues(3 , 10, head);
		obj.printList(head);
		
		// Using swapNodes to swap the nodes
		
		System.out.print("\nAfter swapping  :  " ); 		// Case 2
		head = obj.swapNodes(head , head.next, head);
		obj.printList(head);
		
		System.out.print("\nAfter swapping  :  " ); 		// Case 3
		head = obj.swapNodes(head.next.next.next.next , head.next.next , head);
		obj.printList(head);
		
		System.out.print("\nAfter swapping  :  " ); 		// Case 4
		head = obj.swapNodes(head.next.next.next.next , head.next.next.next.next.next , head);
		obj.printList(head);
		
		System.out.print("\nAfter swapping  :  " ); 		// Case 1
		head = obj.swapNodes(head.next.next.next.next , head.next.next.next.next.next.next , head);
		obj.printList(head);
	}
}