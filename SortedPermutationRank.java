//Advanced DSA 3: Backtracking & Advanced Trees
// Lecture 3 | DSA: Lab Session on Maths & 2 Pointers

public class SortedPermutationRank {
    static int findRank(String A){
        int n = A.length();
        int MOD = 1000003;

        // Precompute factorials modulo MOD.
        long[] fact = new long[n + 1];
        fact[0] = 1;

        for (int i = 1; i <= n; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
        }

        // Rank is 1-based.
        long rank = 1;

        // Examine each character from left to right.
        for (int i = 0; i < n; i++) {
            int smaller = 0;

            // Count characters smaller than A.charAt(i)
            // among the characters to its right.
            for (int j = i + 1; j < n; j++) {
                if (A.charAt(j) < A.charAt(i)) {
                    smaller++;
                }
            }

            // Each smaller character can begin a block
            // of (n - i - 1)! permutations.
            long contribution =
                    (smaller * fact[n - i - 1]) % MOD;

            rank = (rank + contribution) % MOD;
        }

        return (int) rank;
    }
    static void main() {
        System.out.println(findRank("SAURABH"));
    }
}
