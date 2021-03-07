package Day17;

import java.util.Scanner;

public class FactorialUsingRecursion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        System.out.println(factorialUsingRecursion(num));
    }

    private static int factorialUsingRecursion(int num) {
        if (num == 1) {
            return 1;
        }
        int fact = factorialUsingRecursion(num - 1);
        int factorial = num * fact;
        return factorial;
    }
}
