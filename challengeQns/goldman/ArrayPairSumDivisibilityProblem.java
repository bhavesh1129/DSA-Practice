package challengeQns.goldman;

public class ArrayPairSumDivisibilityProblem {
    public static void main(String[] args) {
        int[] arr = {12, 11, 12, 4, 2, 3, 10, 9};
        int k = 5;
        System.out.println(sumDivisibility(arr, k));
    }

    private static boolean sumDivisibility(int[] arr, int k) {
        int[] rem = new int[k];
        for (int i : arr) {
            rem[i % k]++;
        }

        if (rem[0] % 2 != 0) {
            return false;
        }
        int i = 1, j = k - 1;
        while (i < j) {
            if (rem[i] != rem[j]) {
                return false;
            }
            i++;
            j--;
        }
        if (i == j && rem[i] % 2 == 1) {
            return false;
        }
        return true;
    }
}
