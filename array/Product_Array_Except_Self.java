package array;

import java.util.Arrays;

/*Input: arr[] = [10, 3, 5, 6, 2]
Output: [180, 600, 360, 300, 900]
Explanation: 
For i=0, res[i] = 3 * 5 * 6 * 2 is 180.
For i = 1, res[i] = 10 * 5 * 6 * 2 is 600.
For i = 2, res[i] = 10 * 3 * 6 * 2 is 360.
For i = 3, res[i] = 10 * 3 * 5 * 2 is 300.
For i = 4, res[i] = 10 * 3 * 5 * 6 is 900.
*/

public class Product_Array_Except_Self {
  
	public static int[] bruteForce(int[] arr) {
		int n= arr.length;
		int[] res = new int[n];
		
		for (int i = 0; i < res.length; i++) {
			res[i]=1;
			for (int j = 0; j < res.length; j++) {
				if(i!=j) {
					res[i]=res[i]*arr[j];
					}
			}
		}return res;
	}
	
	//Prefix and suffix
	private static int[] preffixSuff(int[] arr) {

		int n = arr.length;
		int[] pre = new int[n];
		int[] suff = new int[n];
		int[] res = new int[n];

		pre[0] = 1; // If first value is 0 so 1 is good
		for (int i = 1; i < n; i++) {
			pre[i] = arr[i - 1] * pre[i - 1];
		}

		suff[n - 1] = 1;
		for (int j = n - 2; j >= 0; j--) {
			suff[j] = arr[j + 1] * suff[j + 1];
		}

		for (int i = 0; i < n; i++) {
			res[i] = pre[i] * suff[i];
		}
		return res;
	}

	// totalSum/arr[i] one traversal
	private static int[] productExceptSelf(int[] arr) {

		int totalMul = 1;
		int zeroes = 0;
		int[] res = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				totalMul *= arr[i];
			} else
				zeroes++;
		}

		Arrays.fill(res, 0);

		for (int i = 0; i < res.length; i++) {

			if (zeroes == 1 && arr[i] == 0)
				res[i] = totalMul;
			if (zeroes == 0)
				res[i] = totalMul / arr[i];
		}
		return res;
	}

	public static void main(String[] args) {
		int[] arr = { 10, 3, 5, 6, 2,0,0};
		int[] res = productExceptSelf(arr);
		int[] res2 = preffixSuff(arr);
		int[] res3 = bruteForce(arr);
		for (int ele : res3) {
			System.out.print(ele + " ");
		}
	}

}
