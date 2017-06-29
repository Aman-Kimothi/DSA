/*
	Implementation of two stacks using a single array.
	Following functions are implemented :

	push1(int x) –> pushes x to first stack
	push2(int x) –> pushes x to second stack
	
	pop1() –> pops an element from first stack and return the popped element
	pop2() –> pops an element from second stack and return the popped element
	
	Author : Aman Kimothi
	E-mail : kimothiaman@gmail.com
	Github : https://github.com/Aman-Kimothi/DSA
*/

class TwoStacksUsingSingleArray {
	
	int top1, top2 , size;
	int[] arr;
	
	public TwoStacksUsingSingleArray(int size) {
		top1 = -1;
		top2 = size;
		this.size = size;
		arr = new int[size];
	}
	
	boolean push1(int data) {
		
		if(top1 >= top2 - 1) {				// Overflow condition
			System.out.println("Stack Overflow");
			return false;
		}
		arr[++top1] = data;					// Pushing the data
		return true;
	}
	
	boolean push2(int data) {
		
		if(top1 >= top2 - 1) {				// Overflow condition
			System.out.println("Stack Overflow");
			return false;
		}
		arr[--top2] = data;					// Pushing the data
		return true;
	}
	
	int pop1() {
	
		if(top1 < 0) {						// Underflow condition
			System.out.println("Stack Underflow");
			return Integer.MIN_VALUE;
		}
		return arr[top1--]; 					// Popping the data
	}
	
	int pop2() {
	
		if(top2 >= size) {						// Underflow condition
			System.out.println("Stack Underflow");
			return Integer.MIN_VALUE;
		}
		return arr[top2++]; 					// Popping the data
	}
	
	void print1() {
		
		for(int i = top1; i >= 0; i--)
			System.out.print(arr[i] + "\t");
		
		System.out.println();	
	}
	
	void print2() {
		
		for(int i = top2; i < size; i++)
			System.out.print(arr[i] + "\t");
		
		System.out.println();	
	}
	
	public static void main(String args[]) {
		
		TwoStacksUsingSingleArray st = new TwoStacksUsingSingleArray(10);
		
		st.push1(1);
		st.push1(2);
		st.push1(3);
		
		st.push2(4);
		st.push2(5);
		st.push2(6);
		st.push2(7);
		st.push2(8);
		st.push2(9);
		
		st.push1(7);
		st.push1(8);
		st.push1(9);
		
		
		System.out.print("Stack 1  :  ");	
		st.print1();
		System.out.print("Stack 2  :  ");	
		st.print2();
		
		int pop;
		
		if((pop = st.pop2()) != Integer.MIN_VALUE)
			System.out.println("Popped value from Stack 2 : " + pop);
			
		if((pop = st.pop2()) != Integer.MIN_VALUE)
			System.out.println("Popped value from Stack 2 : " + pop);
		
		if((pop = st.pop2()) != Integer.MIN_VALUE)
			System.out.println("Popped value from Stack 2 : " + pop);
			
		if((pop = st.pop2()) != Integer.MIN_VALUE)
			System.out.println("Popped value from Stack 2 : " + pop);	

		if((pop = st.pop1()) != Integer.MIN_VALUE)
			System.out.println("Popped value from Stack 1 : " + pop);
			
		if((pop = st.pop1()) != Integer.MIN_VALUE)
			System.out.println("Popped value from Stack 1 : " + pop);	

		System.out.print("Stack 1  :  ");	
		st.print1();
		System.out.print("Stack 2  :  ");	
		st.print2();
	}
}