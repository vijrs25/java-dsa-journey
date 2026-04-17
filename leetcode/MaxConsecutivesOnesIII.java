package leetcode;

public class MaxConsecutivesOnesIII {
	/*
	 * Given a binary array nums and an integer k, return the maximum number of
	 * consecutive 1's in the array if you can flip at most k 0's. Example 1: Input:
	 * nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2 Output: 6 Explanation:
	 * [1,1,1,0,0,1,1,1,1,1,1] Bolded numbers were flipped from 0 to 1. The longest
	 * subarray is underlined. Example 2:
	 * 
	 * Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3 Output: 10
	 * Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1] Bolded numbers were
	 * flipped from 0 to 1. The longest subarray is underlined.
	 */
	public static void main(String[] args) {

		int[] nums = { 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 0,0,0, 1, 1 };
		int k = 3;

		        int left = 0;
		        int zeroCount = 0;
		        int maxLength = 0;

		        for (int right = 0; right < nums.length; right++) {
		            // Agar current element 0 hai to zeroCount badhao
		            if (nums[right] == 0) {
		                zeroCount++;
		                System.out.println("right "+right+" zeroCount "+zeroCount);
		            }

		            // Agar zeroCount k se zyada ho gaya, window shrink karo
		            while (zeroCount > k) {
		                if (nums[left] == 0) {
		                    zeroCount--;
		                    
		                }
		                left++;
		                System.out.println("left "+left);
		            }

		            // Valid window ka length nikaalo
		            
		            maxLength = Math.max(maxLength, right - left + 1);
		            System.out.println("ml "+maxLength+ " right "+right+" left "+left);
		        }

		        System.out.println(maxLength);
		    }	

}
