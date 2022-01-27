package dp.MaxProfit;

public class BuyAndSell3 {
    public static void main(String[] args) {
        int[] prices = {10, 22, 5, 75, 65, 80};
        int[][][] dp = new int[prices.length + 1][2][2];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0][0] = -1;
            dp[i][0][1] = -1;
            dp[i][1][0] = -1;
            dp[i][1][1] = -1;
        }
        System.out.println(sol(prices, 0, 1, 0, dp));//1->buy || 0->sell || k->Num of transactions
    }

    private static int sol(int[] prices, int curr, int buy, int k, int[][][] dp) {
        if (k == 2 || curr == prices.length) {
            return 0;
        }
        if (dp[curr][buy][k] != -1) {
            return dp[curr][buy][k];
        }
        if (buy == 1) {
            int c1 = sol(prices, curr + 1, 0, k, dp) - prices[curr];
            int c2 = sol(prices, curr + 1, buy, k, dp);
            return dp[curr][buy][k] = Math.max(c1, c2);
        } else {
            int c1 = sol(prices, curr + 1, 1, k + 1, dp) + prices[curr];
            int c2 = sol(prices, curr + 1, buy, k, dp);
            return dp[curr][buy][k] = Math.max(c1, c2);
        }
    }
}