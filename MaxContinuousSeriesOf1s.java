//Advanced DSA 3: Backtracking & Advanced Trees
// Lecture 3 | DSA: Lab Session on Maths & 2 Pointers

import java.util.Arrays;

public class MaxContinuousSeriesOf1s {
    static int[] maxone(int[] A, int B){
        int n = A.length;

        int left = 0;
        int zeros = 0;

        int bestStart = 0;
        int bestLength = 0;

        for (int right = 0; right < n; right++) {
            // Include the current element in the window.
            if (A[right] == 0) {
                zeros++;
            }

            // Shrink the window until at most B zeros remain.
            while (zeros > B) {
                if (A[left] == 0) {
                    zeros--;
                }
                left++;
            }

            // The current window is now valid.
            int currentLength = right - left + 1;

            // Update only for a strictly longer window to preserve the earliest start in a tie.
            if (currentLength > bestLength) {
                bestLength = currentLength;
                bestStart = left;
            }
        }

        // Return the indices of the best continuous sequence.
        int[] result = new int[bestLength];

        for (int i = 0; i < bestLength; i++) {
            result[i] = bestStart + i;
        }

        return result;
    }
    static void main() {
        int[] A = {1, 1, 0, 1, 1, 0, 0, 1, 1, 1};
        System.out.println(Arrays.toString(maxone(A, 2)));
    }
}
