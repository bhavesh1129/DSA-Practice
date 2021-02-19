//Print Prime Numbers in a given interval
package Day1;

import java.util.Scanner;

public class PrintPrimeNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        for (int i = num1 + 1; i < num2; i++) {
            int flag = checkPrimeNumber(i);

            if(flag == 0){
                System.out.println(i);
            }
        }
    }

    private static int checkPrimeNumber(int i) {
        int flag = 0;
        for (int j = 2; j <= i / 2; j++) {
            if (i % j == 0) {
                flag = 1;
                break;
            }
        }
        return flag;
    }
}
