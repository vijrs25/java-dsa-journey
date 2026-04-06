
public class Test {

	public static void main(String[] args) {
		
	String a = "abcd";
	String b = "pqrssr";
	
	String res = mergeOfTwoArrays(a,b);
	System.out.println(res);
	}
	
	private static String mergeOfTwoArrays(String a, String b) {
		int minOfab = Math.min(a.length(), b.length());
		String minString = minOfab == a.length()?a:b;
		int count = 0;
		StringBuilder s = new StringBuilder();
		while(count/2<minOfab);
		{
			if(count%2 == 0) {
				System.out.println("while");
				s.append(a.charAt(count/2));
				count++;
			}
			else {
				s.append(a.charAt(count/2));
				count++;
			}
		}
		
		s.append(minString.substring(count/2));
		return s.toString();
	}}
