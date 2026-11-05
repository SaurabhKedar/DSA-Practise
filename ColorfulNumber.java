//Advanced DSA 3: Backtracking & Advanced Trees
// Lecture 11 | DSA: Hashing 3: Internal Implementation & Problems

import java.util.HashSet;

public class ColorfulNumber {
    static int colorful(int A) {

        // Convert the number into a string so digit order is preserved.
        String num = String.valueOf(A);
        int n = num.length();

        // Store products of consecutive digit sequences.
        HashSet<Long> products = new HashSet<>();

        // Choose each possible starting position.
        for (int i = 0; i < n; i++) {
            long product = 1;

            // Extend the sequence one digit at a time.
            for (int j = i; j < n; j++) {
                // Convert the current character digit into an integer.
                int digit = num.charAt(j) - '0';

                // Reuse the prior product and include the new digit.
                product *= digit;

                // A repeated product means the number is not colorful.
                if (products.contains(product)) {
                    return 0;
                }

                // Record this product for future duplicate checks.
                products.add(product);
            }
        }

        // Every consecutive sequence has a unique product.
        return 1;
    }

    static void main() {
        System.out.println(colorful(63));
//        System.out.println((int)'9');
//        System.out.println((int)'0');
    }
}
