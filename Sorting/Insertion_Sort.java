class Insertion_sort
{
	static void insertion_sort(int arr[] , boolean isAscending)  {
		
		for(int i = 1 ; i < arr.length ; i++)  {
		
			int j = i-1;
			int key = arr[i];  // saving element stored at arr[i]
			
			// shifting all the elements to one position forward untill it finds a location to put the key
				
			if(isAscending) {			// Ascending Order
				while(j >= 0 && arr[j] > key ) {
					arr[j+1] = arr[j];
					j--;
				}
			}
			else {						// Descending Order			
				while(j >= 0 && arr[j] < key ) {
					arr[j+1] = arr[j];
					j--;
				}
			}
			arr[j+1] = key;
		}
	}

	public static void main (String[] args)
	{
		int arr[] =  {-12, 11, 13, -5, 6, 7 , 2 , 11};
		
		insertion_sort(arr , true);
		
		System.out.print("The ascending order is : " );
		for(int x : arr)	System.out.print(x + "\t");
		
		insertion_sort(arr , false);
		
		System.out.print("\nThe descending order is : " );
		for(int x : arr)	System.out.print(x + "\t");
	}
}