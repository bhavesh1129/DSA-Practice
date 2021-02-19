package Day1;

//Fibonacci Numbers
import java.util.Scanner;

public class FibonacciNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int num1 = 0;
        int num2 = 1;
        int temp = 0;
        for (int i = 0; i < num; i++) {
            System.out.println(num1);
            temp = num1 + num2;
            num1 = num2;
            num2 = temp;
        }
    }
}