package hashset;

import java.util.HashMap;
import java.util.Scanner;

public class DistinctElemInEveryWindow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        distinctElements(arr, k);
    }

    private static void distinctElements(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        System.out.println(map.size());
        for (int i = k; i < arr.length; i++) {
            if (map.get(arr[i - k]) == 1) {
                map.remove(arr[i - k]);
            } else {
                map.put(arr[i - k], map.get(arr[i - k]) - 1);
            }
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            System.out.println(map.size());
        }
    }
}