package array;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		int[][] ar = {{1,2},{3,4},{55,3}};
		//System.out.println(ar[0][0]);
		//System.out.println(ar[1]);
		
		int[] s = {3,0,1};
		int n = s.length;
		Arrays.sort(s);
		for (int i = 0; i < s.length; i++) {
			if(i != s[i]) {
				System.out.println(i);
			}
		}
	}

}
