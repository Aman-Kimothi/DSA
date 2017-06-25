/*
  	Insertion of nodes in a circular linked list. We've 4 cases :
  			
	1. Insertion of a node in an empty list.
	2. Insertion of a node at the beginning.
	3. Insertion of a node at the end.
	4. Insertion of a node after a Node whose value is given.
	
	Author : Aman Kimothi
	E-mail : kimothiaman@gmail.com
	Github : https://github.com/Aman-Kimothi/DSA
*/

class Insertion_CircularLinkedList  {
	
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
    
    /* There are 2 functions for adding a node after a specified node whose value is given.
			
		1.  add_after()
		2.  add_after_value()
		
		Both the functions work properly, but the second one is more readable and efficient.
	*/
	
    Node add_after(int data , Node last , int value)  {
        
        
        if(last == null) {
            System.out.println(data +"  cannot be added because the Linked List is empty");
            return null;
        }
        
        Node new_node = new Node(data);
        
        if(last.data == value)  {           // if the data is to be added after the last node
            new_node.next = last.next;
            last.next = new_node;
            last = new_node;
            return last;  
        }
        
        Node temp = last.next;
        
        while(temp.data != value && temp != last)       // Checking for the node whose data is value
            temp = temp.next;
        
        if(temp.data != value) {                        // Not found case
            System.out.println(data + " is not added because the element "+ value+" after which it is to be added is not present in the linked list");
            return last;
        }
                         
        new_node.next = temp.next;                  // Putting the new_node after it
        temp.next = new_node;
        
        return last;
    }
    
    // This is a better function for adding a node after a node.
    // Do not use the above function.
    
    Node add_after_value(int data , Node last , int value) {
        
        if(last == null) {    
            System.out.println(data +" cannot be added because the Linked List is empty");
            return null;
        }
        
        Node temp = last.next;
        Node new_node = new Node(data);
        
        do {
            
            if(temp.data == value)  {               // Finding the node after which the value should be added
                
                 new_node.next = temp.next;
                 temp.next = new_node;
                 
                 if(temp == last)                   // if the node is the last node
                    last = new_node;    
                
                return last;                    
            }
            temp = temp.next;
            
        }while(temp.next != last.next);
               
        System.out.println(data + " is not added because the element "+ value+" after which it is to be added is not present in the linked list");
        return last;
    }
   

	void print(Node last) {
        
        if(last == null) {
            System.out.println("Linked List is empty");
            return ;
        }                    
    
		Node temp = last.next;
		
		do  {                    			  // Printing all nodes except the last node  
			System.out.print(temp.data + "\t");     
			temp = temp.next;
			
		}   while( temp != last.next );       // Using do while so that last can be printed, otherwise it will have to be printed in a new statement
	
		System.out.println();                
    }

	public static void main(String args[]) {
	
	Insertion_CircularLinkedList list = new Insertion_CircularLinkedList();
            
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
        
        System.out.println("Circular Linked List is : " );
        list.print(last);	
        
        last = list.add_after(6 , last , 1);
        last = list.add_after(10 , last , 9);
        
        last = list.add_after_value(11 , last , 8);
        last = list.add_after_value(98 , last , 7);
        
        System.out.println("Circular Linked List after insertion is : " );
        list.print(last);	
    
    }
		
}
	
