import java.util.ArrayList;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("Give a value of n (0 to 10). Or press -1 to exit.");
            int n = input.nextInt();

            if (n == -1) {
                break;
            }

            Solution solution = new Solution();
            ArrayList<ArrayList<String>> result = solution.solveNQueens(n);

            System.out.println("Number of distinct solutions: " + result.size());
            for (ArrayList<String> board : result) {
                System.out.println("Solution:");
                for (String row : board) {
                    System.out.println(row);
                }
                System.out.println();
            }
        }

        input.close();

    }
}