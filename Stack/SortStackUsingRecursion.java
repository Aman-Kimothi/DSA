/*
	Sort a stack using recursion.
	
	Original Stack 		:		{ -5, 18, 4, 1, 3, 5, 30, 14, -3, 6, 2, -5 }
	Sorted Stack	 	:		{ -5, -5, -3, 1, 2, 3, 4, 5, 6, 14, 18, 30 }
	
	Author : Aman Kimothi
	E-mail : kimothiaman@gmail.com
	Github : https://github.com/Aman-Kimothi/DSA
*/

import java.util.Stack;
class SortStackUsingRecursion {
	
	Stack<Integer> st;
	
	public SortStackUsingRecursion() {
		st = new Stack<Integer>();
	}
	
	void push(int data) {
		st.push(data);
	}
	
	/*	sort() recursively pops and adds every element to stack 
		in a sorted manner. All the popped elements are stored in 
		the function call stack. These elements are then pushed
		onto the stack recursively using sortedInsert().  */
	
	void sort()  {					
		
		if(st.isEmpty())			// when stack becomes empty
			return ;
		
		int temp = (int)st.pop();		// popping the top value
		sort();					// recursively sorting the whole stack
		sortedInsert(temp);			// inserting the popped element in a sorted manner
	}
	
	/* This function recursively pops all the elements of the stack
	   until the stack becomes empty or a position is found for the
	   data to be inserted . All the popped values are stored in 
	   the stack of the function call. The data is then pushed 
	   onto the stack. All the rest elements which were popped
	   earlier are pushed to the stack in a recusive manner. 
	   Thus, we get a stack where all the data is added in the
	   stack in a sorted manner.	*/
	
	void sortedInsert(int data) {
		if(st.isEmpty() || data > st.peek()) {		// if the stack is empty, push the data
			st.push(data);				// if the data is greater than the top element, push the data
			return ;
		}
			
		int temp = st.pop();			// popping the top value
		sortedInsert(data);			// recursively popping all the elements of the stack
		st.push(temp);				// pushing the popped values stored in the function call stack
	}
	
	public static void main(String args[]) {
			
		 SortStackUsingRecursion obj = new SortStackUsingRecursion();	
		
		 obj.push(-5);
		 obj.push(18);
		 obj.push(4);
		 obj.push(1);
		 obj.push(3);
		 obj.push(5);
		 obj.push(30);
		 obj.push(14);
		 obj.push(-3);
		 obj.push(6);
		 obj.push(2);
		 obj.push(-5);
		  
		 System.out.println("Original stack : " + obj.st);
		 
		 obj.sort();
		 
		 System.out.println("Reversed stack : "  + obj.st);
		 
	}
}
