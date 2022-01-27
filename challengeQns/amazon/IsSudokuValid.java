package challengeQns.amazon;

public class IsSudokuValid {
    public static void main(String[] args) {
        int[][] board = {
                {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0},};
        System.out.println(isValid(board));
    }

    private static int isValid(int[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != 0) {
                    if (isValids(board, i, j, board[i][j]) == 0) {
                        return 0;
                    }
                }
            }
        }
        return 1;
    }

    public static int isValids(int[][] board, int row, int col, int num) {
        //for row checking
        for (int i = col + 1; i < 9; i++) {
            if (board[row][i] == num)
                return 0;
        }

        //For col checking
        for (int i = row + 1; i < 9; i++) {
            if (board[i][col] == num)
                return 0;
        }

        //for 3*3 matrix
        int x = row - row % 3, y = col - col % 3;
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                if (board[i][j] == num && !(i == row && j == col))
                    return 0;
            }
        }
        return 1;
    }
}
