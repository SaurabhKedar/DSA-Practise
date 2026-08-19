import java.util.Arrays;

public class MergeTwoSortedArrays {

    // This function merges two already sorted arrays A and B
    static int[] solve(final int[] A, final int[] B) {

        int n1 = A.length;   // size of first array
        int n2 = B.length;   // size of second array

        int[] ans = new int[n1 + n2]; // result array to store merged elements

        int idx = 0;   // pointer for ans array
        int aIdx = 0;  // pointer for array A
        int bIdx = 0;  // pointer for array B

        // Step 1: Compare elements from both arrays and insert smaller one
        while (aIdx < n1 && bIdx < n2) {
            if (A[aIdx] < B[bIdx]) {
                ans[idx] = A[aIdx]; // take element from A
                aIdx++;             // move A pointer
            } else {
                ans[idx] = B[bIdx]; // take element from B
                bIdx++;             // move B pointer
            }
            idx++; // move result pointer
        }

        // Step 2: Copy remaining elements of A (if any)
        // No comparison needed because they are already sorted
        while (aIdx < n1) {
            ans[idx] = A[aIdx];
            aIdx++;
            idx++;
        }

        // Step 3: Copy remaining elements of B (if any)
        while (bIdx < n2) {
            ans[idx] = B[bIdx];
            bIdx++;
            idx++;
        }

        return ans; // return merged sorted array
    }

    static void main(String[] args) {
        int[] A = {4, 7, 9};
        int[] B = {2, 11, 19};

        // Call merge function and print result
        System.out.println(Arrays.toString(solve(A, B)));
    }
}