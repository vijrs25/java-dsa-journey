package array;

import java.util.Set;
import java.util.TreeSet;

public class Median_of_two_Sorted_Arrays {

	 public static void main(String[] args) {
		 		
		 		int[] num1 = {1, 3};
		 		int[] num2 = {2};
		 		int m = num1.length;
		 		int n = num2.length;
		        Set<Integer> hs = new TreeSet<>();
		        for(int i = 0; i< m ; i++){
		            hs.add(num1[i]);
		        }

		        for(int i = 0; i< n ; i++){
		            hs.add(num2[i]);
		        }

		        double[] arr = hs.stream()
		                  .mapToDouble(Integer::doubleValue)
		                  .toArray();

		        if((hs.size())%2 == 0 )
		        {
		            System.out.println(arr[hs.size()/2]);
		        }
		        else{
		        	System.out.println(arr[hs.size()/2]); 
		        }

		    
	}
}
