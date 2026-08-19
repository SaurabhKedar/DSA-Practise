public class CountOfElements {

    /*
        Problem:
        Count elements that have at least one element greater than themselves.

        Insight:
        Any element strictly less than the maximum element
        will always have at least one greater element.
     */
    static int countOfElements(int[] A){
        int n = A.length;

        // Edge case: empty array
        if (n == 0) return 0;

        // Step 1: Find maximum element
        int max = A[0];
        for (int i = 1; i < n; i++){
            max = Math.max(A[i], max);
        }

        int count = 0;

        // Step 2: Count elements smaller than max
        for (int i = 0; i < n; i++){
            if (A[i] < max){
                count++;
            }
        }

        // Return result
        return count;
    }

    // Main method
    static void main() {
        int[] arr = {1, 2, 4, 6, 90, 32, 65, 7, 8, 4, 5, 6, 21};

        System.out.println(countOfElements(arr));
    }
}