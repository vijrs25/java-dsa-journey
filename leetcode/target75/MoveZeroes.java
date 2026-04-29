package leetcode.target75;

import java.util.Arrays;
//283. Move Zeroes
//Solved
//Easy
//Topics
//premium lock icon
//Companies
//Hint
//Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
//
//Note that you must do this in-place without making a copy of the array.

public class MoveZeroes {

	public static void main(String[] args) {
		int[] nums = {0,1,0,3,12};
		
		int[] res = moveZeroes(nums);
	}

	private static int[] moveZeroes(int[] nums) {
		int[] res = new int[nums.length];
		Arrays.fill(res, 0);
		int i=0;
		for(int num: nums) {
			if(num!=0) {
				res[i]=num;
				i++;
			}
		}
		System.out.print("[");
		for (int j = 0; j < res.length-1; j++) {
			System.out.print(res[j]+",");	
		}
		System.out.print(res[res.length-1]+"]");
		return res;
	}

}
