//Any Base Subtraction
package Day2;

import java.util.Scanner;

public class AnyBaseSubtraction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int base = sc.nextInt();
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        anyBaseSubtraction(base, num1, num2);
    }

    private static void anyBaseSubtraction(int base, int num1, int num2) {
        int finalNumber = 0;
        int pow = 1;
        int carry = 0;
        while (num2 > 0) {
            int lastDigitOfNum1 = num1 % 10;
            num1 /= 10;
            int lastDigitOfNum2 = num2 % 10;
            num2 /= 10;

            int difference = 0;
            lastDigitOfNum2 = lastDigitOfNum2 + carry;

            if (lastDigitOfNum2 >= lastDigitOfNum1) {
                carry = 0;
                difference = lastDigitOfNum2 - lastDigitOfNum1;
            } else {
                carry = -1;
                difference = lastDigitOfNum2 + base - lastDigitOfNum1;
            }
            finalNumber += difference * pow;
            pow = pow * 10;
        }
        System.out.println(finalNumber);
    }
}
