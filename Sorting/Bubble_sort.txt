class Sorting
{
	
	public static int[] bubble_sort(int arr[])  {
		
		boolean flag=true;  // check for different passes.
		
		for(int i=0 ; flag && i<arr.length-1 ; i++)  {
			flag=false;  // It will stop when there is no swapping in a full pass.
			
			for(int j=0 ; j<arr.length-1-i ; j++)  {
				if(arr[j] > arr[j+1]) {
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
					flag=true;
				}
			}	
		}
		
		return arr;
	}

	public static void main (String[] args)
	{
		int arr[] =  {64, 25, 12, 22, 11};
                  
		arr=bubble_sort(arr);
		
		for(int x : arr)
			System.out.print(x + "\t");
	}
}