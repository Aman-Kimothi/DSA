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
	
	void inorder_traversal(BTNode root) {
		if(root != null) {
			inorder_traversal(root.left);
			System.out.print(root.data + "\t");
			inorder_traversal(root.right);
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
	
		System.out.println("The inorder traversal of the tree using recursion method : ");
		tree.inorder_traversal(root);
	        
	}
}
