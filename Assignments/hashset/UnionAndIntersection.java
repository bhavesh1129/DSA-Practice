package hashset;

import java.util.HashSet;
import java.util.Scanner;

public class UnionAndIntersection {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr1 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }
        int[] arr2 = new int[n];
        for (int i = 0; i < n; i++) {
            arr2[i] = sc.nextInt();
        }
//        System.out.println(union(arr1, arr2));
        System.out.println(intersection(arr1, arr2));
    }

    private static int intersection(int[] arr1, int[] arr2) {
        HashSet<Integer> set = new HashSet();
        int count = 0;
        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            if (set.contains(arr2[i])) {
                count++;
                set.remove(arr2[i]);
            }
        }
        return count;
    }

    private static int union(int[] arr1, int[] arr2) {
        HashSet<Integer> set = new HashSet();
        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
            set.add(arr2[i]);
        }
        return set.size();
    }
}
