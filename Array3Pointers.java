//Advanced DSA 3: Backtracking & Advanced Trees
// Lecture 3 | DSA: Lab Session on Maths & 2 Pointers

public class Array3Pointers {
    static int minimize(final int[] A, final int[] B, final int[] C){
        int i = 0;
        int j = 0;
        int k = 0;
        int ans = Integer.MAX_VALUE;

        // Continue while all three arrays have elements.
        while (i < A.length && j < B.length && k < C.length) {
            int a = A[i];
            int b = B[j];
            int c = C[k];

            // Find the largest and smallest current values.
            int max = Math.max(a, Math.max(b, c));
            int min = Math.min(a, Math.min(b, c));

            // Save the best difference found so far.
            ans = Math.min(ans, max - min);

            // Advance one pointer at a minimum value.
            if (min == a) {
                i++;
            } else if (min == b) {
                j++;
            } else {
                k++;
            }
        }

        return ans;
    }
    static void main() {
        final int[] A = {1, 4, 10};
        final int[] B = {2, 15, 20};
        final int[] C = {10, 12};
        System.out.println(minimize(A, B, C));
    }
}
