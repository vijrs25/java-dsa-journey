package leetcode;

public class MaxAveSubarray {
	/*
	 * Input: nums = [1,12,-5,-6,50,3], k = 4 Output: 12.75000 Explanation: Maximum
	 * average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75 Example 2:
	 * 
	 * Input: nums = [5], k = 1 Output: 5.00000
	 */
	public static void main(String[] args) {
		    int[] a = {0,1,1,3,3};
		    int n=4;
			//double res = maxAvg(a,n);
			double res2 = maxAvgFL(a,n);
			System.out.println(res2);
	}

	private static double maxAvgFL(int[] a, int n) {
		 double f = 0;
		 double l = 0;
		 double sum = 0;
		 double maxAvg = Integer.MIN_VALUE;
		 for (int i = 0; i < n; i++) {
			sum+= a[i];
			System.out.println("sum"+sum);
		}
		   maxAvg =sum/n;
		   System.out.println(maxAvg);
		 for (int i = n; i < a.length; i++) {
			 l= a[i];
			 f =a[i-n];	
			sum = sum -f +l;
			System.out.println("sum "+sum+" f "+f+ " L "+ l);
			maxAvg = Math.max(maxAvg, sum/n);
			System.out.println("maxAvg "+maxAvg);
			
		    }
		return maxAvg;
	}

	private static double maxAvg(int[] a, int n) {
		double maxRes = Integer.MIN_VALUE ;
		for (int i = 0; i <= a.length-n; i++) {
			maxRes = Math.max(maxRes, maxAvgVal(a,i,n+i));
		}
		return maxRes;
	}

	private static double maxAvgVal(int[] a, int start, int end) {
		double sum = 0;
		for (int i = start; i < end; i++) {
			sum += a[i];
		}
		return sum/(end-start);
	}

}
