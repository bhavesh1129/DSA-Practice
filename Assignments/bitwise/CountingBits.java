package bitwise;

import java.util.Scanner;

public class CountingBits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        countingNumOf1(n);
    }

    private static void countingNumOf1(int n) {
        System.out.println(n&1);
    }
}
