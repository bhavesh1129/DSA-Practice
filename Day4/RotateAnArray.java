package Day4;

import java.util.Scanner;

public class RotateAnArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr = new int[num];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        rotateAnArray(arr, k);
        for (int val : arr) {
            System.out.println(val);
        }
    }

    private static void rotateAnArray(int[] arr, int k) {
        reverseOfArray(arr, 0, arr.length - 1 - k);
        reverseOfArray(arr, arr.length - k, arr.length - 1);
        reverseOfArray(arr, 0, arr.length - 1);
    }

    private static void reverseOfArray(int[] arr, int i, int j) {
        int li = i;
        int ri = j;
        while (li < ri) {
            int temp = arr[li];
            arr[li] = arr[ri];
            arr[ri] = temp;

            li++;
            ri--;
        }
    }
}
