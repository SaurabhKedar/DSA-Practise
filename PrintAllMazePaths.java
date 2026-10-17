//Advanced DSA 3: Backtracking & Advanced Trees
// Lecture 5 | DSA: Lab Session on Backtracking

import java.util.ArrayList;
import java.util.Arrays;

public class PrintAllMazePaths {
    private static ArrayList<String> PrintAllPaths(int A, int B) {
        ArrayList<String> result = new ArrayList<>();
        backtrack("", result, 0, 0, A - 1, B - 1);
        return result;
    }

    private static void backtrack(
        String current,
        ArrayList<String> result,
        int currRow,
        int currCol,
        int destRow,
        int destCol
    ){
        // Stop if we move outside the grid boundaries.
        if (currRow > destRow || currCol > destCol) {
            return;
        }

        // If we reach the destination, save the complete path.
        if (currRow == destRow && currCol == destCol) {
            result.add(current);
            return;
        }

        // Option 1: Move Down.
        String newStr = current + "D";
        backtrack(newStr, result,
                currRow + 1, currCol, destRow, destCol);

        // Option 2: Move Right.
        newStr = current + "R";
        backtrack(newStr, result,
                currRow, currCol + 1, destRow, destCol);
    }
    static void main() {
        System.out.println(PrintAllPaths(3, 2));
    }
}
