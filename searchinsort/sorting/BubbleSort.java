package searchinsort.sorting;

public class BubbleSort {

	public static void main(String[] args) {
		int arr[] = { 5, 6, 1, 3, 7, 2, 31, 12, 11 };
		int n = arr.length;
		int[] resDec, resInc;

		resDec = bubbleSortDec(arr);
		System.out.println("Array in decrement order");
		for (int i = 0; i < resDec.length; i++) {
			System.out.println(resDec[i]);
		}

		resInc = bubbleSortInc(arr);
		System.out.println();
		System.out.println("Array in Increment order");

		for (int i = 0; i < resInc.length; i++) {
			System.out.println(resInc[i]);
		}
	}

	static int[] bubbleSortDec(int[] arr) {
		int temp = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] < arr[j]) {
					temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}
		}
		return arr;
	}

	static int[] bubbleSortInc(int[] arr) {
		int temp = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}
		}
		return arr;
	}

}
