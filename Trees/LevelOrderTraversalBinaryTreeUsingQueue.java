/*
	Author : Aman Kimothi
	E-mail : kimothiaman@gmail.com
	Github : https://github.com/Aman-Kimothi/DSA
*/

import java.util.Queue;
import java.util.LinkedList;

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
class LevelOrderTraversalBinaryTreeUsingQueue  {
	
	void levelOrderTraversal(BTNode root) {
		
		if(root == null)	{
			System.out.println("The tree is empty");
			return ;
		}
		
		Queue<BTNode> queue = new LinkedList<BTNode>();
		BTNode temp = root;
			
		while(temp != null) {
			
			System.out.print(temp.data + "\t");		// printing the node data
			
			if(temp.left != null)			// adding the left node
				queue.add(temp.left);
			
			if(temp.right != null)			// adding the right node
				queue.add(temp.right);
			
			temp = queue.poll();			// pop the first node
			
		}
	}
	
	public static void main(String args[]) {
		
		LevelOrderTraversalBinaryTreeUsingQueue tree = new LevelOrderTraversalBinaryTreeUsingQueue();
		
		BTNode root = new BTNode(1); 
		
		root.left = new BTNode(2);
		root.right = new BTNode(3);
		root.left.left = new BTNode(4);
		root.left.right = new BTNode(5);
		root.right.left = new BTNode(6);
		root.right.right = new BTNode(7);
		root.left.left.left = new BTNode(8);
		root.left.left.right = new BTNode(9);
		
		tree.levelOrderTraversal(root);
                
	}
}
