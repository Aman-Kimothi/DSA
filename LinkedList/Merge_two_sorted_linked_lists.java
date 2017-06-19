/*
	Merge two sorted linked list into one sorted linked list.
	
	Input  :    Sorted List 1	:	5->10->15
				Sorted List 2 	: 	2->3->20 
				
	Output :	Sorted List   	: 	2->3->5->10->15->20	
	
	Author : Aman Kimothi
	E-mail : kimothiaman@gmail.com
	Github : https://github.com/Aman-Kimothi/DSA
*/
class Merge_two_sorted_linked_lists  {
	
	static class Node {
		int data;
		Node next;
		
		public Node(int d) {
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
	
	Node merge(Node head1 , Node head2 ) {
		
		Node temp = null;
		
		if(head1 == null)			// if the first list is finished
			return head2;
		if(head2 == null)			// if the second list is finished
			return head1;
			
		if(head1.data <= head2.data) {			// Adding the node whose value is smaller.
			temp = head1;
			temp.next = merge(head1.next , head2);		// Recursively merging the other nodes of both the lists
		}
		else {
			temp = head2;
			temp.next = merge(head1 , head2.next);		// Recursively merging the other nodes of both the lists
		}
		
		return temp;
	}
	
	void print(Node head) {
		Node temp = head;
		
		while(temp != null) {
			System.out.print(temp.data + "\t");
			temp = temp.next;
		}
		System.out.println();
	}
	
	public static void main(String args[]) {
		
		Merge_two_sorted_linked_lists list = new Merge_two_sorted_linked_lists();
		
		Node head1 = null, head2 = null, head3 = null;
		
		head1 = list.add_front(61230 , head1);
		head1 = list.add_front(4220 , head1);
		head1 = list.add_front(310 , head1);
		head1 = list.add_front(70 , head1);
		head1 = list.add_front(40 , head1);
		head1 = list.add_front(10 , head1);
		
		head2 = list.add_front(6245 , head2);
		head2 = list.add_front(2344 , head2);
		head2 = list.add_front(2221 , head2);
		head2 = list.add_front(880 , head2);
		head2 = list.add_front(60 , head2);
		head2 = list.add_front(23 , head2);
	
		System.out.println("1st Sorted Linked List is : " );
		list.print(head1); 			// Sorted Linked List 1
		System.out.println("2nd Sorted Linked List is : " );
		list.print(head2);			// Sorted Linked List 2
		
		head3 = list.merge(head1 , head2);
		
		System.out.println("Merged Sorted Linked List is : " );
		list.print(head3);			// Sorted Merged Linked List 3
	}
		
}
	
