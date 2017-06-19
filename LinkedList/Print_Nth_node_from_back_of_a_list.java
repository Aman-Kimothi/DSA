/*  	
	Printing Nth node from the back of a linked list. We have 4 cases for this :
	
	1. N is greater than the length of the linked list
	2. Nth position from back signifies the head node of the linked list
	3. Nth position from back signifies the last node of the linked list
	4. Nth position from back signifies any other node of the linked list
	
	Author : Aman Kimothi
	Github : https://github.com/Aman-Kimothi/DSA
*/

class Print_Nth_node_from_back_of_a_list {
	
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
	
	void printNnode(int n, Node head) {
		
		Node first = head;
		Node second = head;
		int count = n;
		
		while(0 < --count && first != null)
			first = first.next;
			
		if(first == null )  {				// Case 1
			System.out.println("The value of n = "+ n +" is greater than the length");
			return;
		}	
		
		while(first.next != null) {			// Case 2 , 3 & 4
			first = first.next;
			second = second.next;
		}	
		
		System.out.println("The "+n+"th Node from back is : "+second.data);
	}
	
	
	void printList(Node head)  {
		
		Node temp = head ;
		
		while(temp != null) {
			System.out.print(temp.data + "  ");
			temp = temp.next;
		}
	}
	
	public static void main(String args[]) {
		
		Print_Nth_node_from_back_of_a_list obj = new Print_Nth_node_from_back_of_a_list();
		
		Node head = null;
		
		head = obj.add_front( 6 , head);
		head = obj.add_front( 5 , head);
		head = obj.add_front( 4 , head);
		head = obj.add_front( 3 , head);
		head = obj.add_front( 2 , head);
		head = obj.add_front( 1 , head);
		
		obj.printList(head);
		System.out.println();
		
		obj.printNnode(1 , head);			// Case 2
		
		obj.printNnode(4 , head);			// Case 4
		
		obj.printNnode(6 , head);			// Case 3
		
		obj.printNnode(10 , head);			// Case 1
	}
}
