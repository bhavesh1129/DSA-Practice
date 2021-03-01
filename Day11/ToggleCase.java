//Toggle Case
package Day11;

import java.util.Scanner;

public class ToggleCase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        StringBuilder sb = new StringBuilder(str);
        toggleCase(sb);
    }

    private static void toggleCase(StringBuilder sb) {
        int i = 0;
        while (i < sb.length()) {
            char ch = sb.charAt(i);
            if (ch >= 97 && ch <= 122) {
                ch -= 32;
                System.out.print(ch);
            }
            if (ch >= 65 && ch <= 90) {
                ch += 32;
                System.out.print(ch);
            }
            i++;
        }
    }
}
