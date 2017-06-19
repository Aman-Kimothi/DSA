/*  	
	Print the middle element of a linked list. We have 2 cases for this :
	
	1. When there are odd number of nodes in the list
		1->2->3->4->5 			:   Middle Element - 3
	
	2. When there are even number of nodes in the list
		1->2->3->4->5->6		:   Middle Element - 4
	
	Author : Aman Kimothi
	Github : https://github.com/Aman-Kimothi/DSA
*/

class Print_Middle_Element_of_a_list {
	
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
		
	void middleElement(Node head)  {
		
		Node first = head;
		Node second = head;
		
		if(head != null)  {
			while( first != null && first.next != null) {
				first = first.next.next;
				second = second.next;
			}
		}
		System.out.println("\nMiddle Element is : "+second.data);
			
	}
	void printList(Node head)  {
		
		Node temp = head ;
		
		while(temp != null) {
			System.out.print(temp.data + "  ");
			temp = temp.next;
		}
	}
	
	public static void main(String args[]) {
		
		Print_Middle_Element_of_a_list obj = new Print_Middle_Element_of_a_list();
		
		Node head = null;
		
		head = obj.add_front( 7 , head);
		head = obj.add_front( 6 , head);
		head = obj.add_front( 5 , head);
		head = obj.add_front( 4 , head);
		head = obj.add_front( 3 , head);
		head = obj.add_front( 2 , head);
		
		
		obj.printList(head);
		obj.middleElement(head);
		
		head = obj.add_front( 1, head);
	
		obj.printList(head);
		obj.middleElement(head);
			
	}
}