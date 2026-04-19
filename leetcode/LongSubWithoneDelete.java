package leetcode;

public class LongSubWithoneDelete {

	/*
	 * Input: nums = [1,1,0,1] Output: 3 Explanation: After deleting the number in
	 * position 2, [1,1,1] contains 3 numbers with value of 1's.
	 */ public static void main(String[] args) {

		int[] arr = { 0,1,1,1,0,1,1,0,1};
		System.out.println(maxSubCount(arr));
		System.out.println(maxSubCountLessMemory(arr));
	}

	private static int maxSubCount(int[] arr) {
		int max = 0;
		int left = 0;
		int right = 0;
		int zeroCount = 0;
		for (right = 0; right < arr.length; right++) {
			if (arr[right] == 0) {
				zeroCount++;
			}

			while (zeroCount > 1) {
				if (arr[left] == 0) {
					zeroCount--;
				}
				left++;
			}
			max = Math.max(max, right - left);
		}
		return max;
	}

	private static int maxSubCountLessMemory(int[] nums) {
		int l = 0;
		int ans = 0;
		int zeroIndex = -1;
		int zeroCount = 0;
		int r = 0;
		for (r = 0; r < nums.length; r++) {
			if (nums[r] == 0) {
				if (zeroCount == 0) {
					zeroCount++;
					zeroIndex = r;
					System.out.println("ZI "+zeroIndex);
				} else {
					ans = Math.max(ans, r - l);
					l = zeroIndex + 1;
					zeroIndex = r;
					System.out.println("ans "+ans+" l "+l+" zeroindex "+ zeroIndex);
				}
			}

		}

		ans = Math.max(ans, r - l);
		return ans - 1;
	}

}
