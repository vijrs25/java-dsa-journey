package array;

import java.math.BigInteger;

public class BigNumberFact {

	/*
	 * Input: 100 Output: 933262154439441526816992388562667004-
	 * 907159682643816214685929638952175999- 932299156089414639761565182862536979-
	 * 208272237582511852109168640000000000- 00000000000000
	 * 
	 * Input: 50 Output: 3041409320171337804361260816606476884-
	 * 4377641568960512000000000000
	 */
	public static void main(String[] args) {
		
		Bigfactorial(100);
		SimpleDiv(100);
	}
	public static void Bigfactorial(int n) {
		
		BigInteger f = new BigInteger("1");
		for (int i = 1; i < n; i++) {
			f= f.multiply(BigInteger.valueOf(i));
		}
		System.out.println(f);
	}
	
	private static void SimpleDiv(int n) {
		int[] arr = new int[500];
		arr[0]=1;	
		int rs = 1;
		
		for (int x = 2; x <= n; x++) {
			rs = multipy(x, arr, rs);
		}
		
		System.out.println("rs "+rs+" arr.length "+arr.length);
		for (int i =rs-1; i >=0; i--) {
			   System.out.print(arr[i]);
		}
		
	}
	
	private static int multipy(int x, int[] arr, int rs) {
		int carry = 0;
		
		for (int i = 0; i < rs; i++) {  // eg: 0,2,1 * 6 ==> 0 2 7 inside array it is 0,2,7 ,0,0,0,0 ..... 500 indexes
			int prod = arr[i]*x+carry;
			arr[i] = prod %10;
			carry = prod / 10;
		}
		
		while(carry !=0 ) {
			arr[rs]= carry % 10;
			carry = carry/10;
			rs++;
		}
		return rs;
	}

}
