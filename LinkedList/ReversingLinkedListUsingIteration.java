	
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

class ReversingLinkedListUsingIteration  {
	
    static class Node {
		int data;
		Node next;
		
		public Node(int d) {
			data = d;
			next = null;
		}
	}
	
	Node addFront(int data, Node head)  {
		
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
		
		ReversingLinkedListUsingIteration obj = new ReversingLinkedListUsingIteration();
		
		Node head = null;
		
		head = obj.addFront(8, head);
		head = obj.addFront(7, head);
		head = obj.addFront(6, head);
		head = obj.addFront(5, head);
		head = obj.addFront(4, head);
		head = obj.addFront(3, head);
		head = obj.addFront(2, head);
		head = obj.addFront(1, head);
		
		System.out.println("Before reversing : ");
		obj.print(head);	
                
        head = obj.reverse(head);
	
		System.out.println("After reversing : ");
		obj.print(head);	
		
	}
}
	
