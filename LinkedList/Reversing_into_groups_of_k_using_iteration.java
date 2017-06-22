/*  	
	Reversing every 'k' nodes of a linked list.
	
	Inputs	:  1->2->3->4->5->6->7->8->NULL  and  k = 3 
	Output	:  3->2->1->6->5->4->8->7->NULL 
	
	Inputs	:  1->2->3->4->5->6->7->8->NULL  and  k = 5
	Output	:  5->4->3->2->1->8->7->6->NULL 
	
	Author : Aman Kimothi
	E-mail : kimothiaman@gmail.com
	Github : https://github.com/Aman-Kimothi/DSA
*/

class Reversing_into_groups_of_k_using_iteration  {
	
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
	
	Node groupNodes(Node head, int k) {
		
		if(head.next == null)
			return head;
			
		Node curr = head;
		Node prev = null;
		Node temp = null;
		int i = 0;
		
		while(i < k && curr != null)  {
			temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
			i++;
		}
		
		if(curr != null)
			head.next = groupNodes(curr , k);
		
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
		
		Reversing_into_groups_of_k_using_iteration list = new Reversing_into_groups_of_k_using_iteration();
		
		head1 = list.add_front(9 , head1);
		head1 = list.add_front(8 , head1);
		head1 = list.add_front(7 , head1);
		head1 = list.add_front(6 , head1);
		head1 = list.add_front(5 , head1);
		head1 = list.add_front(4 , head1);
		head1 = list.add_front(3 , head1);
		head1 = list.add_front(2 , head1);
		head1 = list.add_front(1 , head1);
		
		list.print(head1);	
		
		head2 = list.groupNodes(head1 , 5);
	
		System.out.print("\nThe Linked List after grouping is : \n " );
		list.print(head2);	
	}
		
}
	
