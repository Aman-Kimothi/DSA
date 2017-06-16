class Bubble_sort
{	
	static void bubble_sort(int arr[] , boolean isAscending)  {
		
		boolean flag = true;  // check for different passes.
		
		if(isAscending) {
			for(int i = 0 ; flag && i < arr.length-1 ; i++)  {
				flag = false;  // It will stop when there is no swapping in a full pass.
				
				for(int j = 0 ; j < arr.length - 1 -i ; j++)  {
					if(arr[j] > arr[j+1]) {
						int temp = arr[j];
						arr[j] = arr[j+1];
						arr[j+1] = temp;
						flag = true;
					}
				}	
			}
		}
		else {
			for(int i = 0 ; flag && i < arr.length-1 ; i++)  {
				flag = false;  // It will stop when there is no swapping in a full pass.
				
				for(int j = 0 ; j < arr.length - 1 - i ; j++)  {
					if(arr[j] < arr[j+1]) {
						int temp = arr[j];
						arr[j] = arr[j+1];
						arr[j+1] = temp;
						flag = true;
					}
				}	
			}
		}
	}

	public static void main (String[] args)
	{
		int arr[] =  {-12, 11, 13, -5, 6, 7 , 2};
                  
		bubble_sort(arr , true);
		
		System.out.print("The ascending order is : " );
		for(int x : arr)	System.out.print(x + "\t");
		
		bubble_sort(arr , false);
		
		System.out.print("\nThe descending order is : " );
		for(int x : arr)	System.out.print(x + "\t");
	}
}