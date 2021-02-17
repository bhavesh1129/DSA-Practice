import java.util.Scanner;

public class InverseOfANumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int originalPlace = 1;
        int inverse = 0;
        while (num != 0) {
            int originalDigit = num % 10;
            int invertedPlace = originalDigit;
            int invertedDigit = originalPlace;
            inverse = inverse + invertedDigit * (int)Math.pow(10, invertedPlace - 1);
            num/=10;
            originalPlace++;
        }
        System.out.println(inverse);
    }
}
