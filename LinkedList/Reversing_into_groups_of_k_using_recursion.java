/*  	
	Reversing every 'k' nodes of a linked list.
	
	Inputs	:  1->2->3->4->5->6->7->8->NULL  and  k = 3 
	Output	:  3->2->1->6->5->4->8->7->NULL 
	
	Inputs	:  1->2->3->4->5->6->7->8->NULL  and  k = 5
	Output	:  5->4->3->2->1->8->7->6->NULL 
	
	Author : Aman Kimothi
	Github : https://github.com/Aman-Kimothi/DSA
*/

class Reversing_into_groups_of_k_using_recursion  {
	
	static Node head1 , head2 ;
	
	static class Node {
		int data;
		Node next;
		
		public Node(int d) {
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
	
	/*      Understanding the linking of one group to another.
	
			1 2 3 4 5 6 7 8   :  List  when k = 3
	
			After first reverse()  :
			
			first   = 1
			temp    = 4
			res[]   = 3 4
			
			1 -> 6    :  first.next = res[0]  // '6' 7
			
			first  =  4     :  first = temp
			
			After second reverse()  :
			
			first   = 4
			temp    = 7
			res[]   = 6 7
			
			4 -> 7    :  first.next = res[0]  // '7' null
			
			first  =  7     :  first = temp
	
	*/
	
	Node groupNodes(Node head, int k) {
		
		if(k <= 1)	return head;
		
		Node first = head;			// to store the first element of the group so that we can link the second group to it
		
		Node[] res = reverse(head.next , head , k-1);
		
		Node hh = res[0]; 			// last element of the group
		
		while(res[0] != null && res[1] != null)  {
			
			Node temp = res[1]; 	 // first element of the next group
			
			res = reverse(res[1].next , res[1] , k-1 );
			
			first.next = res[0];	 // Linking the last element of the last group to the first element of the second group
			
			first = temp;       	 // Storing the first element of the present group which will be last element after grouping.  The first element of the coming next set will be linked to this node.
		}
		
		return hh;
	}
	
	Node[] reverse(Node curr , Node prev , int k) {
		
		// This func returns the last element of the present group and first element of the next group.
		
		Node[] result = {null , null};
		
		if(curr == null)  {				// list is finished
			result[0] = prev;
			prev.next = null;
			return result;
		}
		
		if(curr.next == null)			// Last element is reached
			prev.next = null;
		
		if( k == 1 || curr.next == null) {       // LL is completely grouped once
			result[0] = curr;
			result[1] = curr.next;
			curr.next = prev;
			return result;
		}
		
		Node temp = curr.next;			// Grouping being done here.
		curr.next = prev;                
		
		return reverse(temp , curr , k-1);
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
		
		Reversing_into_groups_of_k_using_recursion list = new Reversing_into_groups_of_k_using_recursion();
		
		head1 = list.add_front(8 , head1);
		head1 = list.add_front(7 , head1);
		head1 = list.add_front(6 , head1);
		head1 = list.add_front(5 , head1);
		head1 = list.add_front(4 , head1);
		head1 = list.add_front(3 , head1);
		head1 = list.add_front(2 , head1);
		head1 = list.add_front(1 , head1);
		
		list.print(head1);	
		
		head2 = list.groupNodes(head1 , 3);
	
		System.out.print("\nThe Linked List after grouping is : \n " );
		list.print(head2);	
	}
}
