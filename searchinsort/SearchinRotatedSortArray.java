package searchinsort;

import java.util.HashMap;

public class SearchinRotatedSortArray {
//
//	Input: arr[] = [5, 6, 7, 8, 9, 10, 1, 2, 3], key = 3
//			Output: 8
//			Explanation: 3 is found at index 8.
	public static void main(String[] args) {
		int[] arr = { 5, 6, 7, 8, 9, 10, 1, 2, 3 };
		int k = 2;
		// System.out.println(indexOfKey(arr, k));

		for (int i = 0; i < arr.length; i++) {
			System.out.print("__" + i);
		}
		System.out.println();
		for (int i = 0; i < arr.length; i++) {
			System.out.print("__" + arr[i]);
		}
		System.out.println(indexOfKeyBinary(arr, k));
	}

	// O(n) + O(n space)
	@SuppressWarnings("unused")
	private static int indexOfKey(int[] arr, int k) {
		HashMap<Integer, Integer> hm = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			hm.put(arr[i], i);
		}
		return hm.get(k) == null ? -1 : hm.get(k);
	}

	private static int indexOfKeyBinary(int arr[], int key) {
		int l = 0;
		int r = arr.length - 1;

		while (l <= r) {
			System.out.println(" In while ");
			int mid = l + (r - l) / 2;
			System.out.println("mid " + mid);
			if (arr[mid] == key)
				return mid;
			if (arr[l] <= arr[mid]) {
				System.out.println("left sorted");
				if (key < arr[mid] && key >= arr[l]) {
					{
						r = mid - 1;
						System.out.println("LS r " + r);
					}
				} else {
					l = mid + 1;
					System.out.println("RS l " + l);
				}

			} else {
				if (key > arr[mid] && key <= arr[r]) {
					l = mid + 1;
				} else
					r = mid - 1;

			}
		}
		return -1;
	}
}