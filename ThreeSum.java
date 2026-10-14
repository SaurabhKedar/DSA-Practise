//Advanced DSA 3: Backtracking & Advanced Trees
// Lecture 2 | DSA: Lab Session on Prime Numbers & 2 Pointers

import java.util.Arrays;

public class ThreeSum {

    //Brute Force
    static int threeSumClosest(int[] A, int B) {
        int n = A.length;

        // Initialize with the first valid combination.
        int closestSum = A[0] + A[1] + A[2];

        // Choose the first element.
        for (int i = 0; i < n - 2; i++) {

            // Choose the second element.
            for (int j = i + 1; j < n - 1; j++) {

                // Choose the third element.
                for (int k = j + 1; k < n; k++) {

                    int sum = A[i] + A[j] + A[k];

                    // Compare absolute distances from target B.
                    if (Math.abs(sum - B) < Math.abs(closestSum - B)) {
                        closestSum = sum;
                    }
                }
            }
        }

        return closestSum;
    }

    //Optimized Approach — Sorting + Two Pointers
    static int threeSumClosest2(int[] A, int B) {
        int n = A.length;

        // Step 1: Sort the array.
        Arrays.sort(A);

        // Step 2: Start with any valid triple.
        int closestSum = A[0] + A[1] + A[2];

        // Step 3: Fix the first element.
        for (int i = 0; i < n - 2; i++) {

            // Step 4: Initialize the two pointers.
            int left = i + 1;
            int right = n - 1;

            // Step 5: Search for the best pair.
            while (left < right) {
                int sum = A[i] + A[left] + A[right];

                // Update the answer if this sum is closer.
                if (Math.abs(sum - B)
                        < Math.abs(closestSum - B)) {
                    closestSum = sum;
                }

                // An exact match is the best possible answer.
                if (sum == B) {
                    return sum;
                }

                // Move pointers to improve the sum.
                if (sum < B) {
                    left++;    // Need a larger sum.
                } else {
                    right--;   // Need a smaller sum.
                }
            }
        }

        return closestSum;
    }

    static void main() {
        int[] A = {-1, 2, 1, -4};

        System.out.println(threeSumClosest(A, 1));

        System.out.println(threeSumClosest2(A, 1));
    }
}
