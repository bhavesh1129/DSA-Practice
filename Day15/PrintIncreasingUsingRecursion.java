//Print Increasing Using Recursion
package Day15;

import java.util.Scanner;

public class PrintIncreasingUsingRecursion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        printIncreasingUsingRecursion(num);
    }

    private static void printIncreasingUsingRecursion(int num) {
        if (num > 0) {
            printIncreasingUsingRecursion(num - 1);
            System.out.println(num);
        }
    }
}
