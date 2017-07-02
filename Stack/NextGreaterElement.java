/*
	Print the Next Greater Element (NGE) for every element
	The Next greater Element for an element x is the first greater element on the right side of x in array.
	Elements for which no greater element exist, consider next greater element as -1.
	
	Array : { 4, 5, 2, 25 }
	
	Element         NGE
	   4      -->   5
	   5      -->   25
	   2      -->   25
	   25     -->   -1
	
	Author : Aman Kimothi
	E-mail : kimothiaman@gmail.com
	Github : https://github.com/Aman-Kimothi/DSA
*/

import java.util.Stack;

class NextGreaterElement {
	
	void printNextGreaterElements(int arr[])  {
		Stack st = new Stack();
		
		st.push(arr[0]);		// Push the first element to the stack
		
		for(int i = 1 ; i < arr.length ; i++) {		
			int n = arr[i];
			
			while(!st.empty() && n > (int)st.peek())			// Print all the elements of the stack which are smaller than n
				System.out.println( st.pop() + "\t\t --->  " + n);
			st.push(n);											// Push the element n
		}
		
		while(!st.empty())				// Print all the remaining elements of stack which doesn't have any NGE
			System.out.println(st.pop() + "\t\t --->  -1");
	}
	
	public static void main(String args[]) {
			
		 NextGreaterElement obj = new NextGreaterElement();	
		
		 int arr[] = { 4, 5, 2, 25, 33, 11 ,9 };
		 
		 System.out.println("Element \t   NGE ");
		 obj.printNextGreaterElements(arr);
		
	}
}