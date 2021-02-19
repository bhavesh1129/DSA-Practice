//Print Whether it is Prime Number or Not
package Day1;

import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int countPrime = 0;
        int countNonPrime = 0;

        if (num == 1) {
            System.out.println("Prime");
        }
        for (int i = 2; i <= num; i++) {
            if (num % i == 0) {
                countPrime++;
            } else {
                countNonPrime++;
            }
        }
        if (countPrime == 1) {
            System.out.println("Prime");
        } else {
            System.out.println("Not Prime");
        }
    }
}
