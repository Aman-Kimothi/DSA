/*
		There are n petrol pumps on a circle. Calculate the
		first point from where a truck will be able to complete
		the circle given two sets of data.
		
		1. The amount of petrol that every petrol pump has.
		2. Distance from that petrol pump to the next petrol pump.
		
		Input : {4, 6}, {6, 5}, {7, 3} and {4, 5}.
				 |          |
				 v			v   
			   petrol	 distance
			   
		Output : Starting point : 2	   
		
		Author : Aman Kimothi
		E-mail : kimothiaman@gmail.com
		Github : https://github.com/Aman-Kimothi/DSA
*/


class PetrolPumpTourCircularQueue {
	
	static class Node {
		
		int position;
		int petrol;
		int distance;
		Node next;
	
		public Node(int pos, int a, int b) {
			position = pos;
			petrol = a ;
			distance = b;
			next = null;
		}
	}
	
	int printTourStart(Node head) {
		Node start = head;
		do {
			Node temp = start;			// Storing the starting node
			int petrol_left = 0;
		
			// if petrol is left and node is not the starting node
			do{	
				petrol_left += temp.petrol - temp.distance;
				temp = temp.next;
			}
			while(petrol_left >= 0 && temp != start);
		
			if(petrol_left >= 0 )
				return start.position;
			
			start = start.next;
			
		} while(start != head);
		
		return -1;
	}
	
	public static void main(String args[]) {
		
		PetrolPumpTourCircularQueue obj = new PetrolPumpTourCircularQueue();
		
		Node head = new Node(1, 4, 6);
		head.next = new Node(2, 6, 5);
		head.next.next = new Node(3, 7, 3);
		head.next.next.next = new Node(4, 4, 5);
		head.next.next.next.next = head;
		
		int pos = obj.printTourStart(head);
		
		System.out.println("Starting position : "+ pos );
		
	}
}