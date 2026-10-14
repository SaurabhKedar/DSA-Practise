//Advanced DSA 3: Backtracking & Advanced Trees
// Lecture 2 | DSA: Lab Session on Prime Numbers & 2 Pointers

public class AnotherCountRectangles {
    //Brute-Force Approach
    static int solve(int[] A, int B){
        int n = A.length;
        long count = 0;
        int mod = 1_000_000_007;

        // Try every possible ordered pair.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                // Use long to avoid integer overflow.
                if ((long) A[i] * A[j] < B) {
                    count++;
                }
            }
        }

        return (int) (count % mod);
    }

    //Optimized Approach — Two Pointers
    static int solve2(int[] A, int B){
        int n = A.length;
        int left = 0;
        int right = n - 1;

        long count = 0;
        final int MOD = 1_000_000_007;

        while (left <= right) {

            // Use long because A[i] can be as large as 10^9.
            long area = (long) A[left] * A[right];

            if (area < B) {

                // Count both ordered pairs for each distinct index,
                // plus the single diagonal pair (A[left], A[left]).
                long pairs = 2L * (right - left) + 1;

                count = (count + pairs) % MOD;

                // The current left element has been fully processed.
                left++;

            } else {

                // The current right element cannot form a valid
                // pair with any remaining element.
                right--;
            }
        }

        return (int) count;
    }
    static void main() {
        int[] A = {1, 2};

        System.out.println(solve(A, 5));
        System.out.println(solve2(A, 5));
    }
}
