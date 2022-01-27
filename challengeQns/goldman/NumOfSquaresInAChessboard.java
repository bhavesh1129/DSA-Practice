package challengeQns.goldman;

public class NumOfSquaresInAChessboard {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(numOfSquares(n));
    }

    private static int numOfSquares(int n) {
        int ans = n * (n + 1) * (2 * n + 1) / 6;
        return ans;
    }
}