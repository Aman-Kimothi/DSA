/*
	Author : Aman Kimothi
	E-mail : kimothiaman@gmail.com
	Github : https://github.com/Aman-Kimothi/DSA
*/

import java.util.Stack;

class BTNode {
	int data;
	BTNode left;
	BTNode right;
	
	public BTNode(int d) {
		data = d;
		left = null;
		right = null;
	}
}

class Inorder_Traversal_using_Stack  {
	
	void inorder_traversal(BTNode root)  {
		
		if(root == null) {
			System.out.println("The tree is empty");
			return ;
		}
		
		BTNode curr = root;
		Stack<BTNode> stack = new Stack<BTNode>();
		
		while(curr != null) {		// to traverse to the left most leaf
			stack.push(curr);
			curr = curr.left;
		}
		
		while(!stack.isEmpty()) {
			
			BTNode temp = stack.pop();
			System.out.print(temp.data + "\t");
			
			if(temp.right != null) {
				
				temp = temp.right;			// accessing the sub tree on the right side
				
				while(temp != null) {		// Pushing the nodes on the left of temp
					stack.push(temp);
					temp = temp.left;
				}
			}
		}
	}
	
	public static void main(String args[]) {
		
		Inorder_Traversal_using_Stack tree = new Inorder_Traversal_using_Stack();
		
		BTNode root = new BTNode(1); 
		
		root.left = new BTNode(2);
		root.right = new BTNode(3);
		root.left.left = new BTNode(4);
		root.left.right = new BTNode(5);
		root.right.left = new BTNode(6);
		root.right.right = new BTNode(7);
		root.left.left.left = new BTNode(8);
		root.left.left.right = new BTNode(9);
	
		System.out.println("The inorder traversal of the tree is : ");
		tree.inorder_traversal(root);
		
	}
}
