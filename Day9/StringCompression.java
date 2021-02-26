//String Compression
package Day9;

import java.util.Scanner;

public class StringCompression {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        stringCompression1(str);
        System.out.println();
        stringCompression2(str);
    }

    private static void stringCompression1(String str) {
        int i = 0;
        int j = 1;
        while (i <= str.length() - 2 && j <= str.length() - 1) {
            char ch1 = str.charAt(i);
            char ch2 = str.charAt(j);

            if (ch1 == ch2) {
                i++;
                j++;
            } else {
                System.out.print(ch1);
                i++;
                j++;
            }
        }
        System.out.print(str.charAt(str.length() - 1));
    }

    private static void stringCompression2(String str) {
        String firstLetter = str.substring(0,1);
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            char ch1 = str.charAt(i - 1);
            char ch2 = str.charAt(i);

            if (ch1 == ch2) {
                count++;
            } else {
                if (count > 1) {
                    firstLetter += count;
                    count = 1;
                }
                firstLetter += ch2;
            }
        }
        if (count > 1) {
            firstLetter += count;
            count = 1;
        }
        System.out.println(firstLetter);
    }
}
