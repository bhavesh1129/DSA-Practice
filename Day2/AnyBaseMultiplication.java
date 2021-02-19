//Any Base Multiplication
package Day2;

import java.util.Scanner;

public class AnyBaseMultiplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int base = sc.nextInt();
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        int finalAnswer = 0;
        int power = 1;

        while (num2 > 0) {
            int digit2 = num2 % 10;
            num2 /= 10;
            int singleDigitProduct = anyBaseSingleDigitMultiplication(base, num1, digit2);
            finalAnswer = getSum(base, finalAnswer, singleDigitProduct * power);
            power = power * 10;
        }
        System.out.print(finalAnswer);
    }

    private static int getSum(int base, int number1, int number2) {
        int finalNumber = 0;
        int carry = 0;
        int pow = 1;
        while (number1 > 0 || number2 > 0 || carry > 0) {
            int lastDigitOfNum1 = number1 % 10;
            number1 /= 10;
            int lastDigitOfNum2 = number2 % 10;
            number2 /= 10;

            int sum = lastDigitOfNum1 + lastDigitOfNum2 + carry;

            int digit = sum % base;
            carry = sum / base;

            finalNumber += digit * pow;
            pow = pow * 10;
        }
        return finalNumber;
    }

    private static int anyBaseSingleDigitMultiplication(int base, int num1, int digit2) {
        int finalNumber = 0;
        int carry = 0;
        int pow = 1;
        while (num1 > 0 || carry > 0) {
            int lastDigitOfNum1 = num1 % 10;
            num1 /= 10;
            int mul = lastDigitOfNum1 * digit2 + carry;
            carry = mul / base;
            mul = mul % base;

            finalNumber += mul * pow;
            pow = pow * 10;
        }
        return finalNumber;
    }
}
