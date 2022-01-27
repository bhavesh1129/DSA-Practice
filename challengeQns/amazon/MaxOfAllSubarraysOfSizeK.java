package challengeQns.amazon;

import java.util.ArrayList;

public class MaxOfAllSubarraysOfSizeK {
    public static void main(String[] args) {
        int n = 9, k = 3;
        int[] arr = {1, 2, 3, 1, 4, 5, 2, 3, 6};
        ArrayList<Integer> res = maxOfSizeK(arr, k);
        System.out.println(res);
    }

    private static ArrayList<Integer> maxOfSizeK(int[] arr, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i <= arr.length - k; i++) {
            int max = arr[i];
            for (int j = 1; j < k; j++) {
                max = Math.max(arr[i + j], max);
            }
            ans.add(max);
        }
        return ans;
    }
}
