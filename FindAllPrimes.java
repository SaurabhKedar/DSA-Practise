//Advanced DSA 3: Backtracking & Advanced Trees
// Lecture 1 | DSA: Maths: Combinatorics Basics & Prime Numbers


import java.util.ArrayList;

public class FindAllPrimes {

    // Checks whether a number n is prime or not.
    static boolean IsPrime(int n) {

        // Numbers less than 2 are not prime.
        if (n < 2) {
            return false;
        }

        // We only need to check divisors up to sqrt(n).
        // If n has a factor greater than sqrt(n),
        // its corresponding factor must be smaller than sqrt(n).
        int sqrtN = (int) Math.sqrt(n);

        // Check whether any number from 2 to sqrt(n)
        // divides n completely.
        for (int i = 2; i <= sqrtN; i++) {

            // If the remainder is 0, n has another factor
            // and therefore is not a prime number.
            if (n % i == 0) {
                return false;
            }
        }

        // No divisor was found, so n is prime.
        return true;
    }

    // Returns all prime numbers from 1 to A.
    static ArrayList<Integer> solve(int A) {

        // Stores all the prime numbers found.
        ArrayList<Integer> primes = new ArrayList<>();

        // isPrime[i] tells us whether the number i is prime.
        // Initially, every boolean value is false.
        boolean[] isPrime = new boolean[A + 1];

        // 0 and 1 are not prime numbers.
        isPrime[0] = isPrime[1] = false;

        // Initially, assume every number from 2 to A is prime.
        for (int i = 2; i <= A; i++) {
            isPrime[i] = true;
        }

        // Sieve of Eratosthenes:
        // Process numbers only up to sqrt(A).
        for (int i = 2; i * i <= A; i++) {

            // If i is not prime, skip it.
            // Its multiples have already been marked.
            if (!IsPrime(i)) {
                continue;
            }

            // Mark all multiples of i as non-prime.
            // Start at i * i because smaller multiples
            // have already been handled by smaller factors.
            for (int j = i * i; j <= A; j += i) {
                isPrime[j] = false;
            }
        }

        // Collect all numbers that remain marked as prime.
        // Iterating in increasing order keeps the result sorted.
        for (int k = 2; k <= A; k++) {

            // If isPrime[k] is true, k is a prime number.
            if (isPrime[k]) {
                primes.add(k);
            }
        }

        // Return the list containing all prime numbers.
        return primes;
    }

    public static void main(String[] args) {

        // Find and print all prime numbers from 1 to 25.
        System.out.println(solve(25));
    }
}

