//Advanced DSA 3: Backtracking & Advanced Trees
// Lecture 4| DSA: Backtracking

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenerateAllParentheses2 {
    private static String[] generateParenthesis(int A){
        List<String> result = new ArrayList<>();

        // Start with no opening or closing parentheses.
        backtrack(A, 0, 0, "", result);

        // Convert the list to the required String[] output.
        return result.toArray(new String[0]);
    }

    private static void backtrack(int A, int open, int close, String current, List<String> result){
        // Both opening and closing parentheses are complete.
        if (open == A && close == A) {
            result.add(current);
            return;
        }

        // Option 1: Add '(' if opening parentheses remain.
        if (open < A) {
            backtrack(A, open + 1, close, current + "(", result);
        }

        // Option 2: Add ')' only if an opening parenthesis
        // is available to be matched.
        if (close < open) {
            backtrack(A, open, close + 1, current + ")", result);
        }
    }

    static void main(String[] args){
        System.out.println(Arrays.toString(generateParenthesis(6)));
    }
}
