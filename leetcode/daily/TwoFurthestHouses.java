package leetcode.daily;

public class TwoFurthestHouses {

	public static void main(String[] args) {
		int[] arr = { 1, 1, 1, 6, 1, 1, 1, 1, 6, 5, 4, 3, 3, 3 };

		int res = maxColor(arr);
		System.out.println(res);
	}

	private static int maxColor(int[] arr) {

		int left = 0;
		int right = 0;
		int max = 0;
		int index = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] == arr[i + 1]) {
				right++; // if current maches next increment
			} else {
				left = right; // if not matches then left = right and then
			}

			if (right - left + 1 > max) {
				max = right - left + 1;
				index = i;
			}

		}
		System.out.println("element " + arr[index]);
		return max;
	}

}
