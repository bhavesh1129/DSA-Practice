package dp.basics;

import java.util.Arrays;

public class FibonacciSeries {
    public static void main(String[] args) {
        int n = 50;
        long[] cache = new long[n + 1];
        Arrays.fill(cache, -1);
        System.out.println(fib(n, cache));
    }

    private static long fib(int n, long[] cache) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (cache[n] != -1) {
            return cache[n];
        }
        long fib1 = fib(n - 1, cache);
        long fib2 = fib(n - 2, cache);
        long ans = fib1 + fib2;
        return cache[n] = ans;
    }
}