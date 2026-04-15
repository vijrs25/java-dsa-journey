package leetcode;

public class MaxConsecutivesOnesIII {
	/*
	 * Given a binary array nums and an integer k, return the maximum number of
	 * consecutive 1's in the array if you can flip at most k 0's.
	 * Example 1:
	 * Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2 Output: 6 Explanation:
	 * [1,1,1,0,0,1,1,1,1,1,1] Bolded numbers were flipped from 0 to 1. The longest
	 * subarray is underlined. Example 2:
	 * 
	 * oneCount to keep total check
	 * zero count to keep k
	 * if(q)
	 * 
	 * Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3 Output: 10
	 * Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1] Bolded numbers were
	 * flipped from 0 to 1. The longest subarray is underlined.
	 */  
	public static void main(String[] args) {
		 
		int[] nums = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
		int  k =3;
		int count=0;
		int i=0;
		int totalcount=0;
		while(i)
		while(count<k) {
			if(nums[i]==0) {
				i++;
				count++;
			}
			else if(nums[i]==1) {
				i++;
			}
			totalcount=i;
		}
		System.out.println("i "+i +" count "+count );

	}

}
