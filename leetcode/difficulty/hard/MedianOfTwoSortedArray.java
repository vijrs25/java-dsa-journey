package leetcode.difficulty.hard;

import java.util.Arrays;

public class MedianOfTwoSortedArray {

	/*
	 * Input: nums1 = [1,3], nums2 = [2] Output: 2.00000 Explanation: merged array =
	 * [1,2,3] and median is 2. Example 2:
	 * 
	 * Input: nums1 = [1,2], nums2 = [3,4] Output: 2.50000 Explanation: merged array
	 * = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
	 */

	public static void main(String[] args) {
		int[] num1 = { 1,3};
		int[] num2 = { 2 }; // 2,2,2,2, 2, 4,4,4,4

		double res = getMaiden(num1, num2);
		System.out.println(res);

	}

	private static double getMaiden(int[] num1, int[] num2) {
		int n = num1.length;
		int m = num2.length;
		if (n == 0 && m == 0) {
			return 0;
		}

		int[] res = new int[n + m];

		int i = 0;
		int j = 0;
		int k = 0;
		while (i < n && j < m) {
			if (num1[i] < num2[j]) {
				res[k] = num1[i];
				i++;
				k++;
			} else {
				res[k] = num2[j];
				j++;
				k++;
			}
		}

		while (i != n) {
			res[k] = num1[i];
			i++;
			k++;
		}
		while (j != m) {
			res[k] = num2[j];
			j++;
			k++;
		}

		if ((n + m) % 2 == 1)
			return res[(n + m) / 2];
		else {
			double a = res[(n + m) / 2];
			double b = res[(((n + m) / 2) - 1)];
			System.out.println(a + " " + b);
			return (a + b) / 2;
		}
	}

}
