//Advanced DSA 3: Backtracking & Advanced Trees
// Lecture 3 | DSA: Lab Session on Maths & 2 Pointers

public class ExcelColumnTitle {

    static String convertToTitle(int A){
        StringBuilder result = new StringBuilder();

        while (A > 0) {
            A--; // Convert to zero-based indexing

            int remainder = A % 26;

            // Map 0 to A, 1 to B, ..., 25 to Z
            char ch = (char) ('A' + remainder);
            result.append(ch);

            // Move to the next position
            A = A / 26;
        }

        // Characters were generated from right to left
        return result.reverse().toString();
    }

    static void main() {
        System.out.println(convertToTitle(635));
    }
}
