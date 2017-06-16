class Selection_sort
{
	static void selection_sort(int arr[] , boolean isAscending)  {
		
		for(int i = 0; i < arr.length; i++)  {
			int pos = i;
			
			if(isAscending) {
				for(int j = i + 1 ; j < arr.length ; j++) {   // finding the smallest element
					if(arr[j] < arr[pos]) 
						pos=j;
				}
			}
			else {
				for(int j = i + 1 ; j < arr.length ; j++) {   // finding the largest element
					if(arr[j] > arr[pos]) 
						pos=j;
				}
			}
			int temp = arr[i];   // swapping the elements
			arr[i] = arr[pos];
			arr[pos] = temp;
		}
	}

	public static void main (String[] args)
	{
		int arr[] =  {-12, 11, 13, -5, 6, 7 , 11, 2};
                  
		selection_sort(arr , true);
		
		System.out.print("The ascending order is : " );
		for(int x : arr)	System.out.print(x + "\t");
		
		selection_sort(arr , false);
		
		System.out.print("\nThe descending order is : " );
		for(int x : arr)	System.out.print(x + "\t");
	}
}