////Any Base Addition
package Day2;

import java.util.Scanner;

public class AnyBaseAddition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int base = sc.nextInt();
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        anyBaseAddition(base, num1, num2);
    }

    private static void anyBaseAddition(int base, int num1, int num2) {
        int carry = 0;
        int pow = 1;
        int finalNumber = 0;
        while (num1 > 0 || num2 > 0 || carry > 0) {
            int lastDigitOfNum1 = num1 % 10;
            int lastDigitOfNum2 = num2 % 10;
            num1 /= 10;
            num2 /= 10;
            int sum = lastDigitOfNum1 + lastDigitOfNum2 + carry;
            int newLastDigit = sum % base;
            carry = sum / base;
            finalNumber += newLastDigit * pow;
            pow = pow * 10;
        }
        System.out.print(finalNumber);
    }
}
