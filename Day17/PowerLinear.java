//Power Linear Using Recursion
package Day17;

import java.util.Scanner;

public class PowerLinear {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int pow = sc.nextInt();
        System.out.println(powerLinearUsingRecursion(num, pow));
    }

    private static int powerLinearUsingRecursion(int num, int pow) {
        if (pow == 0) {
            return 1;
        }
        int power = powerLinearUsingRecursion(num, pow - 1);
        int powLinear = num * power;
        return powLinear;
    }
}
