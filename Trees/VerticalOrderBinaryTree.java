/*
			          1
			        /   \
			       2     3
			      / \   / \ 
			     4   5 6   7
			            \   \
			             8   9 
			               
						  
			The output of print this tree vertically will be:
			4
			2
			1 5 6
			3 8
			7
			9 
			
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
	
class VerticalOrderBinaryTree  {
	
	int min , max;				// global variables used to store the min value. of lines and max value of lines.
	
	void verticalOrder(BTNode root)  {
		
		if(root == null) {
			System.out.println("The tree is empty");
			return ;
		}
		
		findMinMaxHorizontal(root, 0);		// finding the value of max and min
		
		for(int i = min; i <= max; i++) 		// printing the nodes for each vertical line
			printVerticalLine(root , i, 0);
		
	}
	
	void printVerticalLine(BTNode node, int line, int i) {
		
		if(node == null)
			return ;
			
		if(i == line)					// if the node lies in the vertical line
			System.out.print(node.data + "\t");
			
		printVerticalLine(node.left , line , i-1);		//	checking the left subtree
		printVerticalLine(node.right , line , i+1);	//	checking the right subtree
	}
	
	
	void findMinMaxHorizontal(BTNode root, int line){
		
		if(root == null)
			return;
		
		if(min > line)	min = line;		// if min is greater than the specific line number
		
		if(max < line)	max = line;		// if max is smaller than the specific line number
			
		findMinMaxHorizontal(root.left , line - 1);		// searching in the left sub tree
		findMinMaxHorizontal(root.right , line + 1);		// searching in the right sub tree
	}
	
	public static void main(String args[]) {
		
		VerticalOrderBinaryTree tree = new VerticalOrderBinaryTree();
		
		BTNode root = new BTNode(1); 
		
		root.left = new BTNode(2);
		root.right = new BTNode(3);
		root.left.left = new BTNode(4);
		root.left.right = new BTNode(5);
		root.right.left = new BTNode(6);
		root.right.right = new BTNode(7);
		root.right.left.right = new BTNode(8);
		root.right.right.right = new BTNode(9);
		
		System.out.println("The vertical order of the tree is : ");
		tree.verticalOrder(root);
	}
}
