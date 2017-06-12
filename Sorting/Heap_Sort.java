class Heap_Sort_Ascending
{
	static void max_heap(int arr[] , int len , int i )  {
		
		int largest = i;       // taking the root as the largest
		int left = i*2 + 1;    // left subtree
		int right = i*2 + 2;   // right subtree
		
		if(left < len && arr[left] > arr[largest])   // checking if left subtree is greater
			largest = left;
			
		if(right < len && arr[right] > arr[largest])  // checking if right subtree is greater
			largest = right;
			
		if(largest != i)  {    // if root is not the greatest
	
			int temp = arr[largest];    // swapping to make the root greatest.
			arr[largest] = arr[i];
			arr[i] = temp;
			
			max_heap(arr,len,largest);  // using max_heap to maximize the affected tree
		}	
	}
	
	static void heap_sort(int arr[] )  {
		
		int len=arr.length;
		
		for(int i=len/2 -1 ; i>=0 ; i--)    // Converting the array into max_heap 
			max_heap(arr,len,i);
			
		// We'll extract the greatest(root) one by one and push it to the last index	
		
		for(int i = len-1 ; i >= 0 ; i--)  {
			
			int temp = arr[i];
			arr[i] = arr[0];
			arr[0] = temp;
			
			max_heap(arr, i, 0);
		}
	}

	public static void main (String[] args)
	{
		int arr[] =  {12, 11, 13, 5, 6, 7};
		heap_sort(arr);
		
		for(int x : arr)
			System.out.print(x + "\t");
	}
}