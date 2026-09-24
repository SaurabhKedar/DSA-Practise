import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenerateAllParentheses2 {
    private static String[] generateParenthesis(int A){
        // This list will store all valid combinations.
        List<String> result = new ArrayList<>();

        // Start the backtracking process.
        //
        // A      = total number of pairs we need
        // 0      = initially, 0 opening brackets are used
        // 0      = initially, 0 closing brackets are used
        // ""     = initially, our string is empty
        // result = list where we store answers
        backtrack(A, 0, 0, "", result);

        // Convert ArrayList<String> into String[]
        return result.toArray(new String[0]);
    }

    private static void backtrack(int A, int open, int close, String current, List<String> result){
        // ---------------------------------------------------------
        // BASE CASE
        // ---------------------------------------------------------
        //
        // If we have used all A opening brackets
        // AND all A closing brackets,
        // then we have created one complete valid combination.
        //
        // Example for A = 3:
        //
        // open  = 3
        // close = 3
        // current = "((()))"
        //
        // Add it to our answer.
        if (open == A && close == A) {
            result.add(current);
            return;
        }


        // ---------------------------------------------------------
        // CHOICE 1: ADD OPENING BRACKET '('
        // ---------------------------------------------------------
        //
        // We can add '(' as long as we haven't used
        // all A opening brackets.
        //
        // Example:
        //
        // A = 3
        // open = 2
        //
        // We can still add one more '('.
        //
        // But if:
        //
        // open = 3
        //
        // we cannot add another '('.
        if (open < A) {

            // Add '(' to the current string.
            //
            // open + 1 because we have used
            // one more opening bracket.
            //
            // close remains the same.
            backtrack(
                    A,
                    open + 1,
                    close,
                    current + "(",
                    result
            );
        }


        // ---------------------------------------------------------
        // CHOICE 2: ADD CLOSING BRACKET ')'
        // ---------------------------------------------------------
        //
        // We can add ')' ONLY when:
        //
        //     close < open
        //
        // Why?
        //
        // Because there must be an unmatched '('
        // available to close.
        //
        // Example:
        //
        // current = "(()"
        //
        // open  = 2
        // close = 1
        //
        // We have one unmatched '(',
        // so we can safely add ')'.
        //
        // But:
        //
        // current = "()"
        //
        // open  = 1
        // close = 1
        //
        // We CANNOT add ')' because that would produce:
        //
        // "() )"
        //
        // which is invalid.
        if (close < open) {

            // Add ')' to the current string.
            //
            // close + 1 because we have used
            // one more closing bracket.
            //
            // open remains the same.
            backtrack(
                    A,
                    open,
                    close + 1,
                    current + ")",
                    result
            );
        }
    }

    static void main(String[] args){
        System.out.println(Arrays.toString(generateParenthesis(6)));
    }
}
