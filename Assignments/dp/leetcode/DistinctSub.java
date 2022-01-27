package dp.leetcode;

import java.util.Arrays;

public class DistinctSub {
    public static void main(String[] args) {
        String s = "rabbbit";
        String t = "rabbit";
        int[][] cache = new int[s.length() + 1][t.length() + 1];
        for (int[] e : cache) {
            Arrays.fill(e, -1);
        }
        System.out.println(sol(s, t, 0, 0, cache));
    }

    private static int sol(String s, String t, int currS, int currT, int[][] cache) {
        if (currT == t.length()) {
            return 1;
        }
        if (currS == s.length()) {
            return 0;
        }
        if (cache[currS][currT] != -1) {
            return cache[currS][currT];
        }
        int inc = 0;
        if (s.charAt(currS) == t.charAt(currT)) {
            inc = sol(s, t, currS + 1, currT + 1, cache);
        }
        int exc = sol(s, t, currS + 1, currT, cache);
        return cache[currS][currT] = inc + exc;
    }
}
