package array;

/*Input: prices[] = [7, 10, 1, 3, 6, 9, 2]
Output: 8
Explanation: Buy for price 1 and sell for price 9. 

Input: prices[] = [7, 6, 4, 3, 1]
Output: 0
Explanation: Since the array is sorted in decreasing order, 0 profit can be made without making any transaction.
*/
public class StockbuyAndSell {

	private static int bruteForce(int[] arr) {

		int maxPro = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (maxPro < arr[j] - arr[i]) {
					maxPro = arr[j] - arr[i];
				}
			}
		}
		return maxPro;
	}

	private static int oneTraversal(int[] arr) {
		
		int minSoFar=arr[0];
		int res = 0;
		
		for (int i = 1; i < arr.length; i++) {
			 minSoFar =  Math.min(minSoFar, arr[i]);
			 res =  Math.max(res, arr[i] - minSoFar);
		}
		return res;
	}
	public static void main(String[] args) {

		int prices[] = { 7,1};
		// Output = 18;
		System.out.println(bruteForce(prices));
		System.out.println(oneTraversal(prices));
	}

}
