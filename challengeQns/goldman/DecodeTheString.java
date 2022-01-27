package challengeQns.goldman;

import java.util.Stack;

public class DecodeTheString {
    public static void main(String[] args) {
        String str = "1[b]";
        System.out.println(decode(str));
    }

    private static String decode(String str) {
        Stack<Integer> numStack = new Stack<>();
        Stack<String> strStack = new Stack<>();
        String res = "";
        int idx = 0;
        while (idx < str.length()) {
            if (Character.isDigit(str.charAt(idx))) {
                int num = 0;
                while (Character.isDigit(str.charAt(idx))) {
                    num = num * 10 + str.charAt(idx) - '0';
                    idx++;
                }
                numStack.push(num);
            } else if (str.charAt(idx) == '[') {
                strStack.push(res);
                res = "";
                idx++;
            } else if (str.charAt(idx) == ']') {
                StringBuilder sb = new StringBuilder(strStack.pop());
                int count = numStack.pop();
                for (int i = 0; i < count; i++) {
                    sb.append(res);
                }
                res = sb.toString();
                idx++;
            } else {
                res += str.charAt(idx);
                idx++;
            }
        }
        return res;
    }
}
