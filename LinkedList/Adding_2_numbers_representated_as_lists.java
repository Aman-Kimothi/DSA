/*  	
	Adding 2 numbers represented as linked lists. 
	Every digit of the number is getting added at the front of the list.
	
	Input:
	  First List: 5->6->3			 // represents number  365
	  Second List: 8->4->2 			 //  represents number 248
	Output
	  Resultant list: 3->1->6  		 // represents number  613
	
	Author : Aman Kimothi
	E-mail : kimothiaman@gmail.com
	Github : https://github.com/Aman-Kimothi/DSA
*/

class Adding_2_numbers_representated_as_lists {
	
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
		
	Node add_two_list(Node head1 , Node head2) {
		
		Node result = null;				// to store the added linked list
		int carry = 0;					// to store the carry
		
		while(head1 != null && head2 != null) {			// to store the added elements of both the lists
			int temp = head1.data + head2.data + carry;
			result = add_end(temp % 10 , result);
			carry = temp / 10;
			head1 = head1.next;
			head2 = head2.next;
		}
		
		while(head1 != null)  {							// This adds the rest elements when head2 gets finished
			int temp = head1.data + carry;
			result = add_end(temp % 10 , result);
			carry = temp / 10;
			head1 = head1.next;
		}
		
		while(head2 != null)  {							// This adds the rest elements when head1 gets finished
			int temp = head2.data + carry;
			result = add_end(temp % 10 , result);
			carry = temp / 10;
			head2 = head2.next;
		}
		
		if(carry > 0 )
			result = add_end(carry , result);
			
		return result;	
	}
	
	void printList(Node head)  {
		
		Node temp = head ;
		
		while(temp != null) {
			System.out.print(temp.data + "  ");
			temp = temp.next;
		}
		System.out.println();
	}
	
	public static void main(String args[]) {
		
		Adding_2_numbers_representated_as_lists obj = new Adding_2_numbers_representated_as_lists();
		
		Node head1 = null , head2 = null , head3 = null;
		
		head1 = obj.add_front(3 , head1);
		head1 = obj.add_front(6 , head1);
		head1 = obj.add_front(5 , head1);
		
		head2 = obj.add_front(2 , head2);
		head2 = obj.add_front(4 , head2);
		head2 = obj.add_front(8 , head2);
		
		System.out.print("Number 1\t : ");
		obj.printList(head1);	
		System.out.print("Number 2\t : ");
		obj.printList(head2);	
		
		head3 = obj.add_two_list(head1 , head2);
		
		System.out.print("Added Number : ");
		obj.printList(head3);
		
	}
}