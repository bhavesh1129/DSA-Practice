package dp.basics;

import java.util.Arrays;

public class ClimbingStairs {
    public static void main(String[] args) {
        int n = 200;
        long[] cache = new long[n + 1];
        Arrays.fill(cache, -1);
        System.out.println(climbStairs(n, cache));
    }

    private static long climbStairs(int n, long[] cache) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        if (cache[n] != -1) {
            return cache[n];
        }
        long c1 = climbStairs(n - 1, cache);
        long c2 = climbStairs(n - 2, cache);
        return cache[n] = c1 + c2;
    }
}
