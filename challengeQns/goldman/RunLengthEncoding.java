package challengeQns.goldman;

import java.util.LinkedHashMap;
import java.util.Map;

public class RunLengthEncoding {
    public static void main(String[] args) {
        String str = "abbbcdddd";
        System.out.println(encoding(str));
    }

    private static String encoding(String str) {
        int n = str.length();
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (str.charAt(i - 1) == str.charAt(i)) {
                count++;
            } else {
                sb.append(str.charAt(i - 1));
                sb.append(count);
                count = 1;
            }
        }
        sb.append(str.charAt(n - 1));
        sb.append(count);
        return sb.toString();
    }
}
