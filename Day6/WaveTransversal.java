//Wave Transversal in An Array
package Day6;

import java.util.Scanner;

public class WaveTransversal {
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
        waveTransversal(arr, rowOfArr, colOfArr);
    }

    private static void waveTransversal(int[][] arr, int rowOfArr, int colOfArr) {
        for (int i = 0; i < colOfArr; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < arr.length; j++) {
                    System.out.println(arr[j][i]);
                }
            } else {
                for (int j = arr.length - 1; j >= 0; j--) {
                    System.out.println(arr[j][i]);
                }
            }
        }
    }
}
