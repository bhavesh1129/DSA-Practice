//Any Base To Any Base
package Day2;

import java.util.Scanner;

public class AnyBaseToAnyBase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int base1 = sc.nextInt();
        int base2 = sc.nextInt();
        AnybaseToAnyBase(num, base1, base2);
    }

    private static void AnybaseToAnyBase(int num, int base1, int base2) {
        int revNum1 = 0;
        int pow1 = 0;
        while (num > 0) {
            int digit1 = num % 10;
            num /= 10;
            revNum1 += digit1 * Math.pow(base1, pow1);
            pow1++;
        }
        int changedNumber = revNum1;
        int revNum2 = 0;
        int pow2 = 1;
        while (changedNumber > 0) {
            int digit2 = changedNumber % base2;
            changedNumber /= base2;
            revNum2 += digit2 * pow2;
            pow2 = pow2 * 10;
        }
        System.out.println(revNum2);
    }
}
