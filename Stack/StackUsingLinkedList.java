/*
	Implementation of a stack using a linked list with functions.
	
	push(), pop(), isEmpty(), peek() and print()

	Author : Aman Kimothi
	E-mail : kimothiaman@gmail.com
	Github : https://github.com/Aman-Kimothi/DSA
*/


class StackUsingLinkedList {
	
	Node head;
	
	static class Node {
		int data;
		Node next;
		public Node(int d) {
			data = d;
			next = null;
		}
	}
	
	public StackUsingLinkedList() {
		head = null;
	}
	
	void push(int data) {
		Node new_node = new Node(data);
		new_node.next = head;				// Linking the head to the next of the new node
		head = new_node;					// Making the new node as the head
	}
	
	int pop() {
		if(head == null) {					// Underflow condition
			System.out.println("Stack Underflow");
			return Integer.MIN_VALUE;
		}
		Node temp = head;					// Storing the head in a node
		head = head.next;					// Making the next node as the new node i.e removing the head node
		return temp.data;
	}
	
	boolean isEmpty() {
		if(head == null)
			return true;
		return false;	
	}
	
	int peek() {					// Returning the head element
		if(head == null)
			return Integer.MIN_VALUE;
		return head.data;
	}
	
	void print() {					// Printing all the elements stored in the stack
		
		if(head == null) {
			System.out.println("Stack is empty");
			return ;
		}
		
		Node temp = head;
		System.out.print("Stack elements are : ");
		
		while(temp != null) {
			System.out.print(temp.data + "\t");
			temp = temp.next;
		}
		System.out.println();	
	}
	
	public static void main(String args[]) {
		
		StackUsingLinkedList st = new StackUsingLinkedList();
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
		if(st.isEmpty())
			System.out.println("The stack is empty");
		else	
			System.out.println("The stack is not empty");
		
	
		st.push(8);
		if((pop = st.peek()) != Integer.MIN_VALUE)
			System.out.println("Peeked value : " + pop);
		
		st.push(9);
		st.print();
	}
}