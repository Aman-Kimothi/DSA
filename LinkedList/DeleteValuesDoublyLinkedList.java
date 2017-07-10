/*
	http://www.geeksforgeeks.org/delete-a-node-in-a-doubly-linked-list/

	Author : Aman Kimothi
	E-mail : kimothiaman@gmail.com
	Github : https://github.com/Aman-Kimothi/DSA
*/

class DeleteValuesDoublyLinkedList  {
	
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
        
        Node addFirstNode(int data , Node head) {
            
            Node new_node = new Node(data);
            return new_node;
        }
        
        Node addFront(int data , Node head ) {
            
            if(head == null)                        // If DLL is empty
                return addFirstNode(data , head);
            
            Node new_node = new Node(data);
            head.prev = new_node;                   // Putting the links in the prev and the next
            new_node.next = head;
            head = new_node;                  
            return head;
        }
        
        /**  1st case  -  Deleting the head node
    	 *   2nd case  -  Deleting the last node
    	 *   3rd case  -  Deleting any other node
    	 */
        
        Node delete(int data , Node head) {
        	
        	if(head == null) {
        		System.out.println("Doubly Linked List is empty");
                return head;
        	}
        	
        	if(head.data == data) {       // 1st case  :  deleting the head node
        		
        		if(head.next != null)     // More than one node in the list
        			head.next.prev = null;
        			
        		head = head.next;	
        		return head;
        	}
        	
        	Node temp = head;
        	
        	while(temp.data != data && temp != null)
        		temp = temp.next;
        		
        	if(temp == null) {
        		System.out.println("Value given is not present in the Doubly Linked List");
			return head;
	        }	
        		
        	if(temp.next == null) {    // 2nd case  :  Deleting the last node
        		temp.prev.next = null;
        		temp.prev = null;
        		return head;
        	}   
        	 
        	temp.prev.next = temp.next;
        	temp.next.prev = temp.prev;
        	return head;
        }
        
        
        void print(Node head) {
            
            if(head == null) {
                System.out.println("Doubly Linked List is empty");
                return ;
            }
            
            Node curr = head;
            Node prev = null;
            
            System.out.println("\nFrom the first element to the head element");
            
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
        }
        
	public static void main(String args[]) {
		
		DeleteValuesDoublyLinkedList list = new DeleteValuesDoublyLinkedList();
                
		Node head = null;           // Double Linked List
		
		head = list.addFront(10 , head);
		head = list.addFront(9 , head);
		head = list.addFront(8 , head);
		head = list.addFront(7 , head);
		head = list.addFront(6 , head);
		head = list.addFront(5 , head);
		head = list.addFront(4 , head);
		head = list.addFront(3 , head);
		head = list.addFront(2 , head);
		head = list.addFront(1 , head);
		
		list.print(head);
		
		head = list.delete(1 , head);	    // Case 1
		head = list.delete(6 , head);		// Case 3
		head = list.delete(3 , head);		// Case 3
		head = list.delete(10 , head);		// Case 2
		
		list.print(head);
        
    }
}
