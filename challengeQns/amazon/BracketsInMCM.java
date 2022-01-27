package challengeQns.amazon;

public class BracketsInMCM {
    public static void main(String[] args) {
        int n = 5;
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(mcm(arr, 1, arr.length - 1));
    }

    private static int mcm(int[] arr, int i, int j) {
        if (i >= j) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int tempAns = mcm(arr, i, k) + mcm(arr, k + 1, j) + (arr[i - 1] * arr[k] * arr[j]);
            min = Math.min(tempAns, min);
        }
        return min;
    }
}