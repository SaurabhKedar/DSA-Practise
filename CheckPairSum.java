//Advanced DSA 3: Backtracking & Advanced Trees
// Lecture 2 | DSA: Lab Session on Prime Numbers & 2 Pointers

import java.util.Arrays;
import java.util.HashSet;

public class CheckPairSum {

    //HashSet Approach
    static int solve(int A, int[] B) {
        // Store elements that have already been visited.
        HashSet<Integer> seen = new HashSet<>();

        for (int x : B) {

            // Find the element needed to reach the target sum.
            int complement = A - x;

            // If it was seen earlier, a valid pair exists.
            if (seen.contains(complement)) {
                return 1;
            }

            // Store the current element for future comparisons.
            seen.add(x);
        }

        // No valid pair was found.
        return 0;
    }

    static int solve2(int A, int[] B) {
        // Copy the array so the original input remains unchanged.
        int[] sorted = B.clone();

        // Two pointers require a sorted array.
        Arrays.sort(sorted);

        int left = 0;
        int right = sorted.length - 1;

        while (left < right) {

            int sum = sorted[left] + sorted[right];

            // The target sum has been found.
            if (sum == A) {
                return 1;
            }

            // The sum is too small; increase the left value.
            else if (sum < A) {
                left++;
            }

            // The sum is too large; decrease the right value.
            else {
                right--;
            }
        }

        // The pointers met without finding a valid pair.
        return 0;
    }

    static void main() {
        int A = 10;
        int[] B = {3, 5, 1, 2, 1, 2};

        System.out.println(solve(A, B));
        System.out.println(solve2(A, B));
    }
}
