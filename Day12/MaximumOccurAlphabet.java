//Maximum Occuruence of an Alphabet
package Day12;

import java.util.Scanner;

public class MaximumOccurAlphabet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        maximumOccurAlphabetInASting(str);
    }

    private static void maximumOccurAlphabetInASting(String str) {
        int[] countAlphabet = new int[256];
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            countAlphabet[ch]++;
        }

        int maxOccur = 0;
        char finalResult = ' ';
        for (int i = 0; i < str.length(); i++) {
            char characters = str.charAt(i);
            if (maxOccur < countAlphabet[characters]) {
                maxOccur = countAlphabet[characters];
                finalResult = characters;
            }
        }
        System.out.println(finalResult);
    }
}
