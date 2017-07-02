/*
	Implementation of a special stack using a single queue with functions.
	
	push(1)
	push(2)
	push(3)
	push(4)
	
	Stack using queue  ->  4 3 2 1
	
	push(), pop(), isEmpty(), peek() and print()
	Author : Aman Kimothi
	E-mail : kimothiaman@gmail.com
	Github : https://github.com/Aman-Kimothi/DSA
*/
import java.util.Queue;
import java.util.LinkedList;
import java.util.Iterator;
// import java.util.concurrent.LinkedBlockingQueue;

class StackUsingQueue {
	
	Queue<Integer> queue;
	
	public StackUsingQueue() {
		queue = new LinkedList<Integer>();		// LinkedBlockingQueue can also be used as it's based on FIFO
	}
	
	/*	push() enqueues the data on to the queue and then shifts
		all the elements on the front to the rear until the front
		reaches the newly added data	*/
	
	boolean push(int data) {
		
		int size = queue.size();		// finding the size of the queue before enqueue
		queue.add(data);				// enqueue the data
		
		while(0 < size--)				// shifting the data on the front to the rear
			queue.add(queue.poll());	// until front reaches the newly added data
			
		return true;
	}
	
	int pop() {
		if(queue.peek() == null)
			return Integer.MIN_VALUE;
		return queue.poll();	
	}
	
	boolean isEmpty() {
		if(queue.peek() == null)
			return true;
		return false;	
	}
	
	int peek() {					// Returning the top element
		if(queue.peek() == null)
			return Integer.MIN_VALUE;
		return queue.peek();
	}
	
	void print() {
		
		Iterator itr=queue.iterator();  		// using iterator to access the queue elements
		
		while(itr.hasNext()){  
			System.out.print(itr.next() + "\t" );  
		}  
		System.out.println();	
	}
	
	public static void main(String args[]) {
		
		int pop;
		StackUsingQueue st = new StackUsingQueue();
		
		st.push(1);
		st.push(2);
		st.push(3);
		st.push(4);
		
		System.out.print("Stack elements are  :  " );	
		st.print();
		
		if((pop = st.pop()) != Integer.MIN_VALUE)
			System.out.println("Popped value : " + pop);
			
		if((pop = st.pop()) != Integer.MIN_VALUE)
			System.out.println("Popped value : " + pop);
		
		if((pop = st.pop()) != Integer.MIN_VALUE)
			System.out.println("Popped value : " + pop);
			
		if((pop = st.pop()) != Integer.MIN_VALUE)
			System.out.println("Popped value : " + pop);
		
		st.push(5);
		st.push(6);
		st.push(7);
		st.push(8);
		st.push(9);
		
		System.out.print("Stack elements are  :  " );	
		st.print();
		
		if((pop = st.pop()) != Integer.MIN_VALUE)
			System.out.println("Popped value : " + pop);
			
		if((pop = st.pop()) != Integer.MIN_VALUE)
			System.out.println("Popped value : " + pop);
		
		if((pop = st.pop()) != Integer.MIN_VALUE)
			System.out.println("Popped value : " + pop);
			
		if((pop = st.pop()) != Integer.MIN_VALUE)
			System.out.println("Popped value : " + pop);
			
		if((pop = st.pop()) != Integer.MIN_VALUE)
			System.out.println("Popped value : " + pop);
			
	}
}