/*
	Reverse a stack using recursion.
	
	Original Stack 		:		1  2  3  4  5  6
	Reversed Stack	 	:		6  5  4  3  2  1 
	
	Author : Aman Kimothi
	E-mail : kimothiaman@gmail.com
	Github : https://github.com/Aman-Kimothi/DSA
*/

import java.util.Stack;

class ReverseStack {
	
	Stack<Integer> st;
	
	public ReverseStack() {
		st = new Stack<Integer>();
	}
	
	void push(int data) {
		st.push(data);
	}
	
	/*	reverse() recursively pops and adds every element to the
		end of the stack. All the popped elements are stored in 
		the function call stack. These elements are then pushed
		onto the stack recursively using insertAtEnd().  */
	
	void reverse()  {					
		
		if(st.isEmpty())			// when stack becomes empty
			return ;
		
		int temp = (int)st.pop();		// popping the top value
		reverse();				// recursively reversing the whole stack
		insertAtEnd(temp);			// inserting the popped element at the end
	}
	
	/* This function recursively pops all the elements of the stack
	   until the stack becomes empty. All these popped values are 
	   stored in the stack of the function call until the stack becomes
	   empty. The data is then pushed onto the stack. All the rest 
	   elements which were popped earlier are pushed to the stack
	   in a recusive manner. Thus, we get a stack where all the 
	   data is added at the end of the present stack.	*/
	
	void insertAtEnd(int data) {
		if(st.isEmpty()) {			// if the stack is empty, push the data
			st.push(data);
			return ;
		}
			
		int temp = st.pop();			// popping the top value
		insertAtEnd(data);			// recursively popping all the elements of the stack
		st.push(temp);				// pushing the popped values stored in the function call stack
	}
	
	public static void main(String args[]) {
			
		 ReverseStack obj = new ReverseStack();	
		
		 obj.push(1);
		 obj.push(2);
		 obj.push(3);
		 obj.push(4);
		 obj.push(5);
		 obj.push(6);
		 
		 System.out.println("Original stack : " + obj.st);
		 
		 obj.reverse();
		 
		 System.out.println("Reversed stack : " + obj.st);
	}
}
