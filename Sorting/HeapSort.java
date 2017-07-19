/*
	Author : Aman Kimothi
	E-mail : kimothiaman@gmail.com
	Github : https://github.com/Aman-Kimothi/DSA
*/
class HeapSort
{
	// We're usign maxHeap to get the Ascending Order and minHeap to get the Descending Order

	static void maxHeap(int arr[] , int len , int i )  {
		
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
			
			maxHeap(arr,len,largest);  // using maxHeap to maximize the affected tree
		}	
	}
	
	static void minHeap(int arr[] , int len , int i )  {
		
		int smallest = i;       // taking the root as the smallest
		int left = i*2 + 1;    // left subtree
		int right = i*2 + 2;   // right subtree
		
		if(left < len && arr[left] < arr[smallest])   // checking if left subtree is smaller
			smallest = left;
			
		if(right < len && arr[right] < arr[smallest])  // checking if right subtree is smaller
			smallest = right;
			
		if(smallest != i)  {   			 // if root is not the smallest
	
			int temp = arr[smallest];    // swapping to make the root smallest.
			arr[smallest] = arr[i];
			arr[i] = temp;
			
			minHeap(arr,len,smallest);  // using minHeap to minimize the affected tree
		}	
	}
	
	static void heapSort(int arr[] , boolean isAscending )  {
		
		int len=arr.length;
		
		if(isAscending) {
			for(int i=len/2 -1 ; i>=0 ; i--)    // Converting the array into maxHeap 
				maxHeap(arr,len,i);
		}
		else {
			for(int i=len/2 -1 ; i>=0 ; i--)    // Converting the array into minHeap 
				minHeap(arr,len,i);
		}
			
		if(isAscending)  {				// Ascending Order
			// We'll extract the greatest(root) one by one and push it to the last index	
			for(int i = len-1 ; i >= 0 ; i--)  {
				
				int temp = arr[i];
				arr[i] = arr[0];
				arr[0] = temp;
				
				maxHeap(arr, i, 0);
			}
		}
		else  {				// Descending Order
			// We'll extract the smallest(root) one by one and push it to the last index	
			for(int i = len-1 ; i >= 0 ; i--)  {
				
				int temp = arr[i];
				arr[i] = arr[0];
				arr[0] = temp;
				
				minHeap(arr, i, 0);
			}
		}
	}

	public static void main (String[] args)
	{
		int arr[] =  {-12, 11, -13, 5, 6, -7 , 24 , 44 , 22 -4 , 0};
		
		heapSort(arr , true);
		
		System.out.print("The ascending order is : " );
		for(int x : arr)	System.out.print(x + "\t");
		
		heapSort(arr , false);
		
		System.out.print("\nThe descending order is : " );
		for(int x : arr)	System.out.print(x + "\t");
	}
}