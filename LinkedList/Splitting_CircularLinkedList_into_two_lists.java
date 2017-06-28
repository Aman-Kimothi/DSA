/*
	Splitting a circular linked list into 2 equal halves.
	
	Original Circular Linked List       :		11->2->56->12->14->22->... (Cir)
	
	First Circular Linked List			:		11->2->56->... (Cir)
	
	Second Circular Linked List			:   	12->14->22->... (Cir)
	
	
	Author : Aman Kimothi
	E-mail : kimothiaman@gmail.com
	Github : https://github.com/Aman-Kimothi/DSA
*/

class Splitting_CircularLinkedList_into_two_lists  {
	
    static class Node {
		int data;
		Node next;
		
		public Node(int d) {
			data = d;
			next = null;    
		}
	}
    
    Node add_front(int data , Node last)  {
        
        Node new_node = new Node(data);
        
        if(last == null) {               // When there is only one node. It should point to itself
            last = new_node;
            new_node.next = last;
            return last;
        }
        
        new_node.next = last.next;
        last.next = new_node;           
        return last;
    }
    
    Node add_end(int data , Node last)  {
        
        Node new_node = new Node(data) ;
        
        if(last == null) {               // When there is only one node. It should point to itself
            last = new_node;
            new_node.next = last;
            return last;
        }
        
        new_node.next = last.next;      // Putting the node at the end
        last.next = new_node;
        last = new_node;                // Making the last element as the last node         
        return last;
    }
    
    // This function returns the new last node of the first part and the last of the second node remains the same
    Node split(Node last)  {
        
        if(last == null) {   
            System.out.println("Cannot split as the Linked List is empty");
            return last;
        }
        
        if(last.next == last) {   
            System.out.println("Cannot split as only one element is present in the Linked List");
            return last;
        }
        
        Node slow = last.next;
        Node fast = last.next;
        
        while(fast.next != last.next && fast.next != last) {
            slow = slow.next;
            fast = fast.next.next;                  
        }
        
        Node temp = slow.next;          // Storing the first node of the second splitted list
        slow.next = last.next;          // Putting the first node link to the last of the first splitted link
        last.next = temp;               // Putting the first node link to the last of the second splitted link
        
        return slow;
    }
    
	void print(Node last) {
			
		if(last == null) {
			System.out.println("Linked List is empty");
			return ;
		}                    
			
		Node temp = last.next;
		
		do {            			
			System.out.print(temp.data + "\t");     
			temp = temp.next;
			
		}while( temp != last.next );       // Using do while so that last can be printed, otherwise it will have to be printed in a new statement
		System.out.println();                
    }

	public static void main(String args[]) {
		
		Splitting_CircularLinkedList_into_two_lists list = new Splitting_CircularLinkedList_into_two_lists();
				
		Node last = null;           // Circular Linked List
		
		last = list.add_front(5 , last);
		last = list.add_front(4 , last);
		last = list.add_front(3 , last);
		last = list.add_front(2 , last);
		last = list.add_front(1 , last);
		last = list.add_end(9 , last);
		last = list.add_end(8 , last);
		last = list.add_end(7 , last);
		last = list.add_end(6 , last);
				
		list.print(last);	
		
		Node last1 = list.split(last);
		
		// last1 is the last node of the first splitted part
		// last is the last node of the second splitted part
		
		if(last == last1)   return ;     // To stop the printing if the splitting hasn't been done.                    
		
		System.out.print("\nThe first part of the list is : ");
		list.print(last1);
		
		System.out.print("\nThe second part of the list is : ");
		list.print(last);	
		
	}
}
	
