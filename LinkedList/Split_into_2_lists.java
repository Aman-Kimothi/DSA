/*  	
	Splitting a linked list into 2 linked lists. We have 2 cases for this :
	
	1. When there are even number of nodes.
		Original linked list     : 1->2->3->4->5->6
		Splitted  linked list    : 1->2->3   and  4->5->6
		
	2. When there are odd number of nodes.
		Original linked list     : 1->2->3->4->5
		Splitted  linked list    : 1->2->3   and  4->5
	
	Author : Aman Kimothi
	E-mail : kimothiaman@gmail.com
	Github : https://github.com/Aman-Kimothi/DSA
*/

class Split_into_2_lists {
	
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
	
	/* split function splits the head into two halves :
		   head : head of the first part
		   temp : head of the second part
	*/
	Node split(Node head)  {
		
		if(head == null) {			// Linked list is empty
			return null;
		}
		
		Node fast = head;
		Node slow = head;
		
		while(fast.next != null && fast.next.next != null)  {
			fast = fast.next.next;
			slow = slow.next;
		}
		
		Node temp = slow.next;
		slow.next = null;
		
		return temp;			// returning the head of the second part
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
		
		Split_into_2_lists obj = new Split_into_2_lists();
		
		Node head1 = null , head2= null;
		
		head1 = obj.add_front( 7 , head1);
		head1 = obj.add_front( 6 , head1);
		head1 = obj.add_front( 5 , head1);
		head1 = obj.add_front( 4 , head1);
		head1 = obj.add_front( 3 , head1);
		head1 = obj.add_front( 2 , head1);
		head1 = obj.add_front( 1 , head1);
		
		System.out.print("The linked list is :  " );
		obj.printList(head1);
		
		head2 = obj.split(head1);
		
		if(head1 != null || head2 != null)  {
		
			System.out.println("***********************" );
			System.out.println("    After splitting" );
			System.out.println("***********************" );
			
			
			System.out.print("The first linked list is  :  " );
			obj.printList(head1);
			
			System.out.print("The second linked list is :  " );
			obj.printList(head2);
		}
		else
			System.out.print("The linked list is empty" );
	}
}