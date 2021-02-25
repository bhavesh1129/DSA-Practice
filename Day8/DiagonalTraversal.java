//Diagonal Traversal in 2D Array
package Day8;

import java.util.Scanner;

public class DiagonalTraversal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int orderOfMatrix = sc.nextInt();
        int[][] arr = new int[orderOfMatrix][orderOfMatrix];
        for (int i = 0; i < orderOfMatrix; i++) {
            for (int j = 0; j < orderOfMatrix; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        diagonalTraversalInArray(arr);
    }

    private static void diagonalTraversalInArray(int[][] arr) {
        for (int gap = 0; gap < arr.length; gap++) {
            for (int i = 0, j = gap; j < arr.length; i++, j++) {
                System.out.println(arr[i][j]);
            }
        }
    }
}
