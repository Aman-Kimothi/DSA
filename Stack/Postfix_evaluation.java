/*
	Postfix evaluation using stack. 
	It works for multiple digit numbers and basic operations like + - * / & ^
	
	Postfix Expresion : 10 15 + 20 5 + * 
	Postfix Evaluation : 625
	
	Postfix Expresion : 7 5 3 2 ^ * 9 2 2 ^ - / + 6 4 * + 
	Postfix Evaluation : 40
	
	Author : Aman Kimothi
	E-mail : kimothiaman@gmail.com
	Github : https://github.com/Aman-Kimothi/DSA
*/

import java.util.Stack;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Postfix_evaluation {
	
	String postfix_evaluation(String st) {
	
		Stack<String> stack = new Stack<String>();
		StringTokenizer str = new StringTokenizer(st);
		
		/* List to store all the basic operations used */
		ArrayList<String> operators= new ArrayList<>(Arrays.asList("+" ,"-" ,"*" ,"/" ,"^"));
		
		while(str.hasMoreTokens()) {		
			
			String data = str.nextToken().trim();
			
			if(!operators.contains(data))		// when data is a number 
				stack.push(data.trim());
			else {
				
				/*Getting the top 2 elements from the stack*/
				int val1 = Integer.parseInt(stack.pop());		
				int val2 = Integer.parseInt(stack.pop());
				
				/*Do operation on the above two values*/
				int res = operation(val2 , val1, data.charAt(0));
				
				stack.push(Integer.toString(res)); 		// storing the result back into the stack
			}	
		}
		return stack.pop();
	}
	
	int operation(int a , int b, char operator)  {
		
		int res = 0;
		
		switch(operator) {
			case '+' :
				res = a + b;
				break;
			case '-' :
				res = a - b;
				break;
			case '*' :
				res = a * b;
				break;
			case '/' :
				res = a / b;
				break;
			case '^' :
				res = (int)Math.pow(a,b);
				break;
			default :	
		}
		return res;
	}
	
	public static void main(String args[]) {
		
		Postfix_evaluation obj = new Postfix_evaluation();
		
		String postfix = "10 15 + 20 5 + *";     // ( a + b) * ( c + d) : Infix
		
		String evaluation = obj.postfix_evaluation(postfix);
		
		System.out.println("Postfix Expresion : " +postfix);
		System.out.println("Postfix Evaluation : " +evaluation);
		
		postfix = "7 5 3 2 ^ * 9 2 2 ^ - / + 6 4 * +";
		
		evaluation = obj.postfix_evaluation(postfix);
		
		System.out.println("\nPostfix Expresion : " +postfix);
		System.out.println("Postfix Evaluation : " +evaluation);
		
	}
}