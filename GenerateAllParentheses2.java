import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenerateAllParentheses2 {
    private static String[] generateParenthesis(int A){
        List<String> result = new ArrayList<>();
        backtrack(A, 0, 0, "", result);
        return  result.toArray(new String[0]);
    }

    private static void backtrack(int A, int open, int close, String current, List<String> result){
        if (open == A && close == A){
            result.add(current);
            return;
        }

        if (open < A){
            backtrack(A, open + 1, close, current + "(", result);
        }

        if (close < open){
            backtrack(A, open, close + 1, current + ")", result);
        }

    }

    static void main(String[] args){
        System.out.println(Arrays.toString(generateParenthesis(6)));
    }
}
