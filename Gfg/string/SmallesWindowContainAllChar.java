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

	    System.out.println("Input String (s): " + s);
	    System.out.println("Pattern (p): " + p);

	    if (l1 < l2) {
	        System.out.println("Pattern length is greater than string. Returning empty string.");
	        return "";
	    }

	    int[] sch = new int[256];  // Frequency of characters in current window
	    int[] pch = new int[256];  // Frequency of characters in pattern

	    // Step 1: Store frequency of pattern characters
	    System.out.println("\n--- Step 1: Building Pattern Frequency Map ---");
	    for (int i = 0; i < p.length(); i++) {
	        pch[p.charAt(i)]++;
	        System.out.println("pch['" + p.charAt(i) + "'] = " + pch[p.charAt(i)]);
	    }

	    int start = 0;      // Left pointer of window
	    int sind = -1;     // Starting index of minimum window
	    int mxlen = Integer.MAX_VALUE;
	    int count = 0;     // Number of matched characters

	    System.out.println("\n--- Step 2: Expanding Sliding Window ---");

	    for (int j = 0; j < s.length(); j++) {
	        char currentchar = s.charAt(j);
	        sch[currentchar]++;

	        System.out.println("\n[EXPAND] j = " + j + 
	                           ", currentchar = '" + currentchar + "'" +
	                           ", sch['" + currentchar + "'] = " + sch[currentchar]);

	        // Step 3: Match characters
	        if (pch[currentchar] > 0 && sch[currentchar] <= pch[currentchar]) {
	            count++;
	            System.out.println("[MATCH] count increased to: " + count);
	        }

	        // Step 4: When all characters are matched, try shrinking the window
	        if (count == p.length()) {
	            System.out.println("[VALID WINDOW] All pattern characters matched.");

	            char startchar;

	            // Shrink the window from the left
	            while (sch[startchar = s.charAt(start)] > pch[startchar] || pch[startchar] == 0) {
	                System.out.println("[SHRINK] Trying to remove character '" + startchar + "' at index " + start);

	                if (sch[startchar] > pch[startchar]) {
	                    sch[startchar]--;
	                    System.out.println("Reduced sch['" + startchar + "'] to " + sch[startchar]);
	                }
	                start++;
	                System.out.println("Moved start to index: " + start);
	            }

	            // Step 5: Update minimum window
	            int len = j - start + 1;
	            System.out.println("[WINDOW] Current valid window: " + s.substring(start, j + 1) +
	                               " | Length = " + len);

	            if (mxlen > len) {
	                mxlen = len;
	                sind = start;
	                System.out.println("[UPDATE] New minimum window found at index " +
	                                   sind + " with length " + mxlen);
	            }
	        }
	    }

	    // Step 6: Return result
	    if (sind == -1) {
	        System.out.println("\nNo valid window found.");
	        return "";
	    }

	    String result = s.substring(sind, sind + mxlen);
	    System.out.println("\n--- Final Result ---");
	    System.out.println("Minimum Window Substring: " + result);
	    return result;
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
