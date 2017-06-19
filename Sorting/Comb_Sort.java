class Comb_sort
{
	static void comb_sort(int arr[] , boolean isAscending)  {
	
		int len = arr.length;
		boolean flag = true;				// Using a pass flag increases the efficiency. 
		
		// It's like Bubble sort but it has different factor for looping i.e  length/1.3
		
		for(int i=(int) (len/1.3) ; flag || i > 0 ; i /= 1.3)  {
			
			flag = false;				//We use a flag to keep a check on whether there are no swaps in a whole pass
		
		for(int j = 0 ; (i + j) < len ; j++) {
				
				if(isAscending && arr[j] > arr[i + j]) { 	  	// Ascending Order 		     
					int temp = arr[j];							// swap the values
					arr[j] = arr[i + j];
					arr[i + j] = temp;
					flag = true;
				}
				
				if(!isAscending && arr[j] < arr[i + j]) { 	  	// Descending Order
					int temp = arr[j];							// swap the values
					arr[j] = arr[i + j];
					arr[i + j] = temp;
					flag = true;
				}
			}
		}
	}

	public static void main (String[] args)
	{
		int arr[] = {44, 124, 49, 56, 3, -44, 23, 234, 141, 444};
		
		comb_sort(arr , true);
		System.out.println("The sorted array in ascending order is :  ");
		
		for(int x : arr)		System.out.print(x + "\t");
		
		comb_sort(arr , false);
		 
		System.out.println("\nThe sorted array in descending order is :  ");
		
		for(int x : arr)		System.out.print(x + "\t");
	}
}