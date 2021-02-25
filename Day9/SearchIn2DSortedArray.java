//Search In 2D Sorted Array
package Day9;

import java.util.Scanner;

public class SearchIn2DSortedArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int orderOfMatrix = sc.nextInt();
        int[][] arr = new int[orderOfMatrix][orderOfMatrix];
        for (int i = 0; i < orderOfMatrix; i++) {
            for (int j = 0; j < orderOfMatrix; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int k = sc.nextInt();
        searchIn2DSortedArray(arr, orderOfMatrix, k);
    }

    private static void searchIn2DSortedArray(int[][] arr, int size, int k) {
        int rowNum = 0;
        int colNum = 0;
        int flag = 1;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (k == arr[i][j]) {
                    flag = 0;
                    rowNum = i;
                    colNum = j;
                }
            }
        }
        if (flag == 0) {
            System.out.print(rowNum + "\n" + colNum);
        } else {
            System.out.print("Not Found");
        }
    }
}
