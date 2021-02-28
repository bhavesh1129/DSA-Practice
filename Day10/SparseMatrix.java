//Sparse Matrix
package Day10;

import java.util.Scanner;

public class SparseMatrix{
    public static void main(String[] args) {
        System.out.println("Question  1");
        Scanner sc = new Scanner(System.in);

        int count = 0;
        int row = sc.nextInt();
        int col = sc.nextInt();

        int[][] arr = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                arr[i][j] = sc.nextInt();
                if (arr[i][j] == 0)
                    count++;
            }
        }
        if (count > (row * col) / 2)
            System.out.println("It is a Sparse Matrix");
        else
            System.out.println("It is not a Sparse Matrix");
    }
}
