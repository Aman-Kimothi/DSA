/*
	http://www.geeksforgeeks.org/print-ancestors-of-a-given-node-in-binary-tree/

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
class PrintAncestorsBinaryTree  {
	
	Boolean printAncestors(BTNode root, int data) {
		if(root == null)
			return false;
			
		if(root.data == data)
			return true;
			
		if(printAncestors(root.left, data) || printAncestors(root.right, data)) {
			System.out.print(root.data + "\t");
			return true;
		}
		return false;
	}
	
	public static void main(String args[]) {
		
		PrintAncestorsBinaryTree tree = new PrintAncestorsBinaryTree();
		
		BTNode root = new BTNode(1); 
		
		root.left = new BTNode(2);
		root.right = new BTNode(3);
		root.left.left = new BTNode(4);
		root.left.right = new BTNode(5);
		root.right.left = new BTNode(6);
		root.right.right = new BTNode(7);
		root.left.left.left = new BTNode(8);
		root.left.left.right = new BTNode(9);
	
		int node = 9;
		
		System.out.println("The ancestors of  "+ node + " are :");
		tree.printAncestors(root, node);
		        
	}
}
