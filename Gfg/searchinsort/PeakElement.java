package searchinsort;

public class PeakElement {

	public static void main(String[] args) {

		int[] arr = { 10, 20, 15, 2, 23, 90, 80 };
		
		for (int i = 1; i < arr.length-1; i++) {
			if (arr[i-1] < arr[i] && arr[i]  >  arr[i+1]) {
				System.out.println(arr[i]);
			}
		}
	}
}
