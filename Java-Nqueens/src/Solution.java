import java.util.ArrayList;
import java.util.List;

public class Solution {
    private List<List<String>> result;
    private int[] queens; // queens[row] represents the column position of the queen in that row
    private boolean[] columns; // columns[i] indicates if column i is occupied
    private boolean[] diagonals; // diagonals[i] indicates if the diagonal i is occupied
    private boolean[] antiDiagonals; // antiDiagonals[i] indicates if the anti-diagonal i is occupied

    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        queens = new int[n];
        columns = new boolean[n];
        diagonals = new boolean[2 * n - 1];
        antiDiagonals = new boolean[2 * n - 1];
        backtrack(0, n);
        return result;
    }

    private void backtrack(int row, int n) {
        if (row == n) {
            result.add(generateBoard(queens, n));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isValidPlacement(row, col, n)) {
                placeQueen(row, col, n);
                backtrack(row + 1, n);
                removeQueen(row, col, n);
            }
        }
    }

    private boolean isValidPlacement(int row, int col, int n) {
        return !columns[col] && !diagonals[row + col] && !antiDiagonals[row - col + n - 1];
    }

    private void placeQueen(int row, int col, int n) {
        queens[row] = col;
        columns[col] = true;
        diagonals[row + col] = true;
        antiDiagonals[row - col + n - 1] = true;
    }

    private void removeQueen(int row, int col, int n) {
        queens[row] = 0;
        columns[col] = false;
        diagonals[row + col] = false;
        antiDiagonals[row - col + n - 1] = false;
    }

    private List<String> generateBoard(int[] queens, int n) {
        List<String> board = new ArrayList<>();
        for (int row = 0; row < n; row++) {
            StringBuilder sb = new StringBuilder();
            for (int col = 0; col < n; col++) {
                if (queens[row] == col) {
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            board.add(sb.toString());
        }
        return board;
    }
}