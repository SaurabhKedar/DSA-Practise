import java.util.Arrays;

public class SumOfEvenOddIndexedElements {

    /*
        Function to calculate sum of elements at ODD indices
        for each query range [L, R]
     */
    static int[] sumOfOddIndexedElementsInRange(int[] A, int[][] B){

        int n = A.length;

        /*
        Prefix array for odd indices:
        pfOdd[i] = sum of elements at odd indices from 0 to i
        */
        int[] pfOdd = new int[n];

        // Initialize first element
        // index 0 is even, but we still assign A[0] to maintain prefix continuity
        pfOdd[0] = 0;

        // Build prefix sum for odd indices
        for (int i = 1; i < n; i++){

            // If index is odd → include element
            if (i % 2 == 1){
                pfOdd[i] = pfOdd[i - 1] + A[i];
            }
            // If index is even → carry forward previous sum
            else {
                pfOdd[i] = pfOdd[i - 1];
            }
        }

        int rows = B.length;
        int[] result = new int[rows];

        /*
        Process each query using prefix sum
        */
        for (int j = 0; j < rows; j++){

            int s = B[j][0]; // start index
            int e = B[j][1]; // end index

            // If range starts from 0
            if (s == 0){
                result[j] = pfOdd[e];
            }
            // Otherwise subtract prefix before start
            else {
                result[j] = pfOdd[e] - pfOdd[s - 1];
            }
        }

        return result;
    }

    /*
        Function to calculate sum of elements at EVEN indices
        for each query range [L, R]
     */
    static int[] sumOfEvenIndexedElementsInRange(int[] A, int[][] B){

        int n = A.length;

        /*
        Prefix array for even indices:
        pfEven[i] = sum of elements at even indices from 0 to i
        */
        int[] pfEven = new int[n];

        // Initialize first element (index 0 is even)
        pfEven[0] = A[0];

        // Build prefix sum for even indices
        for (int i = 1; i < n; i++){

            // If index is even → include element
            if (i % 2 == 0){
                pfEven[i] = pfEven[i - 1] + A[i];
            }
            // If index is odd → carry forward previous sum
            else {
                pfEven[i] = pfEven[i - 1];
            }
        }

        int rows = B.length;
        int[] result = new int[rows];

        /*
        Process queries
        */
        for (int j = 0; j < rows; j++){

            int s = B[j][0];
            int e = B[j][1];

            if (s == 0){
                result[j] = pfEven[e];
            } else {
                result[j] = pfEven[e] - pfEven[s - 1];
            }
        }

        return result;
    }

    // Main method to test
    static void main() {

        int[] A = {5, 3, 5, 2, 6, 78, 98, 32, 41, 67, 76, 1, 2, 3, 5, 9, 87, 54, 21};

        int[][] B = {
                {1, 5},
                {4, 7},
                {2, 9},
                {1, 12},
        };

        // Print sum of even-indexed elements in each range
        System.out.println(Arrays.toString(sumOfEvenIndexedElementsInRange(A, B)));

        // Print sum of odd-indexed elements in each range
        System.out.println(Arrays.toString(sumOfOddIndexedElementsInRange(A, B)));
    }
}
/*
Complexity
🕒 Time Complexity
Build prefix arrays → O(n)
Process queries → O(m)
👉 Total = O(n + m) ✅
📦 Space Complexity
Two prefix arrays → O(n)
Result arrays → O(m)
 */