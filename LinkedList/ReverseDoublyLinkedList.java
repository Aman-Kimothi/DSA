/*
	http://www.geeksforgeeks.org/reverse-a-doubly-linked-list/

	Author : Aman Kimothi
	E-mail : kimothiaman@gmail.com
	Github : https://github.com/Aman-Kimothi/DSA
*/

class ReverseDoublyLinkedList  {
	
    static class Node {
		int data;
        Node prev;
		Node next;
		
		public Node(int d) {
			data = d;
            prev = null;
			next = null;    
		}
	}
        
    Node add_first_node(int data , Node head) {
        
        Node new_node = new Node(data);
        return new_node;
    }
    
    Node add_front(int data , Node head ) {
        
        if(head == null)                        // If DLL is empty
            return add_first_node(data , head);
        
        Node new_node = new Node(data);
        head.prev = new_node;                   // Putting the links in the prev and the next
        new_node.next = head;
        head = new_node;                  
        return head;
    }
    
   Node reverse(Node head) {
   	
   		Node curr = head;			// to point to the current node
   		Node prev = null;			// to point to the previous node
   		Node next = null;			// to point to the next node
   		
   		while(curr != null) {
   			next = curr.next;		// Saving the next node
   			curr.next = prev;		// Link the prev element to the next of the current
   			curr.prev = next;		// Link the next element to the prev of the current
   			prev = curr;			// Changing the current to previous node
   			curr = next;			// Changing the next to current node
   		}
   		return prev;
   }
    
   void print(Node head) {
        
        if(head == null) {
            System.out.println("Doubly Linked List is empty");
            return ;
        }
        
        Node curr = head;
        Node prev = null;
        
        System.out.println("From the first element to the head element");
        
        while( curr != null) {
            System.out.print(curr.data + "\t");
            prev = curr;
            curr  = curr.next;
        }
        
        System.out.println("\nFrom the head element to the first element");
                    
        while(prev != null) {
            System.out.print(prev.data + "\t");
            prev = prev.prev;
        }
        System.out.println();
    }
        
	public static void main(String args[]) {
		
		ReverseDoublyLinkedList  list = new ReverseDoublyLinkedList();
                
        Node head = null;           // Double Linked List
		
		head = list.add_front(5 , head);
		head = list.add_front(4 , head);
		head = list.add_front(3 , head);
		head = list.add_front(2 , head);
		head = list.add_front(1 , head);
	            
        System.out.println("**********************");
        System.out.println("   Before Reversing  ");
        System.out.println("**********************");
        list.print(head);	
        
        head = list.reverse(head);
                
        System.out.println("**********************");
        System.out.println("   After Reversing : ");
        System.out.println("**********************");
        list.print(head);	
        
        }
}