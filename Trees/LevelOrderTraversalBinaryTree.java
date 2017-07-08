/*
	Author : Aman Kimothi
	E-mail : kimothiaman@gmail.com
	Github : https://github.com/Aman-Kimothi/DSA
*/

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
class LevelOrderTraversalBinaryTree  {
	
	void levelOrderTraversal(BTNode root) {
		int height = findHeight(root);
		
		if(height == 0) {
			System.out.print("The binary tree is empty");
			return ;
		}
		
		for(int i = 1; i <= height ; i++) {			// Printing the elements of every level
			printGivenLevel(root , i);
		}
	}
	
	// prints the data from the BTNodes of the given level
	void printGivenLevel(BTNode root , int level)  {
		
		if(root == null )		
			return ;
			
		if(level == 1)	{     					
			System.out.print(root.data + "\t");
		}
		else {
			printGivenLevel(root.left , level - 1);	
			printGivenLevel(root.right , level - 1);
		}
	}
	
	int findHeight(BTNode root) {			// returns the height of the tree
		
		if(root == null)
			return 0;
		
		return 1 + Math.max(findHeight(root.left) , findHeight(root.right));
	}
	
	public static void main(String args[]) {
		
		LevelOrderTraversalBinaryTree tree = new LevelOrderTraversalBinaryTree();
		
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