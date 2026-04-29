package leetcode.target75;

public class ProductofElements {
//	Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].   
//			The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.   
//			You must write an algorithm that runs in O(n) time and without using the division operation.   
//			 
//			Example 1: Input: nums = [1,2,3,4] Output: [24,12,8,6]   
//			Example 2: Input: nums = [-1,1,0,-3,3] Output: [0,0,9,0,0]
	public static void main(String[] args) {
		
		int[] nums  = {1,2,3,4};
	    //int[] nums  = {-1,1,0,-3,3};
		int[] resultant = productArray(nums);
		
//		int[] seats = {1,1,1,0,0,0,};
//		int  res= findtheDistance(seats); 
		
		for(int num: resultant) {
			System.out.print(num+" ");
		}
	}

	public static int[] productArray(int[] nums) {
		int[] pref =  new int[nums.length];
		int[] suff  = new int[nums.length];
		int[] res = new int[nums.length];
		
		pref[0]=1;
		for(int i=1; i<nums.length;i++) {
			pref[i]=pref[i-1]*nums[i-1];
		}
		
		suff[nums.length-1]=1;
		for(int i=nums.length-2; i>=0 ;i--) {
			suff[i]=suff[i+1]*nums[i+1];
		}
		
		for(int i=0; i<nums.length;i++) {
			res[i]=pref[i]* suff[i];
		}
		return res;
	}
	
	
	
	
//	Coding Test 1
//	Problem Statement & Context Tasks
//	How can you find and replace all occurrences of a substring in a string without using the built-in replace() method? Please also write the associated unit test  
//	Tasks
//	* Find all string replacement that matches with the subset of the words
//	* Replace that occurrence with the second parameter
//	
//	
//	Coding Test 2
//	Maximize distance from a person Use
//	LeetCode link to describe the problem  

}
