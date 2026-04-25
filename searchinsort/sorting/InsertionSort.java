package searchinsort.sorting;

public class InsertionSort {

	public static void main(String[] args) {
		int arr[] = { 5, 6, 1, 3, 7, 2, 31, 12, 11 };
		int n = arr.length;
		int[] resDec, resInc;

		resDec = insertionSort(arr);

		for (int i = 0; i < resDec.length; i++) {
			System.out.println(resDec[i]);
		}
		
		resInc = insertionSortDec(arr);
		for (int i = 0; i < resInc.length; i++) {
			System.out.println(resInc[i]);
		}
		
	}

	private static int[] insertionSort(int[] arr) {
		int n = arr.length;

		for (int i = 1; i < n; ++i) {
			int key = arr[i];
			System.out.println("key "+key);
			int j = i - 1;

			/*
			 * Move elements of arr[0..i-1], that are greater than key, to one position
			 * ahead of their current position
			 */
			while (j >= 0 && arr[j] > key) {
				System.out.println("arr[j] for j "+(j+1)+" is "+arr[j+1]);
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = key;
		}

		return arr;
	}
	
	private static int[] insertionSortDec(int[] arr) {
		int n = arr.length;

		for (int i = 1; i < n; ++i) {
			int key = arr[i];
			int j = i - 1;

			/*
			 * Move elements of arr[0..i-1], that are greater than key, to one position
			 * ahead of their current position
			 */
			while (j >= 0 && arr[j] < key) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = key;
		}

		return arr;
	}


}
