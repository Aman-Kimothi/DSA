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
class Diameter_BinaryTree  {
	
	int diameter(BTNode root) {
		
		if(root == null)
			return 0;
			
		int left_height = height(root.left);						// height of the left sub tree
		int right_height = height(root.right);						// height of the right sub tree
		int height_with_root = left_height + 1 + right_height;		// height of the sub tree containing the root
		
		int left_diameter = diameter(root.left);					// Finding diameter of the left sub tree in a recursive manner
		int right_diameter = diameter(root.right);					// Finding diameter of the right sub tree in a recursive manner
		
		// Returning the maximum of the height(left_sub + 1[root] + righ_sub) , dia(left_sub) and dia(right_sub).
		
		return Math.max( height_with_root , Math.max(left_diameter , right_diameter));
	}
	
	int height(BTNode root) {		// return the height of the tree
		
		if(root == null)
			return 0;
			
		return 1 + Math.max(height(root.left) , height(root.right));	
	}
	
	public static void main(String args[]) {
		
		Diameter_BinaryTree tree = new Diameter_BinaryTree();
		
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
