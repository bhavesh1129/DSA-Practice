package challengeQns.amazon;

public class CountWaysToNThStair {
    public static void main(String[] args) {
        int n = 4;
        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        System.out.println(countways(n, dp));
    }

    private static long countways(int n, long[] dp) {
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i - 2], dp[i - 1]) + 1;
        }
        return dp[n];
    }
}