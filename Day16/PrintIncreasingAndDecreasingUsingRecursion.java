//Print Increasing And Decreasing Using Recursion
package Day16;

import java.util.Scanner;

public class PrintIncreasingAndDecreasingUsingRecursion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        printIncreasingAndDecreasingUsingRecursion(num);
    }

    private static void printIncreasingAndDecreasingUsingRecursion(int num) {
        if (num > 0) {
            System.out.println(num);
            printIncreasingAndDecreasingUsingRecursion(num - 1);
            System.out.println(num);
        }
    }
}
