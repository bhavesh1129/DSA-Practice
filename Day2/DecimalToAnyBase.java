package Day2;

//Decimal To Any Base
import java.util.Scanner;

public class DecimalToAnyBase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int k = sc.nextInt();

        digitToAnyBase(num, k);
    }

    private static void digitToAnyBase(int num, int k) {
        int reversedValue = 0;
        int power = 1;
        while (num != 0) {
            int newDigit = num % k;
            num = num / k;
            reversedValue += newDigit * power;
            power = power * 10;
        }
        System.out.println(reversedValue);
    }
}
