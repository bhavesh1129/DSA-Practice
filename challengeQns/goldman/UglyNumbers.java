package challengeQns.goldman;

public class UglyNumbers {
    public static void main(String[] args) {
        int n = 1690;
        System.out.println(nthUglyNumber(n));
//        System.out.println(nthUglyNumbers(n));
    }

    private static boolean nthUglyNumbers(int n) {
        if (n < 1) {
            return false;
        }
        int[] arr = {2, 3, 5};
        for (int i : arr) {
            while (n % i == 0) {
                n = n / i;
            }
        }
        return n == 1;
    }

    private static int nthUglyNumber(int n) {
        int c2 = 0, c3 = 0, c5 = 0;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i] = Math.min(2 * dp[c2], Math.min(3 * dp[c3], 5 * dp[c5]));
            if (2 * dp[c2] == dp[i]) {
                c2++;
            }
            if (3 * dp[c3] == dp[i]) {
                c3++;
            }
            if (5 * dp[c5] == dp[i]) {
                c5++;
            }
        }
        return dp[n - 1];
    }
}
