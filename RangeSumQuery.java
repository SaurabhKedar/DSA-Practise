import java.util.Arrays;

public class RangeSumQuery {

    /*
        Problem:
        Given an array A and queries B[][],
        each query contains [L, R].
        We need to find sum of elements from index L to R.

        Approach: Prefix Sum
     */
    static long[] rangeSumQuery(int[] A, int[][] B){

        int n = A.length;

        // Edge case: empty array
        if (n == 0) return new long[0];

        /*
        Step 1: Build Prefix Sum Array
        pf[i] = sum of elements from index 0 to i
        */
        long[] pf = new long[n];
        pf[0] = A[0];

        for (int i = 1; i < n; i++){
            pf[i] = pf[i - 1] + A[i];
        }

        /*
        Step 2: Process Queries
        For each query [L, R]:

        If L == 0:
            sum = pf[R]
        Else:
            sum = pf[R] - pf[L - 1]
        */
        int m = B.length;
        long[] result = new long[m];

        for (int i = 0; i < m; i++){
            int L = B[i][0];
            int R = B[i][1];

            if (L == 0){
                result[i] = pf[R];
            } else {
                result[i] = pf[R] - pf[L - 1];
            }
        }

        // Return result array
        return result;
    }

    // Main method to test the solution
    static void main(String[] args) {

        int[] A = {1, 2, 3, 4, 5};
        int[][] B = {
                {0, 3},   // sum = 1+2+3+4 = 10
                {1, 2}    // sum = 2+3 = 5
        };

        // Call function
        long[] result = rangeSumQuery(A, B);

        // Proper way to print array
        System.out.println(Arrays.toString(result));
    }
}
/*
⚡ Complexity
🕒 Time Complexity
Prefix creation → O(n)
Each query → O(1)
Total → O(n + m) ✅
📦 Space Complexity
Prefix array → O(n)
Result array → O(m)
 */