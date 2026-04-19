package leetcode.daily;

public class SmallestStableIndex498 {

	public static void main(String[] args) {
		int[] nums = {1,3,2,1};
		
		 int[] ans = new int[2*nums.length];
	        for(int i = 0 ; i < nums.length ; i++){
	            ans[i] = nums[i];
	            ans[nums.length+i] = nums[i];
	        }
	        
	    for (int i = 0; i < ans.length; i++) {
			System.out.println(ans[i]);
		}    
		
		//int[] nums = {5,0,1,4};
		int k =3;
		int len = nums.length;
		
		
		// l , r
		// lmax rmax
		int left[] = new int[len];
		int right[] = new int[len];
		
		left[0]=nums[0];
		for (int i = 1; i < len; i++) {
			left[i] = Math.max(left[i-1], nums[i]);
		}	
		
		right[len-1] = nums[len-1];
		for (int i = len-2; i >= 0; i--) {
			right[i] = Math.min(right[i+1], nums[i]);   
		}
		
		for (int i = 0; i < len; i++) {
			if(left[i]-right[i]<=k) {
			//	System.out.println(i);
				
			}
		}
	}

}
