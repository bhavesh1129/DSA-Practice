//GCD and LCM of A Number
package Day1;

import java.util.Scanner;

public class GCDandLCM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int gcd = 0;
        int lcm = 0;

        for (int i = 1; i <= num1 && i <= num2; i++) {
            if (num1 % i == 0 && num2 % i == 0) {
                gcd = i;
            }
        }
        lcm = (num1*num2)/gcd;
        System.out.println(gcd+"\n"+lcm);
    }
}