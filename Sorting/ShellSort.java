/*
	Author : Aman Kimothi
	E-mail : kimothiaman@gmail.com
	Github : https://github.com/Aman-Kimothi/DSA
*/

class ShellSort
{
	static void shellSort(int arr[] , boolean isAscending)  {
		
		int len = arr.length;
		int gap = len / 2;					// taking length/2 as the gap 
		
		for( ; gap > 0 ; gap /= 2)  {
			
			for(int i = gap ; i < len ; i++)  {
				
				int temp = arr[i];
				int j;
				
				if(isAscending)								// for Ascending Order
					for(j = i ; j >= gap && arr[j - gap] > temp ; j -= gap)
						arr[j] = arr[j - gap];
				else									// for Descending Order
					for(j = i ; j >= gap && arr[j - gap] < temp ; j -= gap)
						arr[j] = arr[j - gap];
					
				arr[j] = temp;	
			}
		}
	}

	public static void main (String[] args)
	{
		int arr[] =  {-12, 11, 13, -5, 6, 7 , 11, 2};
		
		shellSort(arr , true);
		System.out.println("The sorted array in ascending order is :  ");
		
		for(int x : arr)		System.out.print(x + "\t");
			
		shellSort(arr , false);
		 
		System.out.println("\nThe sorted array in descending order is :  ");
		
		for(int x : arr)		System.out.print(x + "\t");
	}
}
