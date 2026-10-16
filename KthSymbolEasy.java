//Advanced DSA 3: Backtracking & Advanced Trees
// Lecture 4 | DSA: Backtracking

public class KthSymbolEasy {
    static int solve(int A, int B) {
        // Row 1 contains only the symbol 0.
        if (A == 1) {
            return 0;
        }

        // Find the parent symbol in the previous row.
        int parent = solve(A - 1, B / 2);

        // At an even index, the symbol matches its parent.
        if (B % 2 == 0) {
            return parent;
        }

        // At an odd index, the symbol is the opposite of its parent.
        return 1 - parent;
    }
    static void main() {
        System.out.println(solve(3, 0));
    }
}
