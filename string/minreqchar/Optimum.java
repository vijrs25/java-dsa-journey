package string.minreqchar;

public class Optimum {

    static boolean DEBUG = true;

    static void log(String msg) {
        if (DEBUG) {
            System.out.println(msg);
        }
    }

    static void printPatternCounts(String p, int[] countP) {
        if (!DEBUG) return;

        boolean[] printed = new boolean[256];
        System.out.print("Pattern countP: ");
        for (char ch : p.toCharArray()) {
            if (!printed[ch]) {
                System.out.print("'" + ch + "'=" + countP[ch] + "  ");
                printed[ch] = true;
            }
        }
        System.out.println();
    }

    static void printWindowCounts(String p, int[] countS) {
        if (!DEBUG) return;

        boolean[] printed = new boolean[256];
        System.out.print("Window countS : ");
        for (char ch : p.toCharArray()) {
            if (!printed[ch]) {
                System.out.print("'" + ch + "'=" + countS[ch] + "  ");
                printed[ch] = true;
            }
        }
        System.out.println();
    }

    public static String minWindow(String s, String p) {
        int len1 = s.length();
        int len2 = p.length();

        log("==================================================");
        log("START minWindow()");
        log("s = \"" + s + "\"");
        log("p = \"" + p + "\"");
        log("==================================================");

        if (len1 < len2) {
            log("String s छोटा hai pattern se, answer = \"\"");
            return "";
        }

        int[] countP = new int[256];
        int[] countS = new int[256];

        // Store occurrence of characters of P
        log("\n[STEP 1] Build frequency of pattern p");
        for (int i = 0; i < len2; i++) {
            char ch = p.charAt(i);
            countP[ch]++;
            log("countP['" + ch + "'] = " + countP[ch]);
        }
        printPatternCounts(p, countP);

        int start = 0, start_idx = -1, min_len = Integer.MAX_VALUE;
        int count = 0;

        log("\n[STEP 2] Expand window using j");

        for (int j = 0; j < len1; j++) {
            char currChar = s.charAt(j);

            log("\n--------------------------------------------------");
            log("j = " + j + ", currChar = '" + currChar + "'");
            log("Before adding: start = " + start + ", count = " + count);

            // Count occurrence of characters of string S
            countS[currChar]++;
            log("Added '" + currChar + "' to window");
            log("countS['" + currChar + "'] = " + countS[currChar]);

            // If S's char matches with P's char, increment count
            if (countP[currChar] > 0 && countS[currChar] <= countP[currChar]) {
                count++;
                log("[MATCH] Useful char matched -> count = " + count);
            } else {
                log("[INFO] Char either not needed or extra");
            }

            printPatternCounts(p, countP);
            printWindowCounts(p, countS);

            // If all characters are matched
            if (count == len2) {
                log("\n[STEP 3] All required characters matched because count == len2");
                log("count = " + count + ", len2 = " + len2);

                // Try to minimize the window
                char startChar;
                while (countS[startChar = s.charAt(start)] > countP[startChar] || countP[startChar] == 0) {
                    log("Trying to shrink from left...");
                    log("start = " + start + ", startChar = '" + startChar + "'");

                    if (countP[startChar] == 0) {
                        log("Reason: '" + startChar + "' pattern me required hi nahi hai");
                    } else if (countS[startChar] > countP[startChar]) {
                        log("Reason: '" + startChar + "' extra hai in current window");
                    }

                    if (countS[startChar] > countP[startChar]) {
                        countS[startChar]--;
                        log("Decremented countS['" + startChar + "'] -> " + countS[startChar]);
                    }

                    start++;
                    log("Moved start to " + start);
                }

                // Update window size
                int len = j - start + 1;
                String currentWindow = s.substring(start, j + 1);

                log("\n[STEP 4] Valid minimized window found");
                log("Window = \"" + currentWindow + "\"");
                log("Window start = " + start + ", end = " + j + ", len = " + len);

                if (min_len > len) {
                    min_len = len;
                    start_idx = start;
                    log("[UPDATE ANSWER] New minimum window found");
                    log("min_len = " + min_len + ", start_idx = " + start_idx);
                } else {
                    log("[NO UPDATE] Current window is not smaller than best answer");
                }
            } else {
                log("[STEP 3 skipped] count != len2, so full match not yet found");
            }
        }

        if (start_idx == -1) {
            log("\nNo valid window found. Returning empty string.");
            return "";
        }

        String ans = s.substring(start_idx, start_idx + min_len);
        log("\n==================================================");
        log("FINAL ANSWER = \"" + ans + "\"");
        log("start_idx = " + start_idx + ", min_len = " + min_len);
        log("==================================================");

        return ans;
    }

    public static void main(String[] args) {
        String s = "timetopracticeot";
        String p = "toc";

        String res = minWindow(s, p);
        System.out.println("\nResult: " + res);
    }
}