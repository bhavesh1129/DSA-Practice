//Digits Frequency
package Day2;

import java.util.Scanner;

public class DigitFrequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int k = sc.nextInt();
        int count = 0;

        digitFrequency(num,k,count);
    }

    private static void digitFrequency(int num, int k, int count) {
        while (num != 0) {
            if (k == num % 10) {
                count++;
            }
            num = num / 10;
        }
        System.out.println(count);
    }
}
