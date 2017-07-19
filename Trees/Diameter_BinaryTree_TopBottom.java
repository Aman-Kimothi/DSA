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

class Height {
	int height;
}

class Diameter_BinaryTree_TopBottom  {
	
	int diameter(BTNode root, Height h) {
		
		if(root == null) {
			h.height = 0;
			return 0;
		}
			
		Height lh = new Height();			// to store the height of the left sub tree
		Height rh = new Height();			// to store the height of the right sub tree
		
		int l_diameter = diameter(root.left , lh);		// diameter of left sub tree
		int r_diameter = diameter(root.right , rh);		// diameter of right sub tree
		
		h.height = Math.max(lh.height, rh.height) + 1;	// height of the current BTNode containing the root
		
		int height_including_root = lh.height + rh.height + 1;		// diameter of the current tree containing the root
		
		return Math.max(height_including_root , Math.max(l_diameter, r_diameter));
		
	}
	
	int height(BTNode root) {		// return the height of the tree
		
		if(root == null)
			return 0;
			
		return 1 + Math.max(height(root.left) , height(root.right));	
	}
	
	public static void main(String args[]) {
		
		Diameter_BinaryTree_TopBottom tree = new Diameter_BinaryTree_TopBottom();
		
		BTNode root = new BTNode(1); 
		
		root.left = new BTNode(2);
		root.right = new BTNode(3);
		root.left.left = new BTNode(4);
		root.left.right = new BTNode(5);
		root.right.left = new BTNode(6);
		root.right.right = new BTNode(7);
		root.left.left.left = new BTNode(8);
		root.left.left.right = new BTNode(9);
	
		Height h = new Height();
	
		int diameter = tree.diameter(root , h);
		
		System.out.println("Diameter of the tree is : "+ diameter);
                
	}
}
