class Sorting
{
	
	static int[] insertion_sort(int arr[])  {
		
		for(int i = 1 ; i < arr.length ; i++)  {
		
			int j = i-1;
			int key = arr[i];  // saving element stored at arr[i]
			
			// shifting all the elements to one position forward untill it finds a location to put the key
			while(j >= 0 && arr[j] > key ) {
				arr[j+1] = arr[j];
				j--;
			}
			
			arr[j+1] = key;
		}
		
		return arr;
	}

	public static void main (String[] args)
	{
		int arr[] =  {64, 25, 12, 22, 11};
		
		arr = insertion_sort(arr);
		
		for(int x : arr)
			System.out.print(x + "\t");
	}
}