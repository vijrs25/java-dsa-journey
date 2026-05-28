package string;

public class LongestSubstringwoRepeating01 {

	/*
	 * Input: s = "geeksforgeeks" Output: 7 Explanation: The longest substrings
	 * without repeating characters are "eksforg” and "ksforge", with lengths of 7.
	 */
	public static void main(String[] args) {
//error after run two solutions
		String s = "geeksforgeeks";
		System.out.println(bFlongestUniqueSubstr(s));
		System.out.println(twoPointerLR(s));
		System.out.println(twoPointerStartEnd(s));
	}

	private static String twoPointerStartEnd(String s) {

		int start = 0;
		int res = 0;
		String str = "";
		int[] ch = new int[255];

		for (int i = 0; i < ch.length; i++) {
			ch[i] = -1;
		}

		for (int end = 0; end < s.length(); end++) {
			start = Math.max(start, ch[s.charAt(end) - 'a'] + 1);

			res = Math.max(res, end - start + 1);
			str = s.substring(start, end + 1);
			System.out.println(str);

			ch[s.charAt(end) - 'a'] = end;
		}

		return str;
	}

	private static String bFlongestUniqueSubstr(String s) {
		String str = "";
		String longStr = "";
		for (int i = 0; i < s.length(); i++) {
			for (int j = i; j < s.length(); j++) {
				str = s.substring(i, j + 1);

				if (iSASubstring(str)) {
					longStr = str.length() > longStr.length() ? str : longStr;
				}

			}
		}
		System.out.println(longStr.length());
		return longStr;
	}

	private static boolean iSASubstring(String s) {
		char[] a = new char[255];
		for (int i = 0; i < s.length(); i++) {
			a[s.charAt(i) - 'a']++;
		}

		for (int i = 0; i < a.length; i++) {
			if (a[i] > 1) {
				return false;
			}
		}
		return true;
	}

// Two pointer
	private static String twoPointerLR(String s) {
		int l = 0;
		int r = 0;
		String longst = "";
		boolean ch[] = new boolean[255];
		while (r < s.length()) {
			while (ch[s.charAt(r) - 'a'] == true) {
				ch[s.charAt(l) - 'a'] = false;
				l++;
			}

			ch[s.charAt(r) - 'a'] = true;
//	longst = longst.length() < (r - l + 1) ? s.substring(l, r + 1) : longst;

			if (r - l + 1 > longst.length()) {
				longst = s.substring(l, r + 1);
			}
			r++;
		}
		System.out.println(longst);
		return longst;
	}

}
