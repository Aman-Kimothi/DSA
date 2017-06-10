class Sorting
{
	
	public static int[] selection_sort(int arr[])  {
		
		for(int i=0;i<arr.length;i++)  {
			int pos=i;
		
			for(int j=i+1 ; j<arr.length ; j++) {   // finding the smallest element
				if(arr[j] < arr[pos]) 
					pos=j;
				
			}
			int temp=arr[i];   // swapping the elements
			arr[i]=arr[pos];
			arr[pos]=temp;
		}
		return arr;
	}

	public static void main (String[] args)
	{
		int arr[] =  {64, 25, 12, 22, 11};
                  
		arr=selection_sort(arr);
		
		for(int x : arr)
			System.out.print(x + "\t");
	}
}