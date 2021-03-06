//Toggle Case
package Day11;

import java.util.Scanner;

public class ToggleCase {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        System.out.println(toggleCase(str));
    }

    private static String toggleCase(String str) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                ans.append((char) (ch - 'a' + 'A') + "");
            } else {
                ans.append((char) (ch - 'A' + 'a') + "");
            }
        }
        return ans.toString();
    }
}
