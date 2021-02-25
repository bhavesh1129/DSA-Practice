//Saddle Point In An Array
package Day8;

import java.util.Arrays;
import java.util.Scanner;

public class SaddlePoint {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int orderOfMatrix = sc.nextInt();
        int[][] arr = new int[orderOfMatrix][orderOfMatrix];
        for (int i = 0; i < orderOfMatrix; i++) {
            for (int j = 0; j < orderOfMatrix; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        saddlePointInAnArray(arr, orderOfMatrix);
    }

    private static void saddlePointInAnArray(int[][] arr, int size) {
        // int[] oneDArray = new int[size * size];
        // int index = 0;
        // for (int i = 0; i < arr.length; i++) {
        // for (int j = 0; j < arr[0].length; j++) {
        // oneDArray[index] = arr[i][j];
        // index++;
        // }
        // }
        // Arrays.sort(oneDArray);
        // System.out.println(oneDArray[size*(size-1)]);

        for (int i = 0; i < arr.length; i++) {
            int smallestValueColNum = 0;
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] < arr[i][smallestValueColNum]) {
                    smallestValueColNum = j;
                }
            }
            int flag = 0;
            for (int k = 0; k < arr.length; k++) {
                if (arr[k][smallestValueColNum] > arr[i][smallestValueColNum]) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                System.out.println(arr[i][smallestValueColNum]);
                return;
            }
        }
        System.out.println("Invalid input");
    }
}
