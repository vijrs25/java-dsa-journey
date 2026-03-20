package array;

/*
Input: arr[] = [2, 3, -8, 7, -1, 2, 3]
Output: 11
Explanation: The subarray [7, -1, 2, 3] has the largest sum 11
.*/
public class Maximum_of_subArray {

	public static void main(String[] args) {
		int[] arr = {2, 3, -8, 7, -1, 2, 3,-11,6,3,2,-1,-2};
		System.out.println(maxSubarraySum(arr));
		System.out.println(kadane(arr));

	}

	// Brute Force
	private static int maxSubarraySum(int[] arr) {
		int curretSum;
		int maxSum = 0;
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			curretSum = 0;
			for (int j = i; j < arr.length; j++) {
				curretSum += arr[j];

				if (curretSum > maxSum) {
					maxSum = curretSum;
					count++;
					if (count == 1)
						System.out.println(i + " " + j + " " + maxSum);
					count = 0;
				}

			}
		}
		return maxSum;
	}
	
	//Kadane's algorithms
	public static int kadane(int [] arr) {
		int res = arr[0];
		int curreSum = arr[0];
		for (int i = 1; i < arr.length; i++) {
			curreSum =  Math.max(arr[i], curreSum+arr[i]);
			res =Math.max(res, curreSum);
		}
		return curreSum;
	}

}
