package challengeQns.amazon;

public class MaximumProfit {
    public static void main(String[] args) {
        int[] prices = {334, 500, 169, 724, 478, 358, 962, 464, 705, 145, 281, 827, 961, 491, 995, 942, 827};
        int total = 2;
        int[][][] dp = new int[prices.length + 1][2][total];
        for (int i = 0; i <= prices.length; i++) {
            for (int j = 0; j < 2; j++) {
                for (int l = 0; l < total; l++) {
                    dp[i][j][l] = -1;
                }
            }
        }
        System.out.println(sol(prices, 0, 1, 0, dp, total));//1->buy || 0->sell || k->Num of transact
    }

    private static int sol(int[] prices, int curr, int buy, int k, int[][][] dp, int total) {
        if (k == total || curr == prices.length) {
            return 0;
        }
        if (dp[curr][buy][k] != -1) {
            return dp[curr][buy][k];
        }
        if (buy == 1) {
            int c1 = sol(prices, curr + 1, 0, k, dp, total) - prices[curr];
            int c2 = sol(prices, curr + 1, buy, k, dp, total);
            return dp[curr][buy][k] = Math.max(c1, c2);
        } else {
            int c1 = sol(prices, curr + 1, 1, k + 1, dp, total) + prices[curr];
            int c2 = sol(prices, curr + 1, buy, k, dp, total);
            return dp[curr][buy][k] = Math.max(c1, c2);
        }
    }
}
