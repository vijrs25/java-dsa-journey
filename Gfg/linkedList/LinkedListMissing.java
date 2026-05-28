package linkedList;

public class LinkedListMissing {
	// Input: arr[] = [3, 5, 9, 10, 11, 12], k = 2

	public static void main(String[] args) {

		//int arr[] = { 1, 2, 3, 4 };
		int arr[] = {2,3, 4,7, 11, 12};
		int k = 5;
**
		System.out.println(arrayCountFast(arr, k));
		//System.out.println(arrayCount(arr, k));

	}

	public static int arrayCountFast(int[] arr, int k) {
		// We must perform binary search on the INDICES of the array
		int left = 0;
		int right = arr.length - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;
			System.out.println("mid " + mid +" arr[mid] " +arr[mid]);
			// Calculate how many numbers are missing before index 'mid'
			int missing = arr[mid] - (mid + 1);
			System.out.println("missing " + missing);
			if (missing < k) {
				// We need more missing numbers, look in the right half
				left = mid + 1;
				System.out.println("left " + left);
			} else {
				// We have enough or too many missing numbers, look in the left half
				right = mid - 1;
				System.out.println("right " + right);
			}
			System.out.println("left and right "+left+" "+right);
			System.out.println();
		}

		// After the loop, 'left' is the smallest index such that
		// the number of missing elements is at least k.
		// The formula simplifies to left + k.
		return left + k;

	}

	public static int arrayCount(int[] arr, int k) {
		int limit = arr.length;
		System.out.println("limit 2nd arr " + limit);

		int arrCount = 0;
		int finalArrayLen = k;

		for (int i = 1; i <= arr[limit - 1] + finalArrayLen; i++) {
			if (arrCount < limit && arr[arrCount] == i) {
				arrCount++;
			} else if (k == 1) {
				return i;
			} else {
				k--;
			}
		}
		return 0;
	}

}
