	
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

class Reversing_linked_list_using_iteration  {
	
    static class Node {
		int data;
		Node next;
		
		public Node(int d) {
			data = d;
			next = null;
		}
	}
	
	Node add_front(int data, Node head)  {
		
		Node new_node = new Node(data);
		new_node.next = head;
		head = new_node;
		return head;
	}
        
	Node reverse(Node head) {
		
		Node curr = head;				// to point to the current node
    	Node prev = null;				// to point to the previous node
    	Node temp = null;				// to point to the next node
    	
    	while(curr != null)  {
    		temp = curr;				// Current element
    		curr = curr.next;			// Next element
    		temp.next = prev;			// Linking the previous element to the current element
    		prev = temp;				// Making the current element as previous
    	}
    	return prev;
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
		
		Reversing_linked_list_using_iteration obj = new Reversing_linked_list_using_iteration();
		
		Node head = null;
		
		head = obj.add_front(8, head);
		head = obj.add_front(7, head);
		head = obj.add_front(6, head);
		head = obj.add_front(5, head);
		head = obj.add_front(4, head);
		head = obj.add_front(3, head);
		head = obj.add_front(2, head);
		head = obj.add_front(1, head);
		
		System.out.println("Before reversing : ");
		obj.print(head);	
                
        head = obj.reverse(head);
	
		System.out.println("After reversing : ");
		obj.print(head);	
		
	}
}
	
