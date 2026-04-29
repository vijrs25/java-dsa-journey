package leetcode.target75;
//Given an integer array nums, return true if there exists a triple of indices (i, j, k) such that i < j < k and nums[i] < nums[j] < nums[k]. If no such indices exists, return false.

//Example 1:
//
//Input: nums = [1,2,3,4,5]
//Output: true
//Explanation: Any triplet where i < j < k is valid.

public class Tripletsexixts {

	public static void main(String[] args) {

		// int[] nums = {5,4,3,2,1,1,1,1,1,2,3,2};
		 int[] nums = { 9, 5, 10, 5, 11, 10, 9, 8 };
		// int [] nums = {9,12,5,11,10,11,12,9};
		//int[] nums = { 5, 1, 6, 7 };
		// {1,2,2,2,2,2,3,2,1,1,}
		// lmax>i I++ lmax = i, i<=i+1 i++ , r--
		// System.out.println(boolTriplet(nums));
		// System.out.println(boolTripletS(nums));
		System.out.println(boolLRcenter(nums));
	}

	private static boolean boolLRcenter(int[] nums) {
		 int first = Integer.MAX_VALUE;
		    int second = Integer.MAX_VALUE;

		    for (int num : nums) {
		        if (num <= first) {
		            first = num;
		        } else if (num <= second) {
		            second = num;
		        } else {
		            return true; 
		        }
		    }
		    return false;
	}

	private static boolean boolTripletS(int[] nums) {
		int len1 = nums.length;
		int[] left = new int[len1];
		int[] right = new int[len1];

		left[0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			left[i] = Math.min(left[i - 1], nums[i - 1]);
		}

		right[len1 - 1] = nums[len1 - 1];
		for (int i = len1 - 2; i >= 0; i--) {
			right[i] = Math.max(right[i + 1], nums[i + 1]);
		}

		for (int i = 1; i < nums.length; i++) {
			if (left[i] < nums[i]) {
				if (nums[i] < right[i]) {
					return true;
				}
			}
		}
		return false;
	}

	private static boolean boolTriplet(int[] nums) {
		if (nums.length < 3)
			return false;
		int leftmin = 0;
		int rightmax = nums.length - 1;
		int i = 1;

		while (leftmin < rightmax && i < rightmax) {

			if (nums[leftmin] < nums[i]) {

				if (nums[i] < nums[rightmax]) {
					System.out.println("left " + nums[leftmin] + " i " + nums[i] + " right " + nums[rightmax]);
					return true;
				} else if ((i + 1 < nums.length) && nums[i] >= nums[i + 1]) {
					System.out.println("i " + i);
					i++;
				} else {

					rightmax--;
					System.out.println("i " + i + " right " + rightmax);

				}
			} else {
				leftmin = i;
				i++;
				System.out.println("i " + i + " left " + leftmin);

			}
		}

		return false;
	}
}
