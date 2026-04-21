package leetcode.daily;

public class Test {

	public static void main(String[] args) {
		int[] nums = { 2, 5, 1, 3, 4, 7 };
		int n = 3;
		int count = 0;
		int[] newA = new int[2 * n];
		
		for (int i = 0; i < 2*n; i+=2) {
			newA[i] = nums[count];
			newA[i+1] = nums[n + count];
			count++;
		}

		for (int i = 0; i < newA.length; i++) {
			//System.out.println(newA[i]);
		}
		
		int[] numa= {1,1,1,0,1,1,1,1,1,0,1,1,1,1,1,1};
		int resmax = 0;
		int max=0;
		for (int i = 0; i < numa.length; i++) {
			if(numa[i]==1) {
				resmax++;
				System.out.println("resmax "+resmax);
			}
			else if(numa[i]==0){
			max = Math.max(max, resmax);
			resmax = 0;
			}
			
		   
		}
		System.out.println(max);
	}

}
