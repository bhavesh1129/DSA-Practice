package hashset;

import java.util.HashSet;
import java.util.Scanner;

public class ContainsDuplicateII {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        System.out.println(containsNearbyDuplicate(arr, k));
    }

    private static boolean containsNearbyDuplicate(int[] arr, int k) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (set.add(arr[i]) == false) {
                return true;
            }
            if (set.size() == k + 1) {
                set.remove(arr[i - k]);
            }
        }
        return false;
    }
}
