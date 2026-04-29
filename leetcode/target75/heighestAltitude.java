package leetcode.target75;

public class heighestAltitude {

	public static void main(String[] args) {
		int[] arr = { -4,-3,-2,-1,4,3,2 };
		int max = 0;
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum+= arr[i];
			max = Math.max(max, sum);
		}
		System.out.println(max);
		System.out.println(3/2);
	}

}
