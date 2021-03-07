package Day14;

import java.util.Scanner;

public class PrintDecreasingUsingRecursion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        printDecreasingUsingRecursion(num);
    }

    private static void printDecreasingUsingRecursion(int num) {
        if (num > 0) {
            System.out.println(num);
            printDecreasingUsingRecursion(num - 1);
        }
    }
}
