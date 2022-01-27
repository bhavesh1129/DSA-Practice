package challengeQns.amazon;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class IPL2021MatchDay2 {
    public static void main(String[] args) {
        int[] arr = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13};
        int n = arr.length;
        int k = 4;
        ArrayList<Integer> res = maxInSizeOfK(arr, k);
        System.out.println(res);
    }

    private static ArrayList<Integer> maxInSizeOfK(int[] arr, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            while (!dq.isEmpty() && arr[dq.getLast()] <= arr[i]) {
                dq.removeLast();
            }
            dq.addLast(i);
            if (dq.getFirst() == i - k) {
                dq.removeFirst();
            }
            if (i >= k - 1) {
                ans.add(arr[dq.getFirst()]);
            }

        }
        return ans;
    }
}