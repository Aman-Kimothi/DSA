/*
	Author : Aman Kimothi
	E-mail : kimothiaman@gmail.com
	Github : https://github.com/Aman-Kimothi/DSA
*/

import java.util.Arrays;
class CountingSort
{
	static char[] countingSort(char arr[] , boolean isAscending)  {
		
		int len=arr.length;
		
		char output[]=new char[len];
		
		int count[]=new int[256];					// All the chars in the ASCII table
		Arrays.fill(count,0);        			   	// put all values = 0
		
		for(int i = 0; i < len; i++)    			 //  Adding the frequencies to the count[]
			++count[arr[i]];
			
		for(int i = 1 ; i < 256; i++)   	     	 // Finding cumulative frequency of each element
			count[i] += count[i-1];
		
		if(isAscending) {
			for(int i = 0; i < len; i++)  { 		    // Putting the elements in the output using the count[]
				char temp = arr[i];
				output[count[temp] - 1] =  temp;        // Putting it at a location which is the index of the element stored in count
				count[temp]--;						    // Decrementing the position for duplicate elements
			}	
		}
		else {
			for(int i = 0; i < len; i++)  { 		    // Putting the elements in the output using the count[]
				char temp = arr[i];
				output[(len - 1) - (count[temp] - 1)] =  temp;        // Putting it at a location which is the subtraction of the total length from the index of the element stored in count.  (len - 1) is taken so that the values get stored from back of the array
				count[temp]--;						    // Decrementing the position for duplicate elements
			}
		}
		
		return output;
	}
	
	public static void main (String[] args)
	{
		// This solution will only work for unsigned integer values
		char arr[] =  {'9', '1', '3', '5', '6', '7'};
		char brr[] =  {'g', 'e', 'e', 'k', 's', 'f', 'o', 'r', 'g', 'e', 'e', 'k', 's'};
		
		arr = countingSort(arr , true);
		brr = countingSort(brr , false);
		
		System.out.println("The sorted int array in ascending order is :  ");
		
		for(char x : arr)	System.out.print(x + "\t");
		
		System.out.println("\nThe sorted char array in descending order is :  ");
		
		for(char x : brr)	System.out.print(x + "\t");	
	}
}