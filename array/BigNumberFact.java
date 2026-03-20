package array;

import java.math.BigInteger;

public class BigNumberFact {


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
	
	private static void SimpleDiv(int i) {
		// TODO Auto-generated method stub
		
	}

}
