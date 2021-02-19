//Span Of Array
package Day3;

import java.util.Scanner;

public class SpanOfArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr = new int[num];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        spanOfArray(num, arr);
    }

    private static void spanOfArray(int num, int[] arr) {
        int max = arr[0];
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        // for (int i = 0; i < arr.length; i++) {
        //     if (min > arr[i]) {
        //         min = arr[i];
        //     }
        // }
        System.out.println(max - min);
    }
}
