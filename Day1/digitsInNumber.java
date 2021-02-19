package Day1;

//Display the Digits of a Number
import java.util.Scanner;

public class digitsInNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String number = Integer.toString(num);
        for (int i = 0; i < number.length(); i++) {
            System.out.println(number.charAt(i));
        }
    }
}
