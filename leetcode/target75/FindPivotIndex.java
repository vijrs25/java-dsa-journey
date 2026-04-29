package leetcode.target75;

public class FindPivotIndex {

	public static void main(String[] args) {
		int[] arr = { 2,-1,1 };
		int res = pivotIndex(arr);
		System.out.println(res);
	}

	private static int pivotIndex(int[] arr) {
		int total = 0;
		int sum = 0;
		int left[] = new int[arr.length];
		int right[] = new int[arr.length];
		
		left[0] = 0;
		for (int i = 1; i < arr.length; i++) {
			left[i] = left[i-1]+arr[i-1];
		}
		
		right[arr.length-1] = 0;
		for (int i = arr.length-2; i >= 0; i--) {
			right[i] = right[i+1]+arr[i+1];
		}
			
		for (int i = 0; i < arr.length; i++) {
			if(left[i] == right[i]) {
				return i;
			}
		}
		return -1;
	}
}
