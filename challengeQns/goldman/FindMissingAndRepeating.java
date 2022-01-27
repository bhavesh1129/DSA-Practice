package challengeQns.goldman;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindMissingAndRepeating {
    public static void main(String[] args) {
        int n = 6;
        int[] arr = {4, 3, 6, 2, 1, 1};
        int[] ans = missingAndRepeating(n, arr);
        System.out.println(Arrays.toString(ans));
    }

    private static int[] missingAndRepeating(int n, int[] arr) {
        int[] res = new int[2];
        Map<Integer, Boolean> numberMap = new HashMap<>();
        int max = arr.length;
        for (Integer i : arr) {
            if (numberMap.get(i) == null) {
                numberMap.put(i, true);
            } else {
                res[0] = i;
            }
        }
        for (int i = 1; i <= max; i++) {
            if (numberMap.get(i) == null) {
                res[1] = i;
            }
        }
        return res;
    }
}
