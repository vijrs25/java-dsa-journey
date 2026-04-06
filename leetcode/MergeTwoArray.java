package leetcode;

public class MergeTwoArray {
	public static void main(String[] args) {
		
	String a = "abcd";
	String b = "pq";
	
	String res = mergeOfTwoStrings(a,b);
	String res2 = mergeOfTwoStringsPoin(a, b);
	
	System.out.println(res);
	System.out.println(res2);
	}
	
	private static String mergeOfTwoStrings(String a, String b) {

		int minOfab = Math.min(a.length(), b.length());
		String maxString = minOfab == a.length()?b:a;
		int count = 0;
		StringBuilder s = new StringBuilder();
		
		while(count/2 < minOfab)
		{
			if(count%2 == 0) {
				s.append(a.charAt(count/2));
				count++;
			}
			else {
				s.append(b.charAt(count/2));
				count++;
			}
			
		}
		
		s.append(maxString.substring(count/2));
		return s.toString();
	}
	private static String mergeOfTwoStringsPoin(String a, String b) {
		int f=0;
		int s=0;
		String maxString = b.length() > a.length()?b:a;
		StringBuilder ns = new StringBuilder();
		for (int i = 0; i < maxString.length(); i++) {
			   if(f<a.length()) {
				   ns.append(a.charAt(f));
				   f++;
			   }
			   if(s<b.length()) {
				   ns.append(b.charAt(s));
				   s++;
			   }
		}
		
		return ns.toString();
		
	}
	
}
