/*
	http://www.geeksforgeeks.org/check-if-a-binary-tree-is-subtree-of-another-binary-tree/

	Author : Aman Kimothi
	E-mail : kimothiaman@gmail.com
	Github : https://github.com/Aman-Kimothi/DSA
*/

import java.util.ArrayList;
import java.util.stream.*;

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
class CheckSubtreeBinaryTreeUsingTraversals  {
	
 	ArrayList<Integer> inOrderTraversal(BTNode root, ArrayList<Integer> arr) {
		if(root != null) {
			inOrderTraversal(root.left, arr);
			arr.add(root.data);
			inOrderTraversal(root.right, arr);
		}
		return arr;
	}
	
 	ArrayList<Integer> preOrderTraversal(BTNode root, ArrayList<Integer> arr) {
		if(root != null) {
			arr.add(root.data);
			preOrderTraversal(root.left, arr);
			preOrderTraversal(root.right, arr);
		}
		return arr;
	}
	/* This function only works in Java 8 and later */
	
	Boolean isSubarray1(ArrayList<Integer> list1 , ArrayList<Integer> list2 ) {
		
		String list11 = list1.stream().map(Object::toString).collect(Collectors.joining(", "));
		
		String list22 = list2.stream().map(Object::toString).collect(Collectors.joining(", "));
		
		if(list11.contains(list22))
			return true;
		else	
			return false;
	}
	
	Boolean isSubarray2(ArrayList<Integer> list1 , ArrayList<Integer> list2 ) {
		
		int length1 = list1.size() , length2 = list2.size();
	
		Integer arr[] = new Integer[length1];
		list1.toArray(arr);
		Integer brr[] = new Integer[length2];
		list2.toArray(brr);
		
		int j = 0;
		Boolean flag = true;
		
		for(int i = 0; i < length1 ; i++ ) {
			if(arr[i] == brr[j]) {
				
				flag = true;			// check for found sub array
				int temp = i + 1;
				
				for(j = 1 ; j < length2 ; j++) {	// checking every element of list2 with list1
					if(arr[temp++] != brr[j])
						flag = false;
				}
			
				if(!flag)			// if sub array is not found at ith position
					j = 0;
				else				
					return true;
			}
		}
		return false;
	}
	
	public static void main(String args[]) {
		
		CheckSubtreeBinaryTreeUsingTraversals tree = new CheckSubtreeBinaryTreeUsingTraversals();
		
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
		
		ArrayList<Integer> pre_root = new ArrayList<Integer>();
		ArrayList<Integer> in_root = new ArrayList<Integer>();
		ArrayList<Integer> pre_root2 = new ArrayList<Integer>();
		ArrayList<Integer> in_root2 = new ArrayList<Integer>();
		
		pre_root = tree.preOrderTraversal(root, pre_root);
		in_root = tree.inOrderTraversal(root, in_root);
		pre_root2 = tree.preOrderTraversal(root2, pre_root2);
		in_root2 = tree.inOrderTraversal(root2, in_root2);
		
		if(tree.isSubarray2(in_root, in_root2) && tree.isSubarray2(pre_root, pre_root2))
			System.out.println("Yes");
		else
			System.out.println("No");
	}
}
