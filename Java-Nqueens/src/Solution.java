import java.util.ArrayList;
public class Solution {
    public ArrayList<ArrayList<String>> solveNQueens(int a) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        int[] board = new int[a];
        solveNQueensUtil(a, 0, board, result);
        return result;
    }
    private void solveNQueensUtil(int A, int row, int[] board, ArrayList<ArrayList<String>> result) {
        if (row == A) {
            result.add(generateBoard(board));
            return;
        }

        for (int col = 0; col < A; col++) {
            if (isSafe(row, col, board)) {
                board[row] = col;
                solveNQueensUtil(A, row + 1, board, result);
            }
        }
    }

    private boolean isSafe(int row, int col, int[] board) {
        for (int i = 0; i < row; i++) {
            if (board[i] == col || board[i] - col == i - row || board[i] - col == row - i) {
                return false;
            }
        }
        return true;
    }

    private ArrayList<String> generateBoard(int[] board) {
        ArrayList<String> temp = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < board.length; j++) {
                if (j == board[i]) {
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            temp.add(sb.toString());
        }
        return temp;
    }
}

