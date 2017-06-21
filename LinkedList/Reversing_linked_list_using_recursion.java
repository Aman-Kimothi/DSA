	
/*	Reversing a linked list. Some examples are : 
	
	Input 	: 	1->2->3->4->NULL
	Output 	:	4->3->2->1->NULL
	
	Input 	: 	1->NULL
	Output 	:	1->NULL
	
	Input 	: 	NULL
	Output 	:	NULL
       
	Author : Aman Kimothi
	E-mail : kimothiaman@gmail.com
	Github : https://github.com/Aman-Kimothi/DSA
*/

class Reversing_linked_list_using_recursion  {
	
    static Node head;
	
	static class Node {
		int data;
		Node next;
		
		public Node(int d) {
			data = d;
			next = null;
		}
	}
	
	void add_front(int data)  {
		
		Node new_node = new Node(data);
		new_node.next = head;
		head = new_node;
	}
        
	static void reverse(Node curr , Node prev) {
		
		if(curr.next == null) {       		  // Last node of the LL : Making it head of the LL
			head = curr;
			curr.next = prev;
			return;
		}
		
		Node temp = curr.next;				   // Storing the next node of the current node
		
		curr.next = prev;                      // Reversing the 2 nodes
		
		reverse(temp , curr);				   // Recursively reversing all the other nodes
		
	}
	
	void print() {
		Node temp = head;
		
		while(temp != null) {
			System.out.print(temp.data + "\t");
			temp = temp.next;
		}
		System.out.println();
	}
	
	public static void main(String args[]) {
		
		Reversing_linked_list_using_recursion obj = new Reversing_linked_list_using_recursion();
		
		obj.add_front(8);
		obj.add_front(7);
		obj.add_front(6);
		obj.add_front(5);
		obj.add_front(4);
		obj.add_front(3);
		obj.add_front(2);
		obj.add_front(1);
		
		System.out.println("Before reversing : ");
		obj.print();	
                
        reverse(head , null);
	
		System.out.println("After reversing : ");
		obj.print();	
		
	}
}
	
