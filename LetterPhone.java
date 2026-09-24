import java.util.ArrayList;

public class LetterPhone {
    // Mapping of digits to corresponding letters
    private static String[] mapping = new String[]{
            "0",      // 0
            "1",      // 1
            "abc",    // 2
            "def",    // 3
            "ghi",    // 4
            "jkl",    // 5
            "mno",    // 6
            "pqrs",   // 7
            "tuv",    // 8
            "wxyz"    // 9
    };

    private static ArrayList<String> letterCombinations(String A) {
        ArrayList<String> result = new ArrayList<>();

        // Start building the combination from index 0
        backtrack(A, 0, result, "");

        return result;
    }

    private static void backtrack(
        String A,
        int index,
        ArrayList<String> result,
        String current
    ){
        // Base case:
        // We have processed all digits.
        if (index == A.length()){
            result.add(current);
            return;
        }

        // Get the current digit
        int digit = A.charAt(index) - '0';

        // Get the characters mapped to this digit
        String letters = mapping[digit];

        // Try every possible character
        for (int i = 0; i < letters.length(); i++) {

            // Choose a character
            char ch = letters.charAt(i);

            // Explore the next digit
            backtrack(
                    A,
                    index + 1,
                    result,
                    current + ch
            );

            // No explicit undo is required here
            // because String is immutable and
            // current + ch creates a new String.
        }

    }

    static void main() {
        System.out.println(letterCombinations("013"));
    }
}
