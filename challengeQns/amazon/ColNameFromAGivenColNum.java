package challengeQns.amazon;

public class ColNameFromAGivenColNum {
    public static void main(String[] args) {
        int n = 29;
        System.out.println(colName(n));
    }

    private static String colName(int n) {
        StringBuilder temp = new StringBuilder();
        while (n > 0) {
            char ch = (char) ('A' + (n - 1) % 26);
            temp.append(ch);
            n = (n - 1) / 26;
        }
        return temp.reverse().toString();
    }
}