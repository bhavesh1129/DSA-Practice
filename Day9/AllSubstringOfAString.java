//All Substring Of A String
package Day9;

import java.util.Scanner;

public class AllSubstringOfAString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        allSubstringOfAString(str);
    }

    private static void allSubstringOfAString(String str) {
        for (int i = 0; i <= str.length() - 1; i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                System.out.println(str.substring(i, j));
            }
        }
    }
}
