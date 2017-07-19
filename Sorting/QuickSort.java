/*
	Author : Aman Kimothi
	E-mail : kimothiaman@gmail.com
	Github : https://github.com/Aman-Kimothi/DSA
*/
class QuickSort
{
	 // l : left and r : right	
	static int partition(int arr[] , int l , int r , boolean isAscending)  {
		
		int pivot = arr[r];      // taking the pivot as the last element
		int i = l-1;			 // Taking i to keep index of the smaller element
		
		if(isAscending)  {		// Ascending Order
			for(int j = l ; j < r ; j++) {
				if(arr[j] <= pivot) {    // if the element is smaller, swap it.
					i++;
					int temp = arr[j];  // swapping the values
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}
		}
		else {					// Descending Order
			for(int j = l ; j < r ; j++) {
				if(arr[j] > pivot) {    // if the element is larger , swap it.
					i++;
					int temp = arr[j];  // swapping the values
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}
		}
		
		int temp = arr[r];  // Changing the pivot to the partition point
		arr[r] = arr[i+1];
		arr[i+1] = temp;
		
		return i+1;
	}
	
	static void quickSort(int arr[] , int l , int r, boolean isAscending)  {
		
		if(l < r)  {
		
			int partition_point = partition(arr , l , r, isAscending);
			
			quickSort(arr , l , partition_point - 1 , isAscending);
			quickSort(arr , partition_point + 1 , r , isAscending);
		}
		
	}

	public static void main (String[] args)
	{
		
		int arr[] =  {-12, 11, 13, -5, 6, 7};
		
		quickSort(arr , 0 , arr.length-1 , true);
		
		System.out.print("The sorted values in ascending order are : ");
		for(int x : arr)
			System.out.print(x + "\t");
			
		quickSort(arr , 0 , arr.length-1 , false);
		
		System.out.print("\nThe sorted values in descending order are : ");
		for(int x : arr)
			System.out.print(x + "\t");
	}
}