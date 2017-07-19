/*
	Author : Aman Kimothi
	E-mail : kimothiaman@gmail.com
	Github : https://github.com/Aman-Kimothi/DSA
*/

import java.util.Arrays;
class RadixSort
{
	static int findMax(int arr[]) {
	
		int max = arr[0];
		for(int i : arr) {
			if(i > max)	max = i;
		}
		return max;
	}
	static int[] radixSort(int arr[] , boolean isAscending)  {
		
		int max = findMax(arr)  ,  digits = 0;  	
		
		while(0 < max) {
			digits++;
			max /= 10;
		}
		
		for(int i = 0 ; i < digits ; i++) {
			arr = countingSort(arr , (int)Math.pow(10, i) , isAscending);
		}
		
		return arr;
	}
	
	static int[] countingSort(int arr[], int emp , boolean isAscending)  {
		
		int len = arr.length;
		
		int output[] = new int[len];
		
		int count[] = new int[10];				// Making 10 buckets for sorting
		Arrays.fill(count, 0);        			   	// put all values = 0
		
		for(int i = 0; i < len; i++)		    		//  Adding the frequencies to the count[]
			++count[(arr[i] / emp) % 10];

 		for(int i = 1 ; i < 10; i++)   	     			// Finding cumulative frequency of each element
			count[i] += count[i-1];

		if(isAscending) {      					// Ascending Order
			for(int i = len - 1; i >= 0; i--)  { 		// Putting the elements in the output using the count[]
				int temp = (arr[i] / emp) % 10;
				output[count[temp] - 1] =  arr[i];      // Putting it at a location which is the index of the element stored in count
				count[temp]--;				// Decrementing the position for duplicate elements
			}	
		}
		else {							// Descending Order
			for(int i = 0; i < len ; i++) { 		// Putting the elements in the output using the count[]
				int temp = (arr[i] / emp) % 10;
				output[(len - 1) - (count[temp] - 1)] =  arr[i];     // Putting it at a location which is the subtraction of the total length from the index of the element stored in count.  (len - 1) is taken so that the values get stored from back of the array
				count[temp]--;					     // Decrementing the position for duplicate elements
			}
		}
		return output;
	}
	
	public static void main (String[] args)
	{
		// This only works for unsigned integer values.
		
		int arr[] = {170, 45, 75, 90, 802, 24, 2, 66};
		
		int brr[] = {170, 15, 55, 190, 82, 4, 122, 61};
		
		arr = radixSort(arr , true);
		
		System.out.println("The sorted array in ascending order is :  ");
		
		for(int x : arr)	System.out.print(x + "\t");
		
		brr = radixSort(brr , false);
		
		System.out.println("\nThe sorted array in descending order is :  ");
		
		for(int x : brr)	System.out.print(x + "\t");	
	}
}
