//End Point Of A Matrix
package Day7;

import java.util.Scanner;

public class EndPointOfAMatrix {
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
        endPointOfAMatrix(arr, rowOfArr, colOfArr);
    }

    private static void endPointOfAMatrix(int[][] arr, int rowOfArr, int colOfArr) {
        int direction = 0;// 0-east,1-south,2-west,3-north
        int row = 0;
        int col = 0;
        while (true) {
            direction = (direction + arr[row][col]) % 4;
            if (direction == 0) {
                col++;
            } else if (direction == 1) {
                row++;
            } else if (direction == 2) {
                col--;
            } else {
                row--;
            }

            if (row < 0) {
                row++;
                break;
            } else if (col < 0) {
                col++;
                break;
            } else if (row == arr.length) {
                row--;
                break;
            } else if (col == arr[0].length) {
                col--;
                break;
            }
        }
        System.out.print(row + "\n" + col);
    }
}
