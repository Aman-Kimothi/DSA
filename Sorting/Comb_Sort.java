class Comb_sort
{
	static void comb_sort(int arr[] , boolean isAscending)  {
	
		int len = arr.length;
		
		// It's like Bubble sort but it has different factor for looping i.e  length/1.3
		// We can also use a flag to keep a check on whether there are no swaps in a whole pass. By doing this, we can increase the efficiency. 
		
		for(int i=(int) (len/1.3) ; i > 0 ; i /= 1.3)  {
	
			for(int j = 0 ; (j+i) < len ; j++) {
				
				if(isAscending && arr[j] > arr[j+i]) { 	  		// Ascending Order 		     
					int temp = arr[j];							// swap the values
					arr[j] = arr[j+i];
					arr[j+i] = temp;
				}
				
				if(!isAscending && arr[j] < arr[j+i]) { 	  	// Descending Order
					int temp = arr[j];							// swap the values
					arr[j] = arr[j+i];
					arr[j+i] = temp;
				}
			}
		}
	}

	public static void main (String[] args)
	{
		int arr[] = {8, 4, 1, 56, 3, -44, 23, -6, 28, 0};
		
		comb_sort(arr , true);
		System.out.println("The sorted array in ascending order is :  ");
		
		for(int x : arr)		System.out.print(x + "\t");
		
		comb_sort(arr , false);
		 
		System.out.println("\nThe sorted array in descending order is :  ");
		
		for(int x : arr)		System.out.print(x + "\t");
	}
}