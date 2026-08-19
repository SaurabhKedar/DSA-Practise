public class MaximumSubarray {
    /**
     * Finds the maximum subarray sum that does not exceed B.
     * @param A The input array of integers
     * @param B The threshold value
     * @return The largest sum <= B
     */
    static long maxSubArraySum(int[] A, int B) {
        int n = A.length;

        // Step 1: Build the Prefix Sum array
        // pf[i] stores the sum of all elements from A[0] to A[i]
        int[] pf = new int[n];
        pf[0] = A[0];
        for (int i = 1; i < n; i++) {
            pf[i] = pf[i - 1] + A[i];
        }

        long ans = 0;

        // Step 2: Iterate through all possible subarray ranges [i, j]
        for (int i = 0; i < n; i++) { // Starting index
            for (int j = i; j < n; j++) { // Ending index
                long sum = 0;

                // Step 3: Calculate sum of A[i...j] in O(1) time using Prefix Sums
                if (i == 0) {
                    sum = pf[j];
                } else {
                    // Sum from i to j is (Sum from 0 to j) - (Sum from 0 to i-1)
                    sum = pf[j] - pf[i - 1];
                }

                // Step 4: Update 'ans' if current sum is within limit and better than previous best
                if (sum <= B) {
                    ans = Math.max(sum, ans);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] A = {2, 1, 3, 4, 5};
        int B = 11;

        // Should output the maximum sum <= 11 (which is 10 in this case: 1+3+4)
        System.out.println("Maximum Subarray Sum <= B: " + maxSubArraySum(A, B));
    }
}