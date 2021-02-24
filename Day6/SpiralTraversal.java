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
        
    }
}