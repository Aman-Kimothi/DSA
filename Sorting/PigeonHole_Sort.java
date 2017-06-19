import java.util.ArrayList;
class PigeonHole_Sort
{
	// This sorting technique is same as Counting Sort but not as efficient as Counting Sort 
	// It is not very efficient if the range is becomes very large.
	
	public static int[] pigeonhole_sort(int arr[] , boolean isAscending )  {
		
		int len = arr.length ;
		int min = arr[0] , max = arr[0];
		
		int[] output = new int[len];
		
		for(int i = 1; i < len; i++) {  			 // finding max and min
			if(arr[i] > max)
				max = arr[i];
			if(arr[i] < min)
				min = arr[i];
		}
		
		int range = max - min + 1;  				 // finding range for no. of pigeonhole
		
		ArrayList<Integer>[] pigeonholes = (ArrayList<Integer>[]) new ArrayList[range];
	
		for(int i = 0; i < range; i++)   			// initializing the arraylist[]
			pigeonholes[i] = new ArrayList<Integer>();
	
		for(int i = 0; i < len; i++)       			// adding the number to their specific pigeonhole (arraylist)
			pigeonholes[arr[i] - min].add(arr[i]);
		
		int k = 0;
		
		if(isAscending)	{ 
			for(int i = 0; i < range; i++)  {    	
				for(int  value : pigeonholes[i])
					output[k++]=value;
			}	
		}
		else {
			for(int i = range - 1; i >= 0; i--)  {    	
				for(int  value : pigeonholes[i])
					output[k++]=value;
			}
		}
		return output;
	}

	public static void main (String[] args)	
	{
		
		int arr[] = {234, 44, 124, 49, 56, 3, 844, 223, 234, 141, 444};
		
		arr = pigeonhole_sort(arr , true);
		
		System.out.print("The ascending order is : " );
		for(int x : arr)	System.out.print(x + "\t");
		
		arr = pigeonhole_sort(arr , false);
		
		System.out.print("\nThe descending order is : " );
		for(int x : arr)	System.out.print(x + "\t");
	
	}
}
