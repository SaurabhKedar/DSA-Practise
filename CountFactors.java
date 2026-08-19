public class CountFactors {

    // Function to count total number of factors of a number
    static int countOfFactors(int n) {

        // Convert negative numbers to positive
        n = Math.abs(n);

        // Edge case: 0 has infinite factors mathematically,
        // but here we return 0 to avoid undefined behavior
        if (n == 0) return 0;

        int count = 0;

        /*
        Brute force approach (O(n)) — check every number from 1 to n
        */
//        for (int i = 1; i <= n; i++) {
//            if (n % i == 0) {
//                count++;
//            }
//        }

        /*
        Optimized approach (O(√n)):

        Factors always come in pairs.
        Example: n = 36
        (1,36), (2,18), (3,12), (4,9), (6,6)

        So instead of going till n, we only go till √n
        */
        int sqrt = (int)Math.sqrt(n);
        for (int i = 1; i <= sqrt; i++) {

            // If i divides n completely, it is a factor
            if (n % i == 0) {

                // Check if both factors are same (perfect square case)
                // Example: 6 * 6 = 36 → count only once
                if (i == n / i) {
                    count++;
                } else {
                    // Otherwise count both i and n/i as separate factors
                    count += 2;
                }
            }
        }

        // Return total number of factors
        return count;
    }

    // Main method to test the function
    static void main() {
        int a = 36;

        // Print number of factors of 500
        System.out.println(countOfFactors(a));
    }
}