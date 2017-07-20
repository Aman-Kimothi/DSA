	
/*	Rotating a linked list counter-clockwise by k nodes, 
	where k is a given positive integer (less than the length of the list)
	
	Input   :   k     = 4
			    list  =  10->20->30->40->50->60
			   
	Output	:	list  =  50->60->10->20->30->40	    
			   
	Author : Aman Kimothi
	E-mail : kimothiaman@gmail.com
	Github : https://github.com/Aman-Kimothi/DSA
*/

class RotatingListKTimes  {
	
	static class Node {
		int data;
		Node next;
		
		public Node(int d) {
			data = d;
			next = null;
		}
	}
	
	Node addFront(int data , Node head)  {
		
		Node new_node = new Node(data);
		new_node.next = head;
		head = new_node;
		return head;
	}
        
	Node rotate(Node head , int k)  {
		
		if(k == 0)	return head;
		
		Node new_head = null;
		Node temp = head;
		
		while(0 < --k && temp != null)   // shifting to 'k' places after head
			temp = temp.next;
		
		if(temp == null )               // 'k' is greater than the length of the linked list
		  return temp;
		
		Node last = temp;               // storing the last element of the rotated list
			
		temp = temp.next;               // new head of the rotated list
		new_head = temp;
		
		last.next = null;               // putting null to the last element of the rotated list
		
		if(temp == null)                // 'k' is equal to the length of the linked list
		   return head;
		
		while(temp.next != null)        // traversing to the last element of the original list
			temp = temp.next;
		
		temp.next = head;               // putting the shifted elements at the end
		
		return new_head;                // returning new head
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
		
		RotatingListKTimes list = new RotatingListKTimes();
		
		Node head = null;
		
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
                
        int k = 7;      // Rotating the linked list by 7 elements
		
		head = list.rotate(head , k);
	
		if(head != null) {
			System.out.print("The Linked List after rotating is : \n " );
			list.print(head);	
		}
		else
			System.out.print("Rotating factor is greater than the length of the linked list " );                  
		// To avoid the above scenario send ( k % length of LL ) in the second parameter of the rotate function.
	}
}
	
