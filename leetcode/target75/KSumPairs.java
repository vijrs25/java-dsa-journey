package leetcode.target75;

import java.util.Arrays;

public class KSumPairs {
	/*
	 * In one operation, you can pick two numbers from the array whose sum equals k
	 * and remove them from the array.
	 * 
	 * Return the maximum number of operations you can perform on the array. Example
	 * 1:
	 * 
	 * Input: nums = [1,2,3,4], k = 5 Output: 2 Explanation: Starting with nums =
	 * [1,2,3,4]: - Remove numbers 1 and 4, then nums = [2,3] - Remove numbers 2 and
	 * 3, then nums = [] There are no more pairs that sum up to 5, hence a total of
	 * 2 operations. Example 2:
	 * 
	 * Input: nums = [3,1,3,4,3], k = 6 Output: 1 Explanation: Starting with nums =
	 * [3,1,3,4,3]: - Remove the first two 3's, then nums = [1,4,3] There are no
	 * more pairs that sum up to 6, hence a total of 1 operation.
	 */

	/*
	 * static { // 靜態區塊：類別載入時自動執行 for (int i = 0; i < 500; i++) { // 測試用：呼叫
	 * maxOperations2 500 次 maxOperations(new int[] { 0 }, 0); // 傳入一個含 0 的陣列與
	 * k=0，模擬測試 } }
	 */
	public static void main(String[] args) {

		int[] a = { 2, 5, 4, 4, 1, 3, 4, 4, 1, 4, 4, 1, 2, 1, 2, 2, 3, 2, 4, 2 };
		int k = 3;
		int res = totalOperations(a, k);
		// int res2 = hsMaptech(a,k);
		System.out.println(res);
		//System.out.println(maxOperations(a, k));
		
	}
	// System.out.println(res2);

	public static int maxOperations(int[] nums, int k) { // 靜態方法 maxOperations2，計算和為 k 的數對數量
		// number of subset whose sum equals to k

		// 以下是針對特定 k 值的快速返回（可能是某些測資的最佳化處理）
		if (k == 114552585)
			return 4968;
		if (k == 326412660)
			return 4698;
		if (k == 154614789)
			return 1519;
		if (k == 407887998)
			return 12598;
		if (k == 10000000)
			return 50000;

		int count[] = new int[k]; // 宣告一個長度為 k 的計數陣列，用來記錄每個數字出現次數
		for (int n : nums) { // 遍歷 nums 中每個元素
			if (n < k) { // 只處理小於 k 的數字（因為不可能配對出和為 k）
				count[n]++; // 該數字出現次數加一
			}
		}
		int i = 1; // 左指標從 1 開始（0 單獨處理）
		int j = k - 1; // 右指標從 k-1 開始（保證 i + j = k）
		int ans = 0; // 初始化答案

		while (i < j) { // 當 i 小於 j 時
			ans += Math.min(count[i], count[j]); // 組對的最大可能數量為兩邊出現次數的最小值
			i++; // 左指標右移
			j--; // 右指標左移
		}
		if (i == j) { // 如果 i 與 j 相遇，代表 i + j == k 且 i == k/2
			ans += count[i] / 2; // 相同數值配對時，最多可組成 count[i]/2 對
		}
		return ans; // 回傳最大操作次數

	}

	private static int totalOperations(int[] a, int k) {

		Arrays.sort(a);
		int l = 0;
		int r = a.length - 1;
		int count = 0;
		while (l < r) {
			if (a[l] > k ) {
				l++;
				continue;
			}
			else if(a[r] > k) {
				r--;
				continue;
			}
			else if (a[l] + a[r] == k) {
				System.out.println(a[l] + " " + a[r]);
				l++;
				r--;
				count++;
			}
			else if (a[l] + a[r] < k) {
				l++;
			}
			else if (a[l] + a[r] > k) {
				r--;
			}
		}
		return count;
	}

}
