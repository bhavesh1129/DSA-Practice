package Day13;

import java.util.Scanner;

public class PermutationsOfAString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        PermutationsOfAString(str);
    }

    private static void PermutationsOfAString(String str) {
        int size = str.length();
        int lengthOfString = factorial(size);

        for (int i = 0; i < lengthOfString; i++) {
            StringBuilder sb = new StringBuilder(str);
            int temp = i;
            for (int j = size; j >= 1; j--) {
                int quo = temp / j;
                int rem = temp % j;
                System.out.print(sb.charAt(rem));
                sb.deleteCharAt(rem);
                temp = quo;
            }
            System.out.println();
        }
    }

    private static int factorial(int size) {
        int fact = 1;
        for (int i = 2; i <= size; i++) {
            fact *= i;
        }
        return fact;
    }
}
