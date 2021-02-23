//First And Last Index
package Day5;

import java.util.Scanner;

public class FirstAndLastIndex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr = new int[num];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        firstAndLastIndexOfAnArray(arr, k);
    }

    private static void firstAndLastIndexOfAnArray(int[] arr, int k) {
        // For First Index
        int firstPlace = 0;
        int lastPlace = arr.length - 1;
        int firstIndex = -1;
        while (firstPlace <= lastPlace) {
            int mid = (firstPlace + lastPlace) / 2;
            if (k > arr[mid]) {
                firstPlace = mid + 1;
            } else if (k < arr[mid]) {
                lastPlace = mid - 1;
            } else {
                firstIndex = mid;
                lastPlace = mid - 1;
            }
        }
        System.out.println(firstIndex);

        // For Last Index
        firstPlace = 0;
        lastPlace = arr.length - 1;
        int lastIndex = 0;
        while (firstPlace <= lastPlace) {
            int mid = (firstPlace + lastPlace) / 2;
            if (k > arr[mid]) {
                firstPlace = mid + 1;
            } else if (k < arr[mid]) {
                lastPlace = mid - 1;
            } else {
                lastIndex = mid;
                firstPlace = mid + 1;
            }
        }
        System.out.println(lastIndex);
    }
}
