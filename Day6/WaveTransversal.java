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
        int currentRow = 0;
        int currentCol = 0;
        int index = 0;
        while (index <= arr.length - 1) {
            while (currentRow <= rowOfArr - 1) {
                System.out.print(arr[currentRow][currentCol] + " ");
                currentRow++;
                index++;
            }
            currentCol++;
            currentRow--;
            while (currentRow <= rowOfArr - 1) {
                System.out.print(arr[currentRow][currentCol]+" ");
                currentRow--;
                index++;
            }
            currentRow++;
            currentCol++;
        }
    }
}
