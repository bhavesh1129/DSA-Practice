//Binary Search in Array
package Day5;

import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr = new int[num];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        binarySearchinArray(arr, k);
    }

    private static void binarySearchinArray(int[] arr, int k) {
        int firstIndex = 0;
        int lastIndex = arr.length - 1;
        while (firstIndex <= lastIndex) {
            int mid = (firstIndex + lastIndex) / 2;
            if (k > arr[mid]) {
                firstIndex = mid + 1;
            } else if (k < arr[mid]) {
                lastIndex = mid - 1;
            } else {
                System.out.println(mid);
                return;
            }
        }
        System.out.println("Not present");
    }
}
