//Advanced DSA 3: Backtracking & Advanced Trees
// Lecture 1 | DSA: Maths: Combinatorics Basics & Prime Numbers

public class ConsecutiveNumbersSum {
    static int solve(int A) {
        int count = 0;

        // Try each possible length of a consecutive sequence.
        for (long k = 1; k * (k + 1) / 2 <= A; k++) {

            // Subtract the offset contributed by the first k - 1 steps.
            long remaining = A - k * (k - 1) / 2;

            // A valid sequence exists when the starting number is an integer.
            if (remaining % k == 0) {
                long start = remaining / k;

                // The starting number must be positive.
                if (start >= 1) {
                    count++;
                }
            }
        }

        return count;
    }
    static void main() {
        System.out.println(solve(5));
    }
}
