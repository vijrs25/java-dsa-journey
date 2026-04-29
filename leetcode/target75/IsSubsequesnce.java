package leetcode.target75;

/*A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
Example 1:
Input: s = "abc", t = "ahbgdc"
Output: true

Example 2:
Input: s = "axc", t = "ahbgdc"
Output: false*/
public class IsSubsequesnce {
	
	public static void main(String[] args) {
	String s = "a";
	String t = "ahcbgd";
	
	System.out.println(isSubsequence(s,t));
	
	}

	private static boolean isSubsequence(String s, String t) {
		char[] ch = t.toCharArray();
		int count =s.length();
		int index=0;
		for (int i = 0; i < ch.length; i++) {
			if(count>index && ch[i]==s.charAt(index)) {
				System.out.println(ch[i]+" "+s.charAt(index));
				index++;
			}
		}
		if(index==count)
			return true;
		
		return false;
	}

}
