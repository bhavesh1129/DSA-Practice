//Rotate a Matrix By 90 Degrees
package Day7;

import java.util.Scanner;

public class RotateBy90Degrees {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rowOfArr = sc.nextInt();
        int colOfArr = sc.nextInt();
        int[][] arr = new int[rowOfArr][colOfArr];
        for (int i = 0; i < rowOfArr; i++) {
            for (int j = 0; j < colOfArr; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        rotateBy90Degrees(arr, rowOfArr, colOfArr);
    }

    private static void rotateBy90Degrees(int[][] arr, int rowOfArr, int colOfArr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length - 1; j >= 0; j--) {
                System.out.print(arr[j][i]+" ");
            }
            System.out.println();
        }
    }
}
