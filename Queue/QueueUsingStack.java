/*
	Implementation of a queue using a single stack with functions.
	
	enQueue(1)
	enQueue(2)
	enQueue(3)
	enQueue(4)
	
	Queue using stack  ->  1 2 3 4
	
	enQueue(), deQueue(), isEmpty(), peek() and print()
	Author : Aman Kimothi
	E-mail : kimothiaman@gmail.com
	Github : https://github.com/Aman-Kimothi/DSA
*/
import java.util.Stack;
import java.util.Iterator;
class QueueUsingStack {
	
	Stack<Integer> stack;
	
	public QueueUsingStack() {
		stack = new Stack<Integer>();		
	}
	
	/*	enQueue() recursively deQueues the elements till the stack
		becomes empty. All the deQueueped elements are stored
		in the function call stack. The data is added in 
		the empty stack followed by enQueueing of all the 
		deQueueped elements stored in the function call stack. 	*/
	
	boolean enQueue(int data) {
		
		if(stack.isEmpty()) {
			stack.push(data);
			return true;
		}
			
		int temp = stack.pop();
		enQueue(data);
		stack.push(temp);
		return true;
	}
	
	int deQueue() {
		if(stack.peek() == null)
			return Integer.MIN_VALUE;
		return stack.pop();	
	}
	
	boolean isEmpty() {
		if(stack.peek() == null)
			return true;
		return false;	
	}
	
	int peek() {								// Returning the top element
		if(stack.peek() == null)
			return Integer.MIN_VALUE;
		return stack.peek();
	}
	
	void print() {
		
		Iterator itr=stack.iterator();  		// using iterator to access the queue elements
		
		while(itr.hasNext()){  
			System.out.print(itr.next() + "\t" );  
		}  
		System.out.println();	
	}
	
	public static void main(String args[]) {
		
		int pop;
		QueueUsingStack st = new QueueUsingStack();
		
		st.enQueue(1);
		st.enQueue(2);
		st.enQueue(3);
		st.enQueue(4);
		
		System.out.print("Queue elements are  :  " );	
		st.print();
		
		if((pop = st.deQueue()) != Integer.MIN_VALUE)
			System.out.println("Dequeued value : " + pop);
			
		if((pop = st.deQueue()) != Integer.MIN_VALUE)
			System.out.println("Dequeued value : " + pop);
		
		if((pop = st.deQueue()) != Integer.MIN_VALUE)
			System.out.println("Dequeued value : " + pop);
			
		if((pop = st.deQueue()) != Integer.MIN_VALUE)
			System.out.println("Dequeued value : " + pop);
		
		st.enQueue(5);
		st.enQueue(6);
		st.enQueue(7);
		st.enQueue(8);
		st.enQueue(9);
		
		System.out.print("Queue elements are  :  " );	
		st.print();
		
		if((pop = st.deQueue()) != Integer.MIN_VALUE)
			System.out.println("Dequeued value : " + pop);
			
		if((pop = st.deQueue()) != Integer.MIN_VALUE)
			System.out.println("Dequeued value : " + pop);
		
		if((pop = st.deQueue()) != Integer.MIN_VALUE)
			System.out.println("Dequeued value : " + pop);
			
		if((pop = st.deQueue()) != Integer.MIN_VALUE)
			System.out.println("Dequeued value : " + pop);
			
		if((pop = st.deQueue()) != Integer.MIN_VALUE)
			System.out.println("Dequeued value : " + pop);
			
	}
}