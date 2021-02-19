//Base To Any Decimal
package Day2;

import java.util.Scanner;

public class BaseToAnyDecimal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int k = sc.nextInt();
        baseToAnyDecimal(num, k);
    }

    private static void baseToAnyDecimal(int num, int k) {
        int reversedNumber = 0;
        int power = 0;
        while (num != 0) {
            int digit = num % 10;
            num /= 10;
            reversedNumber += digit * Math.pow(k, power);
            power++;
        }
        System.out.println(reversedNumber);
    }
}
