//Advanced DSA 3: Backtracking & Advanced Trees
// Lecture 3 | DSA: Lab Session on Maths & 2 Pointers
public class ExcelColumnNumber {
    static int titleToNumber(String A){
        int result = 0;

        // Process each character from left to right
        for (int i = 0; i < A.length(); i++) {
            char ch = A.charAt(i);

            // Convert A-Z into values 1-26
            int value = ch - 'A' + 1;

            // Shift the previous value by one base-26 position
            result = result * 26 + value;
        }

        return result;
    }
    static void main() {
        System.out.println(titleToNumber("AB"));
    }
}
