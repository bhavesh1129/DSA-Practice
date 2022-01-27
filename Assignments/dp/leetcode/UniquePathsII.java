package dp.leetcode;

import java.util.Arrays;

public class UniquePathsII {
    public static void main(String[] args) {
        int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] cache = new int[m][n];
        for (int[] e : cache) {
            Arrays.fill(e, -1);
        }
        System.out.println(uniquePathsR(obstacleGrid, m - 1, n - 1, cache));
    }

    public static int uniquePathsR(int[][] obstacleGrid, int m, int n, int[][] cache) {
        if (m < 0 || n < 0) {
            return 0;
        }
        if (obstacleGrid[m][n] == 1) {
            return 0;
        }
        if (m == 0 && n == 0) {
            return 1;
        }
        if (cache[m][n] != -1) {
            return cache[m][n];
        }
        int c1 = uniquePathsR(obstacleGrid, m, n - 1, cache);
        int c2 = uniquePathsR(obstacleGrid, m - 1, n, cache);
        return cache[m][n] = c1 + c2;
    }
}
