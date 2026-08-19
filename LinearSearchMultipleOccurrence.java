public class LinearSearchMultipleOccurrence {

    // Function to count occurrences of element B in array
    static int multipleOccurrence(int[] A, int B){
        int n = A.length;
        int ans = 0;

        /*
        Simple linear search (correct and recommended)
        Time: O(n)
        */
//        for (int i = 0; i < n; i++){
//            if (A[i] == B){
//                ans++;
//            }
//        }

        /*
        Two-pointer approach (your idea)

        We check from both ends:
        - start pointer from beginning
        - end pointer from last

        ⚠️ BUT: this works correctly only if we handle middle element properly
        */
        int start = 0;
        int end = n - 1;

        while (start < end){

            // Check left side
            if (A[start] == B){
                ans++;
            }

            // Check right side
            if (A[end] == B){
                ans++;
            }

            start++;
            end--;
        }

        /*
        ⚠️ Important Fix:
        If array length is odd, one middle element is left unprocessed
        */
        if (start == end && A[start] == B){
            ans++;
        }

        return ans;
    }

    // Main method
    static void main() {
        int[] arr = {1, 2, 3, 4, 1, 2, 3, 5, 6, 7, 3, 4, 5, 7, 8, 7, 9, 3};

        // Count occurrences of 7
        System.out.println(multipleOccurrence(arr, 7));
    }
}