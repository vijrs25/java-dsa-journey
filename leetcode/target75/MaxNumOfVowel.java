package leetcode.target75;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MaxNumOfVowel {
	/*
	 * Given a string s and an integer k, return the maximum number of vowel letters
	 * in any substring of s with length k.
	 * 
	 * Input: s = "abciiidef", k = 3 Output: 3 Explanation: The substring "iii"
	 * contains 3 vowel letters. Example 2:
	 * 
	 * Input: s = "aeiou", k = 2 Output: 2 Explanation: Any substring of length 2
	 * contains 2 vowels. Example 3:
	 * 
	 * Input: s = "leetcode", k = 3 Output: 2 Explanation: "lee", "eet" and "ode"
	 * contain 2 vowels.
	 */
	public static void main(String[] args) {
		String s = "aeiou";
		int k = 2;

		int res = getVowelCount(s, k);
		System.out.println(res);

	}

	private static int getVowelCount(String s, int k) {

		boolean[] ch = new boolean[26];
		ch['a'-'a'] = true;
		ch['e'-'a'] = true;
		ch['i'-'a'] = true;
		ch['o'-'a'] = true;
		ch['u'-'a'] = true;

		int count = 0;
		int maxcount = 0;
		char f = '_';
		char la = '_';

		for (int i = 0; i < k; i++) {
			if (ch[s.charAt(i)-'a']) {
				count++;
				maxcount = count;
			}
		}

		for (int i = k; i < s.length(); i++) {
			f = s.charAt(i - k);
			la = s.charAt(i);
			if (ch[la-'a'])
				count++;
			if (ch[f-'a']) {
				count--;
			}

			if (count > maxcount) {
				maxcount = count;
			}
		}

		return maxcount;
	}

}
