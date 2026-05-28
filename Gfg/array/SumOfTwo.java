package array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// https://www.geeksforgeeks.org/dsa/check-if-pair-with-given-sum-exists-in-array/
// Input: arr[] = [0, -1, 2, -3, 1], target = -2
// Output: true
// Explanation: There is a pair (1, -3) with the sum equal to given target, 1 + (-3) = -2.

public class SumOfTwo {

	// bruteForce
	public static boolean bruteForce(int[] arr, int target) {

		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] + arr[j] == target) {
					System.out.println(arr[i] + " " + arr[j]);
					return true;
				}
			}
		}
		return false;

	}

	// Binary search
	public static boolean binarySearch(int[] arr, int target) {
		Arrays.sort(arr);

		int complement;
		int left, right, mid;
		int n = arr.length;

		for (int i = 0; i < arr.length; i++) {
			complement = target - arr[i];

			left = i + 1;
			right = n - 1;

			while (left <= right) {
				mid = left + (right - left) / 2;

				System.out.println("arr[mid]  " + arr[mid]);
				Arrays.stream(arr).forEach(x -> System.out.print(x + " "));
				System.out.println();
				if (arr[mid] == complement) {
					System.out.println(arr[mid]);

					return true;
				} else if (arr[mid] < complement) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}

			}
		}
		return false;
	}

	// Two pointer
	public static boolean twoPointer(int arr[], int target) {
		Arrays.sort(arr);
		int l = 0;
		int r = arr.length - 1;

		while (l < r) {
			Arrays.stream(arr).forEach(x -> System.out.print(x + " "));
			System.out.println(" l " + l + " r " + r + " " + (arr[l] + arr[r]));
			if ((arr[l] + arr[r]) == target) {
				System.out.println(arr[l] + " " + arr[r]);
				return true;
			}
			if (arr[l] + arr[r] < target)
				l++;
			else
				r--;
		}
		return false;
	}

	// HashSet
	public static boolean hashSetMeth(int arr[], int target) {
		Set<Integer> hs = new HashSet<>();
		int com;
		for (int i = 0; i < arr.length; i++) {
			com = target - arr[i];
			if (hs.contains(com)) {
				System.out.println(arr[i]);
				return true;
			}
			hs.add(arr[i]);
		}
		return false;
	}

	public static void main(String[] args) {

		int arr[] = { 1, 2, -3, 4, 5, 6, 7, 1 }; // use of {} insted of []
		int target = 2;
		System.out.println(bruteForce(arr, target));
		System.out.println(binarySearch(arr, target));
		System.out.println(hashSetMeth(arr, target));
		System.out.println(twoPointer(arr, target));
	}
}
