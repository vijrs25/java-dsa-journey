package searchinsort.sorting;

public class MergeSort {
public static void main(String[] args) {
	  int arr[] = {38, 27, 43, 10};
      
      mergeSort(arr, 0, arr.length - 1);
      
      int n = arr.length;
      for (int i = 0; i < n; ++i)
          System.out.print(arr[i] + " ");
      System.out.println();
  }

private static void mergeSort(int[] arr, int l, int r) {
	 
	if(l<r) {
	int m = l + (r-l)/2;
	
	mergeSort(arr, l, m);
	mergeSort(arr, m+1, r);
	
	merge(arr, l ,m ,r);
	}
}

private static void merge(int[] arr, int le, int m, int ri) {
	
		
		int n1 = m-le+1;
		int n2= ri-m;
	
		int[] l = new int[n1];
		int[] r =  new int[n2];
			
		for (int i = 0; i < n1; i++) {
			l[i]= arr[le+i];
		}
		
		for (int i = 0; i < n2; i++) {
			r[i]= arr[m+1+i];
		}
		
		int i=0;
		int j = 0;
		int k=le;
		
		while(i<n1 && j< n2) {
			if(l[i]<=r[j]) {
				arr[k] =l[i];
				i++;
			}
			else {
				arr[k] = r[j];
				j++;
			}
			k++;
		}
		
		  while (i < n1) {
	            arr[k] = l[i];
	            i++;
	            k++;
	        }

	        // Copy remaining elements of R[] if any
	        while (j < n2) {
	            arr[k] = r[j];
	            j++;
	            k++;
	        }

}
}