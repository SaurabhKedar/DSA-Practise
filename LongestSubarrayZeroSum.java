//Advanced DSA 3: Backtracking & Advanced Trees
// Lecture 11 | DSA: Hashing 3: Internal Implementation & Problems

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayZeroSum {
    static int solve(int[] A){
        // Store the first index at which each prefix sum appears.
        Map<Long, Integer> firstIndex = new HashMap<>();

        long prefixSum = 0;
        int maxLength = 0;

        for (int i = 0; i < A.length; i++) {
            prefixSum += A[i];

            // A zero prefix sum means the subarray from index 0 to i sums to zero.
            if (prefixSum == 0) {
                maxLength = i + 1;
            }
            // A repeated prefix sum means the intervening subarray sums to zero.
            else if (firstIndex.containsKey(prefixSum)) {
                int previousIndex = firstIndex.get(prefixSum);
                int length = i - previousIndex;
                maxLength = Math.max(maxLength, length);
            }
            // Keep the earliest index so a future match gives the longest length.
            else {
                firstIndex.put(prefixSum, i);
            }
        }

        return maxLength;
    }
    static void main() {
        int[] A = {1, -2, 1, 2};
        System.out.println(solve(A));

    }
}
