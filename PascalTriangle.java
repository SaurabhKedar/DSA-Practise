//Advanced DSA 3: Backtracking & Advanced Trees
// Lecture 2 | DSA: Lab Session on Prime Numbers & 2 Pointers

import java.util.Arrays;

public class PascalTriangle {
    private static int[][] solve(int A) {
        // Create an A x A array.
        // All positions are initialized to 0 in Java.
        int[][] result = new int[A][A];

        // Build Pascal's Triangle one row at a time.
        for (int i = 0; i < A; i++) {

            // The first element of every row is always 1.
            result[i][0] = 1;

            // Calculate the middle elements.
            // Each element is the sum of the two elements
            // directly above it in the previous row.
            for (int j = 1; j < i; j++) {
                result[i][j] =
                        result[i - 1][j - 1] +
                                result[i - 1][j];
            }

            // The last meaningful element is always 1.
            // Skip this for the first row, whose first
            // element is already 1.
            if (i > 0) {
                result[i][i] = 1;
            }
        }

        return result;
    }

    static void main()
    {
        int[][] matrix = solve(5);

        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}
