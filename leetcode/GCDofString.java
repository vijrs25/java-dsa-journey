package leetcode;

public class GCDofString {

	public static void main(String[] args) {
		System.out.println(gcdOfStrings("ABCABCABCABC", "ABCABC"));
	}

	public static String gcdOfStrings(String str1, String str2) {

		// Step 1: Check if valid
		if (!(str1 + str2).equals(str2 + str1)) {
			return "";
		}

		// Step 2: Find GCD of lengths
		int gcdLength = gcd(str1.length(), str2.length());
		return str1.substring(0, gcdLength);
	}

		// Euclidean Algorithm
	private static int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a % b);
	}
}
