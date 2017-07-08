/*
	Author : Aman Kimothi
	E-mail : kimothiaman@gmail.com
	Github : https://github.com/Aman-Kimothi/DSA
*/

class BTNode {
	int data;
	BTNode left;
	BTNode right;
	boolean threaded;
	
	public BTNode(int d) {
		data = d;
		left = null;
		right = null;
		threaded = false;
	}
}

class InorderTraversalThreadedBinaryTree  {
	
	void inorder_traversal(BTNode root)  {
		
		if(root == null) {
			System.out.println("The tree is empty");
			return ;
		}
		
		BTNode curr = root;
		
		while(curr != null && curr.left != null)		// finding the left most leaf node
			curr = curr.left;
		
		while(curr != null)  {
			
			System.out.print(curr.data + "\t");
			
			if(curr.threaded)							// if the node is threaded i.e leaf nodes except the rightmost leaf node
				curr = curr.right;
			else {
		
				curr = curr.right;						// processing the right sub tree
				while(curr != null && curr.left != null )		// finding the left most leaf node
					curr = curr.left;
			}
		}
	}
	
	public static void main(String args[]) {
		
		InorderTraversalThreadedBinaryTree tree = new InorderTraversalThreadedBinaryTree();
		
		BTNode root = new BTNode(1); 
		
		root.left = new BTNode(2);
		root.right = new BTNode(3);
		root.left.left = new BTNode(4);
		root.left.right = new BTNode(5);
		root.right.left = new BTNode(6);
		root.right.right = new BTNode(7);
		root.left.left.left = new BTNode(8);
		root.left.left.right = new BTNode(9);
		
		/* Threading the links of the leaves to their inorder successor node*/
		
		root.left.right.right = root;
		root.right.left.right = root.right;
		root.left.left.left.right = root.left.left; 
		root.left.left.right.right = root.left; 
		
		/* Defining the nodes as threaded for the leaves*/
		root.left.right.threaded = true;
		root.right.left.threaded = true;
		root.left.left.left.threaded = true;
		root.left.left.right.threaded = true;
		
		System.out.println("The inorder traversal of the tree is : ");
		tree.inorder_traversal(root);

		root = new BTNode(1); 
		root.left = new BTNode(2);
		root.right = new BTNode(3);
		root.left.left = new BTNode(4);
		root.left.right = new BTNode(5);
		root.right.left = new BTNode(6);
		root.right.right = new BTNode(7);
		root.right.right.left = new BTNode(8);
		root.right.right.right = new BTNode(9);
		
		/* Threading the links of the leaves to their inorder successor node*/
		
		root.left.left.right = root.left;
		root.left.right.right = root;
		root.right.left.right = root.right;
		root.right.right.left.right = root.right.right; 
		
		/* Defining the nodes as threaded for the leaves*/

		root.left.left.threaded = true;
		root.left.right.threaded = true;
		root.right.left.threaded = true;
		root.right.right.left.threaded = true;
		
		
		System.out.println("\nThe inorder traversal of the tree is : ");
		tree.inorder_traversal(root);
		
	}
}
