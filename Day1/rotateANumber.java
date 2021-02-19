//Rotate A Number by K turns
package Day1;

import java.util.Scanner;

public class rotateANumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int k = sc.nextInt();

        String str = Integer.toString(num);
        int remainingCount = str.length() - k;
        
        String afterRotate = str.substring(remainingCount, str.length());
        String beforeRotate = str.substring(0, remainingCount);
        System.out.println(afterRotate + beforeRotate);
    }
}
