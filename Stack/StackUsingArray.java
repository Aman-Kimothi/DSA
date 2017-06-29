/*
	Implementation of a stack using an array with functions.
	
	push(), pop(), isEmpty(), peek() and print()

	Author : Aman Kimothi
	E-mail : kimothiaman@gmail.com
	Github : https://github.com/Aman-Kimothi/DSA
*/


class StackUsingArray {
	
	int top , size;
	int[] arr;
	
	public StackUsingArray(int size) {
		top = -1;
		this.size = size;
		arr = new int[size];
	}
	
	boolean push(int data) {
		
		if(top >= size - 1) {				// Overflow condition
			System.out.println("Stack Overflow");
			return false;
		}
		arr[++top] = data;				// Pushing the data
		return true;
	}
	
	int pop() {
	
		if(top < 0) {					// Underflow condition
			System.out.println("Stack Underflow");
			return Integer.MIN_VALUE;
		}
		return arr[top--]; 				// Popping the data
	}
	
	boolean isEmpty() {
		if(top == -1)
			return true;
		return false;	
	}
	
	int peek() {					// Returning the top element
		if(top < 0)
			return Integer.MIN_VALUE;
		return arr[top];
	}
	
	void print() {
		
		for(int i = top; i >= 0; i--)
			System.out.print(arr[i] + "\t");
		System.out.println();	
	}
	
	public static void main(String args[]) {
		
		StackUsingArray st = new StackUsingArray(10);
		st.push(1);
		st.push(2);
		st.push(3);
		st.push(4);
		st.push(5);
		st.push(6);
		
		int pop;
		
		if((pop = st.pop()) != Integer.MIN_VALUE)
			System.out.println("Popped value : " + pop);
			
		if((pop = st.pop()) != Integer.MIN_VALUE)
			System.out.println("Popped value : " + pop);
		
		if((pop = st.pop()) != Integer.MIN_VALUE)
			System.out.println("Popped value : " + pop);
			
		if((pop = st.pop()) != Integer.MIN_VALUE)
			System.out.println("Popped value : " + pop);	

		st.push(7);
		st.push(8);
		st.push(9);
		
		System.out.print("Stack elements are  :  " );	
		st.print();
	}
}
