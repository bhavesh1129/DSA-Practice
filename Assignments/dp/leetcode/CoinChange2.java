package dp.leetcode;

import java.util.Arrays;

public class CoinChange2 {
    public static void main(String[] args) {
        int amount = 5;
        int[] coins = {1, 2, 5};
        int[][] cache = new int[amount + 1][coins.length + 1];
        for (int[] i : cache) {
            Arrays.fill(i, -1);
        }
        System.out.println(change(amount, coins.length, coins, cache));
    }

    private static int change(int amount, int n, int[] coins, int[][] cache) {
        if (amount == 0) {
            return 1;
        }
        if (n == 0) {
            return 0;
        }
        if (cache[amount][n] != -1) {
            return cache[amount][n];
        }
        int pick = 0, dontPick = 0;
        if (coins[n - 1] <= amount) {
            pick = change(amount - coins[n - 1], n, coins, cache);
        }
        dontPick = change(amount, n - 1, coins, cache);
        return cache[amount][n] = pick + dontPick;
    }
}