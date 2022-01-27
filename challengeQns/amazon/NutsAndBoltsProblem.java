package challengeQns.amazon;

import java.util.*;

public class NutsAndBoltsProblem {
    public static void main(String[] args) {
        char[] nuts = {'@', '%', '$', '#', '^'};
        char[] bolts = {'%', '@', '#', '$', '^'};
        matchPairs(nuts, bolts, nuts.length);
    }

    private static void matchPairs(char nuts[], char bolts[], int n) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(nuts[i], i);
        }
        for (int i = 0; i < n; i++) {
            if (map.containsKey(bolts[i])) {
                nuts[i] = bolts[i];
            }
        }
        Arrays.sort(nuts);
        Arrays.sort(bolts);
        System.out.println(nuts);
        System.out.println(bolts);
    }
}
