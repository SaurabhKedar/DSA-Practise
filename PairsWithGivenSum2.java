//Advanced DSA 3: Backtracking & Advanced Trees
// Lecture 2 | DSA: Lab Session on Prime Numbers & 2 Pointers

public class PairsWithGivenSum2 {
    private static int solve(int[] A, int B)
    {
        final long MOD = 1_000_000_007L;

        int left = 0;
        int right = A.length - 1;
        long count = 0;

        while (left < right) {
            long sum = (long) A[left] + A[right];

            if (sum < B) {
                // The sum is too small.
                // Increase the left value.
                left++;

            } else if (sum > B) {
                // The sum is too large.
                // Decrease the right value.
                right--;

            } else {
                // We found a valid sum.

                // If both values are equal, every remaining
                // element has this same value.
                if (A[left] == A[right]) {
                    long n = right - left + 1L;

                    // Choose any 2 distinct indices from n.
                    count += n * (n - 1) / 2;
                    count %= MOD;

                    break;
                }

                // Count duplicate occurrences on the left.
                long leftCount = 1;
                while (left + 1 < right
                        && A[left] == A[left + 1]) {
                    leftCount++;
                    left++;
                }

                // Count duplicate occurrences on the right.
                long rightCount = 1;
                while (right - 1 > left
                        && A[right] == A[right - 1]) {
                    rightCount++;
                    right--;
                }

                // Every left occurrence pairs with every
                // right occurrence.
                count = (count + leftCount * rightCount) % MOD;

                // Move past both groups of duplicates.
                left++;
                right--;
            }
        }

        return (int) (count % MOD);
    }
    static void main(){
        int[] A = {1, 1, 1, 1, 2, 2, 2, 2};
        System.out.println(solve(A, 3));
    }
}
