/*
	http://www.geeksforgeeks.org/check-if-a-binary-tree-is-subtree-of-another-binary-tree/

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
class CheckSubtreeBinaryTree  {
	
	Boolean checkSame(BTNode root1, BTNode root2) {
		
		if(root1 == null && root2 == null)
			return true;
			
		if(root1 == null || root2 == null)
			return false;	
		
		if(root1.data == root2.data) {
			return checkSame(root1.left, root2.left) &&
				   checkSame(root1.right, root2.right);
		}	
		return false;
	}
	
	Boolean isSubtree(BTNode root1, BTNode root2) {
		if(root2 == null)
			return true;
		
		if(root1 == null )
			return false;
			
		if(checkSame(root1 , root2))
			return true;
		
		return isSubtree(root1.left, root2) || isSubtree(root1.right, root2);
		
	}
	
	public static void main(String args[]) {
		
		CheckSubtreeBinaryTree tree = new CheckSubtreeBinaryTree();
		
		BTNode root = new BTNode(26); 
		root.left = new BTNode(10);
		root.right = new BTNode(3);
		root.left.left = new BTNode(4);
		root.left.right = new BTNode(6);
		root.right.right = new BTNode(3);
		root.left.left.right = new BTNode(30);
		
		BTNode root2 = new BTNode(10); 
		root2.left = new BTNode(4);
		root2.right = new BTNode(6);
		root2.left.right = new BTNode(30);
	
		if(tree.isSubtree(root, root2))
			System.out.println("Yes");
		else
			System.out.println("No");
		        
	}
}
