/*
	Implementation of a queue using an array with functions.
	
	enqueue(), dequeue(), isEmpty(), peek() and print()
	
	Author : Aman Kimothi
	E-mail : kimothiaman@gmail.com
	Github : https://github.com/Aman-Kimothi/DSA
*/


class QueueUsingArray {
	
	int front, rear,  size;
	int[] arr;
	
	public QueueUsingArray(int size) {
		front = -1;
		rear = -1;
		this.size = size;
		arr = new int[size];
	}
	
	boolean enqueue(int data) {
		
		if(rear >= size - 1) {			// Overflow condition
			System.out.println("Stack Overflow");
			return false;
		}
		arr[++rear] = data;				// enqueuing the data
		return true;
	}
	
	int dequeue() {
	
		if(front == rear) {					// Underflow condition
			System.out.println("Stack Underflow");
			return Integer.MIN_VALUE;
		}
		return arr[++front]; 				// dequeuing the data
	}
	
	boolean isEmpty() {
		if(rear < 0)
			return true;
		return false;	
	}
	
	int front() {					// Returning the front element
		if(rear < 0)
			return Integer.MIN_VALUE;
		return arr[front + 1];
	}
	
	int rear(){						// Returning the rear element
		if(rear < 0)	
			return Integer.MIN_VALUE;
		return arr[rear];
	}
	
	void print() {
		
		for(int i = front + 1; i <= rear; i++)
			System.out.print(arr[i] + "\t");
		System.out.println();	
	}
	
	public static void main(String args[]) {
		
		QueueUsingArray st = new QueueUsingArray(20);
		
		st.enqueue(1);
		st.enqueue(2);
		st.enqueue(3);
		st.enqueue(4);
		st.enqueue(5);
		st.enqueue(6);
		
		System.out.print("Queue elements are  :  " );	
		st.print();
		
		int dequeue;
		
		if((dequeue = st.dequeue()) != Integer.MIN_VALUE)
			System.out.println("dequeued value : " + dequeue);
			
		if((dequeue = st.dequeue()) != Integer.MIN_VALUE)
			System.out.println("dequeued value : " + dequeue);
		
		if((dequeue = st.dequeue()) != Integer.MIN_VALUE)
			System.out.println("dequeued value : " + dequeue);
			
		if((dequeue = st.dequeue()) != Integer.MIN_VALUE)
			System.out.println("dequeued value : " + dequeue);	

		st.enqueue(7);
		st.enqueue(8);
		st.enqueue(9);
		
		System.out.print("Queue elements are  :  " );	
		st.print();
		
		System.out.println("Front element is  :  " + st.front());	
		
		System.out.println("Rear element is  :  " + st.rear());	
		
	}
}