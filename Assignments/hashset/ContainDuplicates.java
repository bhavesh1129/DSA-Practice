package hashset;

import java.util.*;
import java.util.Set;

public class ContainDuplicates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(checkDuplicates(arr));
    }

    private static boolean checkDuplicates(int[] arr) {
        HashSet<Integer> set = new HashSet();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        return arr.length != set.size();
    }
}
