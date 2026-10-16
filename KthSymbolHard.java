//Advanced DSA 3: Backtracking & Advanced Trees
// Lecture 4 | DSA: Backtracking

public class KthSymbolHard {
    static int solve(int A, long B){
        // Begin tracing the requested symbol back to row 1.
        return backtrack(A, B);
    }

    static int backtrack(int row, long index){
        // The first row contains only symbol 0.
        if (row == 1) {
            return 0;
        }

        // Find the parent's symbol in the previous row.
        int parent = backtrack(row - 1, index / 2);

        // Even indexes preserve the parent symbol.
        if (index % 2 == 0) {
            return parent;
        }

        // Odd indexes contain the opposite of the parent symbol.
        return 1 - parent;
    }
    static void main() {
        System.out.println(solve(3, 0));
    }
}
