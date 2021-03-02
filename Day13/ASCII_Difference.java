//ASCII Difference
package Day13;

import java.util.Scanner;

public class ASCII_Difference {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        StringBuilder sb = new StringBuilder();
        ascii_Difference(sb, str);
    }

    private static void ascii_Difference(StringBuilder sb, String str) {
        sb.append(str.charAt(0));

        for (int i = 1; i < str.length(); i++) {
            char ch1 = str.charAt(i - 1);
            char ch2 = str.charAt(i);

            int val = ch2 - ch1;

            sb.append(val);
            sb.append(ch2);
        }
        System.out.println(sb.toString());
    }
}
