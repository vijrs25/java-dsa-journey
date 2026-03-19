package string.minreqchar;

public class MinimumSubString {

    static boolean DEBUG = true;

    private static void log(String msg) {
        if (DEBUG) {
            System.out.println(msg);
        }
    }

    // Print only useful counts
    private static void printPatternState(String p, int[] count) {
        if (!DEBUG) return;

        System.out.print("    [COUNT STATE] ");
        boolean[] printed = new boolean[256];

        for (char ch : p.toCharArray()) {
            if (!printed[ch]) {
                System.out.print(ch + "=" + count[ch] + "  ");
                printed[ch] = true;
            }
        }
        System.out.println();
    }

    public static boolean isValid(String s, String p, int mid, int[] start) {
        log("\n==================================================");
        log("[CHECK] isValid called for mid = " + mid);
        log("==================================================");

        int[] count = new int[256];
        int distinct = 0;

        log("[BUILD] Building frequency of pattern p = \"" + p + "\"");

        // Count frequency of each character in p
        for (char x : p.toCharArray()) {
            if (count[x] == 0) {
                distinct++;
                log("    [BUILD] New distinct char found: '" + x + "', distinct = " + distinct);
            }
            count[x]++;
            log("    [BUILD] count['" + x + "'] = " + count[x]);
        }

        log("[INFO] Total distinct required chars = " + distinct);
        printPatternState(p, count);

        int currCount = 0;

        for (int i = 0; i < s.length(); i++) {
            char inChar = s.charAt(i);

            // Expand window
            count[inChar]--;
            log("\n[EXPAND] i = " + i + ", entering char = '" + inChar + "'");
            log("    count['" + inChar + "'] after decrement = " + count[inChar]);

            if (count[inChar] == 0) {
                currCount++;
                log("    [MATCH] Requirement for '" + inChar + "' fully satisfied.");
                log("    [MATCH] currCount = " + currCount);
            }

            // Shrink if window exceeds size mid
            if (i >= mid) {
                char outChar = s.charAt(i - mid);
                count[outChar]++;
                log("[SHRINK] Removing char = '" + outChar + "' from left");
                log("    count['" + outChar + "'] after increment = " + count[outChar]);

                if (count[outChar] == 1) {
                    currCount--;
                    log("    [UNMATCH] Requirement for '" + outChar + "' is broken.");
                    log("    [UNMATCH] currCount = " + currCount);
                }
            }

            // Print current window
            if (i >= mid -1) {
                int windowStart = i - mid + 1;
                String window = s.substring(windowStart, i+1 );

                log("[WINDOW] Current window = \"" + window + "\"  (start=" + windowStart + ", end=" + i + ")");
                log("    currCount = " + currCount + ", distinct = " + distinct);
                printPatternState(p, count);

                if (currCount == distinct) {
                    start[0] = windowStart;
                    log("[VALID] Valid window found at start = " + start[0] + ", window = \"" + window + "\"");
                    return true;
                }
            }
        }

        log("[FAIL] No valid window found for mid = " + mid);
        return false;
    }

    public static String minWindow(String s, String p) {
        int m = s.length();
        int n = p.length();

        if (m < n) return "";

        int minLength = Integer.MAX_VALUE;
        int low = n, high = m;
        int[] start = new int[1];
        int finalStart = -1;

        log("##################################################");
        log("[START] Binary Search for Minimum Window");
        log("##################################################");
        log("s = \"" + s + "\"");
        log("p = \"" + p + "\"");
        log("Initial low = " + low + ", high = " + high);

        while (low <= high) {
            int mid = (low + high) / 2;
            log("\n--------------------------------------------------");
            log("[BS] low = " + low + ", high = " + high + ", mid = " + mid);
            log("--------------------------------------------------");

            if (isValid(s, p, mid, start)) {
                minLength = mid;
                finalStart = start[0];
                log("[BS] Found valid window of size " + mid);
                log("[BS] Updating answer: minLength = " + minLength + ", start = " + finalStart);
                high = mid - 1;
                log("[BS] Moving left -> new high = " + high);
            } else {
                low = mid + 1;
                log("[BS] No valid window of size " + mid);
                log("[BS] Moving right -> new low = " + low);
            }
        }

        if (minLength == Integer.MAX_VALUE) {
            log("[RESULT] No window found.");
            return "";
        }

        String ans = s.substring(finalStart, finalStart + minLength);
        log("\n##################################################");
        log("[RESULT] Minimum window = \"" + ans + "\"");
        log("##################################################");

        return ans;
    }

    public static void main(String[] args) {
        String s = "timetopractice";
        String p = "toc";

        System.out.println("\nFinal Answer: " + minWindow(s, p));
    }
}