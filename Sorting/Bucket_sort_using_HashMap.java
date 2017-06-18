import java.util.Collections;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

class Bucket_Sort_using_HashMap
{
	static double max(double arr[]) {        // Returning the maximum element of the input array
		double max = arr[0];
		
		for(int i = 1; i < arr.length; i++)
			if(max < arr[i])
				max = arr[i];
				
		return max;		
	}
	
	static double[] bucket_sort(double arr[], boolean isAscending )  {
		
		int len = arr.length;
		double output[] = new double[len];
		HashMap<Integer , ArrayList<Double>> hmap = new HashMap<>();
		
		int max= (int)(Math.ceil(max(arr) / (double)10));     // Finding the factor/size of a specific bucket
		
		for(int i = 0; i < len; i++)  {
			
			int index = (int) (arr[i] / max);				// Finding the key value for the HashMap
			
			if(hmap.get(index) == null) {					// If the key value is not present in the HashMap
				ArrayList<Double> list=new ArrayList<>();
				list.add(arr[i]);
				hmap.put(index , list);					// Putting the list with one value
			}
			else  {
				ArrayList<Double> list=hmap.get(index);			// If the key value is present in the HashMap
				list.add(arr[i]);
				hmap.put(index , list);					// Putting the list with additional values
			}	
		}
		int  k = 0;
		
		if(isAscending)		k = 0;				// for Ascending Order
		else			k = len - 1;			// for Descending Order
		
		for (Map.Entry<Integer, ArrayList<Double>> entry : hmap.entrySet()) {
		   
		    Integer key = entry.getKey();
		    ArrayList<Double> value = entry.getValue();
		    
		    Collections.sort(value);				// Sorting the specific bucket
		    
		    if(isAscending)					// Ascending Order
			    for(double x : value)
			    	output[k++]=x;
			else						// Descending Order
				for(double x : value)
			    	output[k--]=x;
		}		
		return output;
	}

	public static void main (String[] args)
	{
		
		double arr[] =  {12.91, 312.122, 121.32, 32.25, 11.36, 43.27 , 33.18 , 34.56 ,54.22 ,433.75};
		double brr[] =  {.91, .122, .32, .25, .36, .27 , .18 , .56 , .22 , .75};
		
		arr = bucket_sort(arr , true);
		System.out.println("The sorted array in ascending order is :  ");
		
		for(double x : arr)		System.out.print(x + "\t");
			
		brr = bucket_sort(brr , false);
		System.out.println("\nThe sorted array in descending order is :  ");
		
		for(double x : brr)		System.out.print(x + "\t");
	
	}
}
