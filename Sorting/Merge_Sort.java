class Sorting
{
	static void merge(int arr[] , int l , int mid , int r , boolean isAscending )  {
		
		int n1 = mid - l + 1;     // Size of the first part of the array
		int n2 = r - mid  ;    	  // Size of the second part of the array
		int i , j , k = l;  
		
		int a[] = new int[n1] , b[] = new int[n2]  ;
		
		for(i = 0 ; i < n1 ; i++)     // Filling the values from left to mid of arr[] in array a[]
			a[i] = arr[l + i];
			
		for(i = 0 ; i < n2 ; i++)	 // Filling the values from mid to right of arr[] in array b[]
			b[i] = arr[mid + i +1];	
		
		i = j = 0;	
		
		
		if(isAscending)  {				 // For Ascending Order
			while(i < n1 && j < n2) {    // Adding elements to array arr[] in a sorted way.
				if(a[i] > b[j]) 
					arr[k++] = b[j++];
				else 
					arr[k++] = a[i++];
			}
		}
		else {							 // For Descending Order
			while(i < n1 && j < n2) {    // Adding elements to array arr[] in a sorted way.
				if(a[i] < b[j]) 
					arr[k++] = b[j++];
				else 
					arr[k++] = a[i++];
			}
		}
	
		while (i < n1)    		//  When elements of b[] are finished
	        	arr[k++] = a[i++];
	        
	   	while (j < n2) 			//  When elements of a[] are finished
	        	arr[k++] = b[j++];
	    
	}
	
	static void merge_sort(int arr[] , int l ,int r , boolean isAscending )  {
		
		if(l < r) {
		
			int mid = l+(r-l)/2;  // Same as (l+r)/2 but avoids overflow
			
			merge_sort( arr , l , mid , isAscending);
			merge_sort( arr , mid+1 , r , isAscending);
			merge(arr , l , mid , r , isAscending);
		}
		// isAscending is true for Ascending Order and false for Descending Order
	}

	public static void main (String[] args)
	{
		
		int arr[] =  {12, 11, 13, 5, 6, 7};
		
		merge_sort(arr , 0 , arr.length -1 , true);
		
		System.out.print("The array sorted in ascending order is : \t");
		for(int x : arr)
			System.out.print(x + "\t");
			
		merge_sort(arr , 0 , arr.length -1 , false);
		
		System.out.print("\nThe array sorted in descending order is : \t");
		for(int x : arr)
			System.out.print(x + "\t");
		
	}
}