import java.util.Scanner;

public class ReverseANumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        while (num != 0) {
            int temp = num % 10;
            System.out.println(temp);
            num = num / 10;
        }
    }
}
