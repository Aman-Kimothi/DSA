/*  	
	Searching of a node in a linked list. We have 3 cases for this :
	
	1. The linked list is empty.
	2. The node is present in the list.
	3. The node is not present in the list.
	
	Author : Aman Kimothi
	Github : https://github.com/Aman-Kimothi/DSA
*/

class Searching_of_Nodes {
	
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
	
	int search(int key , Node head) {
		
		Node temp = head;
		int pos = 1;
		
		if(head == null) {
			System.out.println("The Linked List is empty");
			return -1;
		}
		
		while(temp != null) {
			
			if(temp.data == key)
				return pos;
			
			pos++;	
			temp = temp.next;
		}
		
		System.out.println("The Node with value "+ key +" is not present in the Linked List");
		return -1;
	}
	
	void printList(Node head)  {
		
		Node temp = head ;
		
		while(temp != null) {
			System.out.print(temp.data + "  ");
			temp = temp.next;
		}
	}
	
	public static void main(String args[]) {
		
		Searching_of_Nodes obj = new Searching_of_Nodes();
		
		Node head = null;
		
		head = obj.add_front( 44 , head);
		head = obj.add_front( 11, head);
		head = obj.add_front( 32 , head);
		head = obj.add_front( 1, head);
		head = obj.add_front( 2333 , head);
		head = obj.add_front( 11223, head);
		
		System.out.print("The linked list is :  " );
		obj.printList(head);
		
		int a = 2333 , b = 222 , pos;
		
		pos = obj.search(a , head);
		if(pos != -1)	
			System.out.println("\nPosition of "+ a +" is : " +pos);
		
		pos = obj.search(b , head);
		if(pos != -1)	
			System.out.println("Position of "+ b +" is : " +pos);
	}
}