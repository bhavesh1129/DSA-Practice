//SpiralTraversal of an Array
package Day6;

import java.util.Scanner;

public class SpiralTraversal {
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
        spiralTraversal(arr, rowOfArr, colOfArr);
    }

    private static void spiralTraversal(int[][] arr, int rowOfArr, int colOfArr) {
        int minRow = 0;
        int minCol = 0;
        int maxRow = arr.length - 1;
        int maxCol = arr[0].length - 1;
        int index = 0;
        int count = rowOfArr * colOfArr;
        while (index < count) {
            // down
            for (int i = minRow, j = minCol; i <= maxRow && index < count; i++) {
                System.out.println(arr[i][j]);
                index++;
            }
            minCol++;

            // right
            for (int i = minCol, j = maxRow; i <= maxCol && index < count; i++) {
                System.out.println(arr[j][i]);
                index++;
            }
            maxRow--;

            // top
            for (int i = maxRow, j = maxCol; i >= minRow && index < count; i--) {
                System.out.println(arr[i][j]);
                index++;
            }
            maxCol--;

            // left
            for (int i = maxCol, j = minRow; i >= minCol && index < count; i--) {
                System.out.println(arr[j][i]);
                index++;
            }
            minRow++;
        }
    }
}