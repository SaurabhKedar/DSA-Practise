//Advanced DSA 3: Backtracking & Advanced Trees
// Lecture 2 | DSA: Lab Session on Prime Numbers & 2 Pointers

import java.util.Arrays;

public class ClosestPairFromSortedArrays {
    //Brute Force Approach
    static int[] solve(int[] A, int[] B, int C) {
        int n = A.length;
        int m = B.length;

        int minDiff = Integer.MAX_VALUE;
        int[] answer = new int[2];

        // Try every possible pair, preserving index order.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int sum = A[i] + B[j];
                int diff = Math.abs(sum - C);

                // Strictly smaller: preserve the first pair on ties.
                if (diff < minDiff) {
                    minDiff = diff;
                    answer[0] = A[i];
                    answer[1] = B[j];
                }
            }
        }

        return answer;
    }


    //Optimized Approach — Two Pointers
    static int[] solve2(int[] A, int[] B, int C){
        int n = A.length;
        int m = B.length;

        int i = 0;       // Start of A
        int j = m - 1;   // End of B

        int minDiff = Integer.MAX_VALUE;
        int bestI = 0;
        int bestJ = 0;

        while (i < n && j >= 0) {
            int sum = A[i] + B[j];
            int diff = Math.abs(sum - C);

            // Prefer a smaller difference, then smaller indices.
            if (diff < minDiff ||
                    (diff == minDiff &&
                            (i < bestI || (i == bestI && j < bestJ)))) {

                minDiff = diff;
                bestI = i;
                bestJ = j;
            }

            // An exact sum cannot be improved.
            if (sum == C) {
                break;
            } else if (sum > C) {
                j--;
            } else {
                i++;
            }
        }

        return new int[] { A[bestI], B[bestJ] };
    }
    static void main() {
        int[] A = {1, 2, 3, 4, 5};
        int[] B = {2, 4, 6, 8};

        System.out.println(Arrays.toString(solve(A, B, 9)));

        System.out.println(Arrays.toString(solve2(A, B, 9)));
    }
}
