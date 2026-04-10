package string;

public class SmallesWindowContainAllChar {

	public static void main(String[] args) {
		String s = "timetopractioce";
		String p = "toc";

		System.out.println(s);
		String result = minWindowBF(s, p);
		String result1 = minWindowEx(s, p);
		System.out.println(result1);

	}

	private static String minWindowEx(String s, String p) {
		int l1 = s.length();
		int l2 = p.length();

		if (l1 < l2) {
			return "";
		}

		int[] sch = new int[255];
		int[] pch = new int[255];

		for (int i = 0; i < p.length(); i++) {
			pch[p.charAt(i)]++;
		}
		int start = 0;
		int sind = -1;
		int mxlen = Integer.MAX_VALUE;
		int count = 0;
		for (int j = 0; j < s.length(); j++) {
			char currentchar = s.charAt(j);
			sch[currentchar]++;
			
			//1st if Match → 2nd if Validate → 3rd if Shrink
			if (pch[currentchar] > 0 && pch[currentchar] >= sch[currentchar]) {
				count++;
			}

			if (count == p.length()) {
				char startchar;
				while (sch[startchar = s.charAt(start)] > pch[startchar] || pch[startchar] == 0) {
					if (sch[startchar] > pch[startchar]) {
						sch[startchar]--;
					}
					start++;
				}
			

			int len = j - start + 1;
			if (mxlen > len) {
				mxlen = len;
				sind = start;
			}
			}
		}
		
		return s.substring(sind, sind+mxlen);
	}

	private static String minWindowBF(String s, String p) {
		String minLen = s;
		String str;

		for (int i = 0; i < s.length(); i++) {
			for (int j = i; j < s.length(); j++) {

				str = s.substring(i, j + 1);
				if (hasAllChar(str, p)) {
					if (str.length() < minLen.length()) {
						minLen = str;
					}
				}
			}
		}
		return minLen;
	}

	private static boolean hasAllChar(String s, String p) {
		int ch[] = new int[255];

		for (int k = 0; k < p.length(); k++) {
			ch[p.charAt(k) - 'a']++;
		}

		for (int k = 0; k < s.length(); k++) {
			ch[s.charAt(k) - 'a']--;
		}

		for (int k = 0; k < ch.length; k++) {
			if (ch[k] > 0) {
				return false;
			}
		}
		return true;
	}

}
