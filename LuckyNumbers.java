//Advanced DSA 3: Backtracking & Advanced Trees
// Lecture 2 | DSA: Lab Session on Prime Numbers & 2 Pointers

public class LuckyNumbers {

    //Brute-force
    static int solve(int A) {
        int luckyCount = 0;

        // Check every number from 1 to A.
        for (int num = 1; num <= A; num++) {
            int distinctFactors = 0;
            int remaining = num;

            // Try dividing by every possible divisor.
            for (int divisor = 2; divisor <= remaining; divisor++) {
                if (remaining % divisor == 0) {
                    distinctFactors++;

                    // Remove all occurrences of this factor.
                    while (remaining % divisor == 0) {
                        remaining /= divisor;
                    }
                }
            }

            if (distinctFactors == 2) {
                luckyCount++;
            }
        }

        return luckyCount;
    }

    //Optimized Approach — Sieve of Eratosthenes
    static int solve2(int A) {
        // primeFactors[i] stores the number of distinct
        // prime factors of i.
        int[] primeFactors = new int[A + 1];

        // Find primes and count their contribution
        // to every multiple.
        for (int p = 2; p <= A; p++) {

            // A zero count means p is prime.
            if (primeFactors[p] == 0) {

                // Each multiple of p gets one additional
                // distinct prime factor.
                for (int multiple = p;
                     multiple <= A;
                     multiple += p) {

                    primeFactors[multiple]++;
                }
            }
        }

        int luckyCount = 0;

        // Count numbers having exactly two distinct
        // prime factors.
        for (int num = 2; num <= A; num++) {
            if (primeFactors[num] == 2) {
                luckyCount++;
            }
        }

        return luckyCount;
    }

    static void main() {
        System.out.println(solve(12));

        System.out.println(solve2(12));
    }
}
