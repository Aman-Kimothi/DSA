/*
	Author : Aman Kimothi
	E-mail : kimothiaman@gmail.com
	Github : https://github.com/Aman-Kimothi/DSA
*/

import java.util.ArrayList;
class BucketSort
{
	static double[] insertionSort(double arr[])  {			// Insertion Sort
		
		int len = arr.length;
		
		for(int i = 1 ; i < len ; i++)  {
			double key = arr[i];
			int pos = i-1;		 // saving element stored at arr[i]
			
			// shifting all the elements to one position forward untill it finds a location to put the key
			
			while(pos >= 0 && arr[pos] > key)	{
				arr[pos+1] = arr[pos];
				pos--;
			}
			arr[pos+1] = key;
		}
		return arr;
	}

	static double max(double arr[]) {        // Returning the maximum element of the input array
		double max = arr[0];
		
		for(int i = 1; i < arr.length; i++)
			if(max < arr[i])
				max = arr[i];
				
		return max;		
	}

	static double[] bucketSort(double arr[] , boolean isAscending )  {
		
		int len = arr.length;
		double output[] = new double[len];
		
		int max= (int)(Math.ceil(max(arr) / (double)10));     // Finding the factor/size of a specific bucket
		
		ArrayList<Double>[] list = (ArrayList<Double>[]) new ArrayList[10];
		
		for( int i = 0; i < 10; i++) {              // initializing every element of arraylist[]
		    list[i] = new ArrayList<Double>();
		}
		
		for(int i=0;i<len;i++)  {                 // putting the elements in the specific bucket
			
			int index=(int)(arr[i]/max); 
			list[index].add(arr[i]);
		}
		
		int k = 0;     		// Counter for storing the bucket elements in the result array
		
		if(isAscending) 	k = 0;				// for Ascending Order
		else			k = arr.length - 1;		// for Descending Order
		
		for (int i = 0; i < 10; i++) {     // For every bucket, do insertion sort and add the sorted array to the output array
			   
		    if(list[i] == null) continue;
		    
		    int size = list[i].size() , count = 0;
		    double[] temp = new double[size];	     // Using an array to store the bucket elements
			
			for(Double num : list[i])
				temp[count++] = num;
			
		    temp = insertionSort(temp);	     // Insertion Sort only in Ascending Order will also do the job as we can fill the resultant array from behind in the Descending Order case
		    
		    if(isAscending)					     //	Ascending Order
			    for(double x : temp)		   	// Filling the array from front
			    	output[k++]=x;				 
			else
				for(double x : temp)			// Descending Order
			    	output[k--]=x;	   			// Filling the array from end
		}
		
		return output;
	}

	public static void main (String[] args)
	{
		// This solution works for unsigned floating integer values
		
		double arr[] =  {12.91, 312.122, 121.32, 32.25, 11.36, 43.27 , 33.18 , 34.56 ,54.22 ,433.75};
		double brr[] =  {.91, .122, .32, .25, .36, .27 , .18 , .56 , .22 , .75};
		
		arr = bucketSort(arr , true);
		System.out.println("The sorted array in ascending order is :  ");
		
		for(double x : arr)		System.out.print(x + "\t");
			
		brr = bucketSort(brr , false);
		System.out.println("\nThe sorted array in descending order is :  ");
		
		for(double x : brr)		System.out.print(x + "\t");
	
	}
}
