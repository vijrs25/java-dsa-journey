package string;

public class smallesWindowContainAllChar {

	public static void main(String[] args) {
		String s = "timetopractice";
		String p = "toc";

		System.out.println(s);
		String result = minWindow(s, p);
		System.out.println(result);
		if (!result.isEmpty())
			System.out.println(result);
		else
			System.out.println("");
	}

	private static String minWindow(String s, String p) {
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
