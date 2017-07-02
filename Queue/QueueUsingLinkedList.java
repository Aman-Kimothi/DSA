/*
	Implementation of a queue using a linked list with functions.
	
	enQueue(), deQueue() and print()
	
	Author : Aman Kimothi
	E-mail : kimothiaman@gmail.com
	Github : https://github.com/Aman-Kimothi/DSA
*/

class QueueUsingLinkedList {
	
	Node front , rear;
	
	static class Node {
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
			next = null;
		}
	}
	
	public QueueUsingLinkedList() {
		front = null;
		rear = null;
	}
	
	void enQueue(int data) {
		Node new_node = new Node(data);
		
		if(rear == null) {					// when the first value is added
			rear = new_node;
			front = new_node;
		}
	
		rear.next = new_node;				// Linking the new node to the rear
		rear = new_node;					// Making the new node as the rear
	}
	
	int deQueue() {
	
		if(front == null) {								// Underflow condition
			System.out.println("Queue underflow");
			return Integer.MIN_VALUE;
		}
		int res = front.data;				// storing the deQueue data
		front = front.next;					// shifting the front to the next node
		
		if(front == null)					// Make rear as null if front becomes null
			rear = null;
		
		return res;
	}
	
	void print() {

		if(front == null) {
			System.out.println("Queue is empty");
			return;
		}

		Node temp = front;
		while(temp != rear) {
			System.out.print(temp.data + "\t");
			temp = temp.next;
		}
		System.out.println(temp.data);
	}
	
	public static void main(String args[]) {
		
		QueueUsingLinkedList queue = new QueueUsingLinkedList();
		
		queue.enQueue(1);
		queue.enQueue(2);
		queue.enQueue(3);
		queue.enQueue(4);
		queue.enQueue(5);
		queue.enQueue(6);
		
		System.out.print("Queue is  :  ");	
		queue.print();
		
		int res;
		
		if((res = queue.deQueue()) != Integer.MIN_VALUE)
			System.out.println("Dequeued value : " + res);
			
		if((res = queue.deQueue()) != Integer.MIN_VALUE)
			System.out.println("Dequeued value : " + res);
		
		if((res = queue.deQueue()) != Integer.MIN_VALUE)
			System.out.println("Dequeued value : " + res);
		
		if((res = queue.deQueue()) != Integer.MIN_VALUE)
			System.out.println("Dequeued value : " + res);
			
		if((res = queue.deQueue()) != Integer.MIN_VALUE)
			System.out.println("Dequeued value : " + res);
		
		if((res = queue.deQueue()) != Integer.MIN_VALUE)
			System.out.println("Dequeued value : " + res);
		
		if((res = queue.deQueue()) != Integer.MIN_VALUE)
			System.out.println("Dequeued value : " + res);
			
		queue.enQueue(7);
		queue.enQueue(8);
		queue.enQueue(9);
		
		System.out.print("Queue is  :  ");	
		queue.print();
	}
}