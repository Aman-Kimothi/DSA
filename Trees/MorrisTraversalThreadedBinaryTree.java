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
	
class MorrisTraversalThreadedBinaryTree  {
	
	void inorderTraversal(BTNode root)  {
		
		if(root == null) {
			System.out.println("The tree is empty");
			return ;
		}
		
		BTNode curr = root;
		
		while(curr != null)  {
			
			if(curr.left == null) {
				System.out.print(curr.data + "\t");
				curr = curr.right;
			}	
			else {
				
				BTNode temp = curr.left;
				
				while(temp.right != null && temp.right != curr)
					temp = temp.right;
					
				if(temp.right == null) {
					temp.right = curr;
					curr = curr.left;
				}
				else {
					temp.right = null;
					System.out.print(curr.data + "\t");
					curr = curr.right;
				}
			}
		}
	}
	
	public static void main(String args[]) {
		
		MorrisTraversalThreadedBinaryTree tree = new MorrisTraversalThreadedBinaryTree();
		
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
		tree.inorderTraversal(root);

		root = new BTNode(1); 
		root.left = new BTNode(2);
		root.right = new BTNode(3);
		root.left.left = new BTNode(4);
		root.left.right = new BTNode(5);
		root.right.left = new BTNode(6);
		root.right.right = new BTNode(7);
		root.right.right.left = new BTNode(8);
		root.right.right.right = new BTNode(9);
		
		System.out.println("\nThe inorder traversal of the tree is : ");
		tree.inorderTraversal(root);
		
	}
}
