/*			***** STOCK SPAN PROBLEM *****
	
	The span Si of the stock’s price on a given day i is defined
	as the maximum number of consecutive days just before the 
	given day, for which the price of the stock on the current
	day is less than or equal to its price on the given day.
	
	Array		: 	{100, 80, 60, 70, 60, 75, 85}
	Stock Span	:   {1, 1, 1, 2, 1, 4, 6}
	
	Author : Aman Kimothi
	E-mail : kimothiaman@gmail.com
	Github : https://github.com/Aman-Kimothi/DSA
*/

import java.util.Stack;
import java.util.Arrays;

class StockSpanProblem {
	
	int[] stockSpan(int arr[])  {
		Stack<Integer> st = new Stack<Integer>();
		st.push(0);			// Push the first index to the stack
		
		int res[] = new int[arr.length];		// array to store the stock span
		res[0] = 1;
		
		for(int i = 1 ; i < arr.length ; i++) {		
			
			/*  to count the number of days when the stack elements
				are smaller than the current element of array 	*/
																
			while(!st.empty() && arr[i] >= arr[st.peek()])
				st.pop();
			
			/*  if it is empty, span is the position of the element from left
				if it is not empty, it is difference between the position 
				of the top element and the current element.		*/
			res[i] = st.empty() ? (i + 1) : (i - st.peek());		
			
			st.push(i);				// Push the element index into the stack
		}
		return res;	
	}
	
	public static void main(String args[]) {
			
		 StockSpanProblem obj = new StockSpanProblem();	
		
		 int arr[] = {10, 4, 5, 90, 120, 80};
		 
		 int res[] = obj.stockSpan(arr);
		 
		 System.out.println("Array\t\t : " + Arrays.toString(arr));
		 System.out.println("Stock Span\t : " +Arrays.toString(res));
		
	}
}