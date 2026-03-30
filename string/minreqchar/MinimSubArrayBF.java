package string.minreqchar;

public class MinimSubArrayBF {
	
    public static void main(String[] args) {
        String s = "timetopractice";
        String p = "toc";

        String result = minWindow(s, p);

        if (!result.isEmpty())
            System.out.println(result);
        else
            System.out.println("");
    }
	
	   // Function to check if a substring contains
    // all characters of the pattern
    static boolean hasAllChars(String sub, String p) {
        int[] count = new int[256];

        // Count the frequency of each 
        // character in the pattern
        for (int i = 0; i < p.length(); i++) {
            count[p.charAt(i)]++;
        }

        // For each character in the substring, 
        // decrement its count
        for (int i = 0; i < sub.length(); i++) {
            if (count[sub.charAt(i)] > 0) //avaialble in the P
                count[sub.charAt(i)]--;
        }

        // If all counts in the count array are zero,
        // the substring contains all characters of the pattern
        for (int i = 0; i < 256; i++) {
            if (count[i] > 0)
                return false;
        }

        return true;
    }

    // Function to find the smallest substring 
    // containing all characters of the pattern
    static String minWindow(String s, String p) {
        int n = s.length();
        int minLen = Integer.MAX_VALUE;
        String res = "";

        // Generate all substrings 
        // of the given string
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                String sub = s.substring(i, j + 1);

                // Check if the substring contains 
                // all characters of the pattern
                if (hasAllChars(sub, p)) {
                    int currLen = sub.length();

                    // Update the result if the current
                    // substring is smaller
                    if (currLen < minLen) {
                        minLen = currLen;
                        res = sub;
                    }
                }
            }
        }

        return res;
    }
}


