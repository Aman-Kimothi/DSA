/*
	http://www.geeksforgeeks.org/quicksort-for-linked-list/

	Author : Aman Kimothi
	E-mail : kimothiaman@gmail.com
	Github : https://github.com/Aman-Kimothi/DSA
*/

class QuickSortDoublyLinkedList  {
	
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
        
        void quickSort(Node head) {
        	if(head == null)
        		return;
        		
        	Node left = head;	
        	Node right = lastNode(left);
        	quickSortList(left, right);
        }
        
        void quickSortList(Node left , Node right) {
        	if(left != null && right != null && left != right && left != right.next) {
        		Node partition = partition(left , right);
        		quickSortList(left , partition.prev);
        		quickSortList(partition.next , right);
        	}
        }
        
        Node partition(Node left , Node right) {
        	
        	Node i = left.prev;
        	int pivot = right.data;
        	
        	for(Node j = left ; j != right; j = j.next) {
        		
        		if(pivot > j.data) {
        			if(i == null)
        				i = left;
        			else
        				i = i.next;
        			int temp = i.data;
        			i.data = j.data;
        			j.data = temp;
        		}
        	}
			if(i == null)
				i = left;
			else
				i = i.next;
			
			int temp = i.data;
			i.data = right.data;
			right.data = temp;
			
			return i;
        }
        
        Node lastNode(Node head) {
        	
        	if(head == null )
        		return head;
        		
        	while(head.next != null)	
        		head = head.next;
        	
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
		
		QuickSortDoublyLinkedList list = new QuickSortDoublyLinkedList();
                
		Node head = null;           // Double Linked List
		
		head = list.addFront(6 , head);
		head = list.addFront(2 , head);
		head = list.addFront(3 , head);
		head = list.addFront(7 , head);
		head = list.addFront(2 , head);
		head = list.addFront(8 , head);
		head = list.addFront(3 , head);
		head = list.addFront(1 , head);
		head = list.addFront(9 , head);
		head = list.addFront(4 , head);
		
		list.print(head);
		
		list.quickSort(head);
		
		System.out.println("\n\nAfter sorting, the elements are : ");
		list.print(head);
        
    }
}
