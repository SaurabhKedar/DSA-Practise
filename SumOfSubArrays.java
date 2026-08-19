public class SumOfSubArrays {
    /**
     * Calculates the sum of all elements of all possible subarrays.
     * Logic: An element at index 'i' appears in (i + 1) * (n - i) subarrays.
     */
    static long subArraysSum(int[] A){
        int n = A.length;
        long totalSum = 0;

        for (int i = 0; i < n; i++){
            // Number of subarrays starting at or before 'i' is (i + 1)
            // Number of subarrays ending at or after 'i' is (n - i)
            // Frequency of A[i] = (i + 1) * (n - i)
            long frequency = (long)(i + 1) * (n - i);

            // Add (value * frequency) to the total sum
            totalSum += (long)A[i] * frequency;
        }

        return totalSum;
    }

    public static void main(String[] args){
        int[] A = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        // Output the result
        System.out.println("Sum of all subarrays: " + subArraysSum(A));
    }
}