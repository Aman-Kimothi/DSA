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
class DiameterBinaryTree  {
	
	int diameter(BTNode root) {
		
		if(root == null)
			return 0;
			
		int leftHeight = height(root.left);						// height of the left sub tree
		int rightHeight = height(root.right);						// height of the right sub tree
		int heightWithRoot = leftHeight + 1 + rightHeight;		// height of the sub tree containing the root
		
		int leftDiameter = diameter(root.left);					// Finding diameter of the left sub tree in a recursive manner
		int rightDiameter = diameter(root.right);					// Finding diameter of the right sub tree in a recursive manner
		
		// Returning the maximum of the height(left_sub + 1[root] + righ_sub) , dia(left_sub) and dia(right_sub).
		
		return Math.max( heightWithRoot , Math.max(leftDiameter , rightDiameter));
	}
	
	int height(BTNode root) {		// return the height of the tree
		
		if(root == null)
			return 0;
			
		return 1 + Math.max(height(root.left) , height(root.right));	
	}
	
	public static void main(String args[]) {
		
		DiameterBinaryTree tree = new DiameterBinaryTree();
		
		BTNode root = new BTNode(1); 
		
		root.left = new BTNode(2);
		root.right = new BTNode(3);
		root.left.left = new BTNode(4);
		root.left.right = new BTNode(5);
		root.right.left = new BTNode(6);
		root.right.right = new BTNode(7);
		root.left.left.left = new BTNode(8);
		root.left.left.right = new BTNode(9);
	
		int diameter = tree.diameter(root);
		
		System.out.println("Diameter of the tree is : "+ diameter);
                
	}
}
