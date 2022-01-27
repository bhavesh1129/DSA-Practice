package challengeQns.goldman;

import java.util.Stack;

public class MinNumberForPattern {
    public static void main(String[] args) {
        String str = "DDD";
        System.out.println(pattern(str));
    }

    private static String pattern(String str) {
        Stack<Integer> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= str.length(); i++) {
            st.push(i + 1);
            if (i == str.length() || str.charAt(i) == 'I') {
                while (!st.isEmpty()) {
                    sb.append(st.pop());
                }
            }
        }

        return sb.toString();
    }
}
