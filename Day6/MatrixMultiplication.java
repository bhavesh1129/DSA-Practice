//Matrix Multiplication of an 2D Array
package Day6;

import java.util.Scanner;

public class MatrixMultiplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rowOfArr1 = sc.nextInt();
        int colOfArr1 = sc.nextInt();
        int[][] arr1 = new int[rowOfArr1][colOfArr1];
        for (int i = 0; i < rowOfArr1; i++) {
            for (int j = 0; j < colOfArr1; j++) {
                arr1[i][j] = sc.nextInt();
            }
        }
        int rowOfArr2 = sc.nextInt();
        int colOfArr2 = sc.nextInt();
        int[][] arr2 = new int[rowOfArr2][colOfArr2];
        for (int i = 0; i < rowOfArr2; i++) {
            for (int j = 0; j < colOfArr2; j++) {
                arr2[i][j] = sc.nextInt();
            }
        }
        print2DArray(arr1, rowOfArr1, arr2, colOfArr1, colOfArr2);
    }

    private static void print2DArray(int[][] arr1, int rowOfArr1, int[][] arr2, int colOfArr1, int colOfArr2) {
        int[][] mul = new int[rowOfArr1][colOfArr2];
        for (int i = 0; i < rowOfArr1; i++) {
            for (int j = 0; j < colOfArr2; j++) {
                mul[i][j] = 0;
                for (int k = 0; k < colOfArr1; k++) {
                    mul[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        for (int i = 0; i < rowOfArr1; i++) {
            for (int j = 0; j < colOfArr2; j++) {
                System.out.println(mul[i][j]);
            }
            System.out.println();
        }
    }
}
