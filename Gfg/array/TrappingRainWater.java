package array;

import java.util.Iterator;
import java.util.Stack;

public class TrappingRainWater {
	/*
	 * l =0 r 6 
	 * lm = 3 rm = 2
	 * lm > rm
	 * total = total+ rm - arr[r] r--
	 * Rm = Math.max(Rm,arr[r])
	 * Input: arr[] = [3, 0, 1, 0, 4, 0, 2] Output: 10 Explanation: The expected
	 * rainwater to be trapped is shown in the above image.
	 * 
	 * Input: arr[] = [3, 0, 2, 0, 4] Output: 7 Explanation: We trap 0 + 3 + 1 + 3 +
	 * 0 = 7 units.
	 * 
	 * Input: arr[] = [1, 2, 3, 4] Output: 0 Explanation: We cannot trap water as
	 * there is no height bound on both sides
	 */
	public static void main(String[] args) {
		
		  int[] arr = {2, 1, 5, 3, 1, 0, 4};
	        System.out.println(BruteForce(arr));
	        System.out.println(priSuff(arr));
	        System.out.println(Using_Two_Pointers(arr));
	        System.out.println(stackArr(arr));
	        
	}

	private static int BruteForce(int[] arr) {
		
		int left=0;
		int right=0;
		int totalvol = 0;
		
		for (int i = 0; i < arr.length; i++) { // left of 1 =3 right of 1 = 4
			left=arr[i];
			for (int j = 0; j < i; j++) { 
				left= Math.max(left, arr[j]);
			}
			
			right=arr[i];
			for (int j = arr.length-1; j >i; j--) {
				right= Math.max(right, arr[j]);
			}
			
			totalvol+= Math.min(right, left) -arr[i];
		}
		
		return totalvol;
	}
	
	private static int priSuff(int[] arr) {
		int[] pre = new int[arr.length];
		int[] suff = new int[arr.length];
		int[] res = new int[arr.length];
		int totavol=0;
		
		pre[0]=arr[0];
		for (int i = 1; i < pre.length; i++) {
		pre[i]= Math.max(pre[i-1], arr[i]);	
		}
		
		
		suff[arr.length -1]=arr[arr.length-1];
		for (int i = arr.length-2; i>=0; i--) {
			suff[i] = Math.max(suff[i+1], arr[i]);
		}
		
		for (int i = 0; i < res.length; i++) {
			totavol+=Math.min(pre[i], suff[i])-arr[i];
		}
		return totavol;
	}
	
	private static int Using_Two_Pointers(int[] arr) {
		int n = arr.length;
		int l = 0;
		int r= n-1;
		int Lm = arr[0];
		int Rm = arr[r];
		int total = 0;
		// 3, 0, 1, 0, 4, 0, 2
		// 3 , 2
		// 2-2 = 0
		// 3, 0
		// 2-0 = 2
		// 3, 4
		// 3 - 3 = 0
		// 0, 4 
		// 3 -0 = 3
		// 
		while (l<= r) {
			if(Lm<Rm) {
			  total+= Math.max(0, Lm-arr[l]);;
			  System.out.println("left "+Lm+" "+total);
			  Lm= Math.max(Lm, arr[l]);
			  l++;
			}
			else {
				total+= Math.max(0, Rm - arr[r]);
				System.out.println("right "+Rm+" "+total);
				Rm = Math.max(Rm, arr[r]);
				r--;
			}
		}
		return total;
	}
	
	public static int stackArr(int[] arr) {
		System.out.println();
		Stack<Integer> st = new Stack<>();
		int n = arr.length - 1;
	    int res=0;	
		for (int j = 0; j <= n; j++) {

			while (!st.isEmpty() && arr[st.peek()] < arr[j]) {
				
				int pop_height = arr[st.pop()];  //{2, 1, 5, 3, 1, 0, 4};
				if(st.isEmpty()) break;
				
				int distance = j- st.peek() -1;
				int water =Math.min(arr[st.peek()], arr[j]);
				water-=pop_height;
				res += distance*water;
				System.out.println(distance* water);
			}
			st.push(j);
			 for(Integer i : st) {
				 System.out.print(i+" ");
			 }
			 System.out.println();
			
	}
		return res;
	}

}
