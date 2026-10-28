//Advanced DSA 3: Backtracking & Advanced Trees
// Lecture 7 | DSA: Trees 2: BST

import java.util.Arrays;

public class CheckForBSTWithOneChild {
    static String solve(int[] A) {
        int n = A.length;

        // One or two distinct values always form a valid one-child BST.
        if (n <= 2) {
            return "YES";
        }

        // Initially, every integer is within the valid range.
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;

        for (int i = 1; i < n; i++) {
            // Reject a value outside the boundaries established so far.
            if (A[i] < min || A[i] > max) {
                return "NO";
            }

            if (A[i] > A[i - 1]) {
                // Move to a right child; future values must exceed A[i - 1].
                min = A[i - 1];
            } else {
                // Move to a left child; future values must be below A[i - 1].
                max = A[i - 1];
            }
        }

        // Every value satisfied the valid range.
        return "YES";
    }
    static void main() {
        System.out.println(Arrays.toString(new int[]{4, 10, 5, 8}));
    }
}
