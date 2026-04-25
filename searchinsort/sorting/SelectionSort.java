package searchinsort.sorting;

public class SelectionSort {

	public static void main(String[] args) {
		int arr[] = { 5, 6, 1, 3, 7, 2, 31, 12, 11 };
		int n = arr.length;
		int[] res;

		res = selectionSort(arr);

		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i]);
		}
	}

	private static int[] selectionSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int minIdx = i;
			
			for (int j = i+1; j < arr.length; j++) {
				if(arr[j] <arr[minIdx]) {
					minIdx = j;
				} 
			}
			 int temp = arr[i];
	            arr[i] = arr[minIdx];
	            arr[minIdx] = temp;    
		}
		return arr;
	}
}
