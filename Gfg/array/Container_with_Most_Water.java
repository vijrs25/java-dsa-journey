package array;
/*
1. Input: arr[] = [1, 5, 4, 3]
 Output: 6
 Explanation: 5 and 3 are 2 distance apart. So the size of the base = 2. Height of container = min(5, 3) = 3. So total area = 3 * 2 = 6.

2. Input: arr[] = [3, 1, 2, 4, 5]
Output: 12
Explanation: 5 and 3 are 4 distance apart. So the size of the base = 4. Height of container = min(5, 3) = 3. So total area = 4 * 3 = 12.

3. Input: arr[] = [2, 1, 8, 6, 4, 6, 5, 5]
Output: 25
Explanation: 8 and 5 are 5 distance apart. So the size of the base = 5. Height of container = min(8, 5) = 5. So, total area = 5 * 5 = 25.
*/


public class Container_with_Most_Water {
	
	public static void main(String[] args) {
		int[] arr = {2, 1, 8, 6, 4, 6, 5, 5};
        System.out.println(maxWater(arr));
        System.out.println(twoPointer(arr));
	}

	//Brute force
	private static int maxWater(int[] arr) {
		int currMin=0;
		int areaOfShape=0;
		for (int i = 0; i < arr.length-1; i++) {
			for (int j = i+1; j < arr.length; j++) {
				currMin =  Math.min(arr[i],arr[j]);
				areaOfShape = Math.max(areaOfShape, currMin*(j-i)); 
			}
		}
		return areaOfShape;
	}
	
	
	private static int twoPointer(int arr[]) {
		
		int l =0;
		int r= arr.length-1;
		int res=0;
		int currWaterLev;
		for (int i = 0; i < arr.length; i++) {
			
			while(l<r) {
				currWaterLev = Math.min(arr[l],arr[r])*(r-l);
				
				if(res<currWaterLev) {
					System.out.println(l+" "+r);
				}
				res = Math.max(res, currWaterLev);
				
				if(l < r) l++;
				else r--;
			}
		}
		return res;
	}

}
