/*
	Implementation of a special stack using two arrays with functions.
	
	push(), pop(), isEmpty(), peek(), getMin() and print()
	Author : Aman Kimothi
	E-mail : kimothiaman@gmail.com
	Github : https://github.com/Aman-Kimothi/DSA
*/

class SpecialStackGetMinimum {
	
	int top , size;
	int[] stack , minimum;
	
	public SpecialStackGetMinimum(int size) {
		top = -1;
		this.size = size;
		stack = new int[size];
		minimum = new int[size];
	}
	
	boolean push(int data) {
		
		if(top >= size - 1) {				// Overflow condition
			System.out.println("Stack Overflow");
			return false;
		}
		
		if(top == -1 || minimum[top] > data)	// adding the min to the minimum array
			minimum[top+1] = data;
		else	
			minimum[top+1] = minimum[top];
		
		stack[++top] = data;				// Pushing the data
		return true;
	}
	
	int pop() {
	
		if(top < 0) {						// Underflow condition
			System.out.println("Stack Underflow");
			return Integer.MIN_VALUE;
		}
		int dummy =minimum[top];			// this step is not necessary
		return stack[top--]; 				// Popping the data
	}
	
	int getMin() {
		if(top < 0)
			return Integer.MIN_VALUE;
		return minimum[top];	
	}
	
	boolean isEmpty() {
		if(top == -1)
			return true;
		return false;	
	}
	
	int peek() {					// Returning the top element
		if(top < 0)
			return Integer.MIN_VALUE;
		return stack[top];
	}
	
	void print() {
		
		for(int i = top; i >= 0; i--)
			System.out.print(stack[i] + "\t");
		System.out.println();	
	}
	
	public static void main(String args[]) {
		
		int pop;
		SpecialStackGetMinimum st = new SpecialStackGetMinimum(10);
		
		st.push(1);
		st.push(2);
		st.push(3);
		st.push(4);
		
		System.out.print("Stack elements are  :  " );	
		st.print();
		
		if((pop = st.getMin()) != Integer.MIN_VALUE)
			System.out.println("Minimum value : " + pop);
		
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
		
		if((pop = st.getMin()) != Integer.MIN_VALUE)
			System.out.println("Minimum value : " + pop);
	}
}