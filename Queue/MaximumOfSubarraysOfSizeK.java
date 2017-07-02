/*
	Given an array and an integer k, find the maximum for 
	each and every contiguous subarray of size k.
	
	Input :		arr[] = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13}
				k = 4
	Output :	10 10 10 15 15 90 90
	
	Author : Aman Kimothi
	E-mail : kimothiaman@gmail.com
	Github : https://github.com/Aman-Kimothi/DSA	
*/

import java.util.PriorityQueue;
import java.util.Collections;
class MaximumOfSubarraysOfSizeK {
		
	PriorityQueue<Integer> queue;
	
	public MaximumOfSubarraysOfSizeK() {
		queue = new PriorityQueue<>(Collections.reverseOrder());	// Setting it to give priority to maximum elements
	}
	
	void printMaximumOfSubarrays(int arr[] , int k) {
		
		for(int i = 0 ; i < k-1 ; i++)		// Add till it stores k-1 elements
			queue.add(arr[i]);
			
		for(int i = k-1 ; i < arr.length ; i++) {
			
			queue.add(arr[i]);
			
			System.out.print(queue.peek() + "\t");		// Getting the max element
			
			queue.remove(arr[i - k + 1]);		// removing the first of the three elements
		}
	}
	
	public static void main(String args[]) {
		
		MaximumOfSubarraysOfSizeK obj = new MaximumOfSubarraysOfSizeK();
		
		int arr[] =  {1, 2, 3, 1, 4, 5, 2, 3, 6} ;
		int k = 3;
		
		System.out.println("Array is : ");
		for(int i : arr)
			System.out.print(i + "\t");
		
		System.out.println("\nOutput is : ");
		obj.printMaximumOfSubarrays(arr , k);
	}
}