package leetcode.target75;

public class ContainerWIthMostWater {

	public static void main(String[] args) {
		int[] height = {1,8,6,2,5,4,8,3,7};
		
		int maxwater = maxWater(height);
		System.out.println(maxwater);
	}

	private static int maxWater(int[] height) {
		int l=0;
		int r = height.length-1;
		int res=0;
		int curr=0;
		while(l<r) {
			
				curr = Math.min(height[r], height[l])*(r-l);
				res = Math.max(res, curr);
				if(height[l]<height[r])
					l++;
				else
					r--;
		}
			
		return  res;
	}

}
