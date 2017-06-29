/*
	Conversion of infix into postfix using stack and a class 'Operators' for prioritising the precedence of the operators.
	
	Infix Expression 	: 	a+b*(c^d-e)^(f+g*h)-i 
	Postfix Expression 	: 	abcd^e-*fgh*+^+i-
	
	Author : Aman Kimothi
	E-mail : kimothiaman@gmail.com
	Github : https://github.com/Aman-Kimothi/DSA
*/


import java.util.Stack;

class Operators {
		
		/* This is a class where you can add as many operators as you want with their priority(precedence) number.
		 This is very efficient as you can add as many operators as you want.  
		 
		 2D-Array is used here for checking the precedence of the operator. 
		 HashMap can also be used instead of array which is easier to implement as hashmap.get(key) is mostly O(1).	*/
		
		char arr[][] ;		// array which stores the operators with their priority (precedence)
		
		public Operators() {
			arr = new char[][] {   {'+' , '-' ,'*' ,'/' ,'^'} ,
								   {'1' ,'1' ,'2' ,'2' ,'3' }
							   };
		}
		
		/* This function is to check whether the precedence of the stack character is greater than or equal 
			to the precendence of the ch character	*/
			
		boolean getPriority(char ch , char stack) {
			
			int cur = 0 , stack_ = 0;			// to store the precedence number of the parameter chars
			
			for(int i = 0; i < arr[0].length; i++) {
				if(arr[0][i] == ch)
					cur = arr[1][i];
				if(arr[0][i] == stack)
					stack_ = arr[1][i];	
			}
			
			if(cur <= stack_)					// if the precedence is greater than or equal to.
				return true;
			else
				return false;
		}
}

class InfixToPostfixUsingStack {
	
	String infixToPostfix(String st) {
	
		Stack<Character> stack = new Stack<Character>();
		String result = "";
		int len = st.length();
		Operators priority = new Operators();
		
		for(int i = 0; i < len; i++) {
			char ch = st.charAt(i);
			
			if((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'))		// if it is an operand
				result += ch;
			else {
				
				if(ch == '(') {				// push the '(' into the stack
					stack.push(ch);
					continue;
				}
				else if(ch == ')') {		// pop all the elements until you find '(' in the stack
				
 					while (!stack.isEmpty() && stack.peek() != '(')
                    	result += stack.pop();
						
					if (!stack.isEmpty() && stack.peek() != '(')		// invalid expression 
						return "Invalid Expression"; 		
					
                    stack.pop();	
				}
				else {			// when there is a operator
						
					while(true)  {
						
						if(stack.isEmpty() || stack.peek() == '(')
							break;
				
						if(priority.getPriority(ch , stack.peek()))		// getting the precedence of the operators 
							result += stack.pop();
						else
							break;
					}
					stack.push(ch);		// pushing the current element in the stack
				}
			}	
		}
		while(!stack.isEmpty()) 		// popping all the operators left in the stack
			result += stack.pop();		
		
		return result;
	}
	
	public static void main(String args[]) {
		
		InfixToPostfixUsingStack obj = new InfixToPostfixUsingStack();
		
		String infix = "(A+B)*C-(D-E)*(F+G)";
		
		String postfix = obj.infixToPostfix(infix);
		
		System.out.println("Infix Exp : " +infix);
		System.out.println("Postfix Exp : " +postfix);
		
		infix = "a+b*(c^d-e)^(f+g*h)-i";
		
		postfix = obj.infixToPostfix(infix);
		
		System.out.println("\nInfix Exp : " +infix);
		System.out.println("Postfix Exp : " +postfix);
	}
}