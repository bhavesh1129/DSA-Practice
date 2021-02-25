//Ring Roate in 2D Array
package Day8;

import java.util.Scanner;

public class RingRotate {
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
        int shell = sc.nextInt();
        int rotate = sc.nextInt();
        ringRotate(arr, shell, rotate);
        displayArray(arr);
    }

    private static void ringRotate(int[][] arr, int shell, int rotate) {
        int[] new1dArray = fillOneDArrayFromShell(arr, shell);
        rotateTheArray(new1dArray, rotate);
        fillShellFromOneDArray(arr, shell, new1dArray);
    }

    private static int[] fillOneDArrayFromShell(int[][] arr, int shell) {
        int minRow = shell - 1;
        int minCol = shell - 1;
        int maxRow = arr.length - shell;
        int maxCol = arr[0].length - shell;
        int size = 2 * (maxRow - minRow + maxCol - minCol);
        int[] newArray = new int[size];
        int index = 0;

        // left
        for (int i = minRow, j = minCol; i <= maxRow; i++) {
            newArray[index] = arr[i][j];
            index++;
        }
        // bottom
        for (int i = minCol + 1, j = maxRow; i <= maxCol; i++) {
            newArray[index] = arr[j][i];
            index++;
        }
        // right
        for (int i = maxRow - 1, j = maxCol; i >= minRow; i--) {
            newArray[index] = arr[i][j];
            index++;
        }
        // top
        for (int i = maxCol - 1, j = minRow; i >= minCol + 1; i--) {
            newArray[index] = arr[j][i];
            index++;
        }
        return newArray;
    }

    private static void rotateTheArray(int[] new1dArray, int rotate) {
        rotate = rotate % new1dArray.length;
        if (rotate < 0) {
            rotate += new1dArray.length;
        }
        reverseTheArray(new1dArray, 0, new1dArray.length - rotate - 1);
        reverseTheArray(new1dArray, new1dArray.length - rotate, new1dArray.length - 1);
        reverseTheArray(new1dArray, 0, new1dArray.length - 1);
    }

    private static void reverseTheArray(int[] new1dArray, int i, int j) {
        int leftIndex = i;
        int rightIndex = j;
        while (leftIndex <= rightIndex) {
            int temp = new1dArray[leftIndex];
            new1dArray[leftIndex] = new1dArray[rightIndex];
            new1dArray[rightIndex] = temp;

            leftIndex++;
            rightIndex--;
        }
    }

    private static void fillShellFromOneDArray(int[][] arr, int shell, int[] new1dArray) {

        int minRow = shell - 1;
        int minCol = shell - 1;
        int maxRow = arr.length - shell;
        int maxCol = arr[0].length - shell;

        int index = 0;

        // left
        for (int i = minRow, j = minCol; i <= maxRow; i++) {
            arr[i][j] = new1dArray[index];
            index++;
        }
        // bottom
        for (int i = minCol + 1, j = maxRow; i <= maxCol; i++) {
            arr[j][i] = new1dArray[index];
            index++;
        }
        // right
        for (int i = maxRow - 1, j = maxCol; i >= minRow; i--) {
            arr[i][j] = new1dArray[index];
            index++;
        }
        // top
        for (int i = maxCol - 1, j = minRow; i >= minCol + 1; i--) {
            arr[j][i] = new1dArray[index];
            index++;
        }
    }

    private static void displayArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
}
