package dp.leetcode;

import java.util.Arrays;

public class HouseRobber {
    public static void main(String[] args) {
        int[] arr = {2, 7, 9, 3, 1};
        int curr = 0;
        int n = arr.length;
        int[] cache = new int[n + 1];
        Arrays.fill(cache, -1);
        System.out.println(rob(arr, curr, n, cache));
    }

    private static int rob(int[] arr, int curr, int n, int[] cache) {
        if (curr >= n) {
            return 0;
        }
        if (cache[curr] != -1) {
            return cache[curr];
        }
        int ifRobbed = rob(arr, curr + 2, n, cache) + arr[curr];
        int ifNotRobbed = rob(arr, curr + 1, n, cache);
        return cache[curr] = Math.max(ifNotRobbed, ifRobbed);
    }
}
