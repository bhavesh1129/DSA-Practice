package dp.basics;

import java.util.Arrays;

public class Knapsack01 {
    public static void main(String[] args) {
        int[] wt = {1, 2, 3, 2, 2};
        int[] price = {8, 4, 0, 5, 3};

        int n = wt.length, cap = 4;
        int[][] cache = new int[n + 1][cap + 1];
        for (int[] row : cache) {
            Arrays.fill(row, -1);
        }
        System.out.println(sol(price, wt, n, 0, cap, cache));
    }

    private static int sol(int[] price, int[] wt, int n, int curr, int cap, int[][] cache) {
        if (cap == 0 || curr == n) {
            return 0;
        }
        if (cache[curr][cap] != -1) {
            return cache[curr][cap];
        }
        int pick = 0, dontPick = 0;
        if (wt[curr] <= cap) {
            pick = sol(price, wt, n, curr + 1, cap - wt[curr], cache) + price[curr];
        }
        dontPick = sol(price, wt, n, curr + 1, cap, cache);
        return cache[curr][cap] = Math.max(pick, dontPick);
    }
}
