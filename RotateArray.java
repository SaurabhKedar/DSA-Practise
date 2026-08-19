public class RotateArray {

    // Function to reverse a part of the array from index 'start' to 'end'
    static int[] reverse(int[] A, int start, int end){

        // Swap elements from both ends moving toward center
        while (start < end){
            int temp = A[start];
            A[start] = A[end];
            A[end] = temp;

            start++;
            end--;
        }

        // Return the modified array (in-place change)
        return A;
    }

    // Function to rotate array to the right by K steps
    static void rotateAnArray(int[] A, int K){
        int n = A.length;

        // Handle cases where K > n
        K = K % n;

        /*
        Key Idea (Reversal Algorithm):

        Example:
        A = [1,2,3,4,5,6,7], K = 3

        Step 1: Reverse whole array
        → [7,6,5,4,3,2,1]

        Step 2: Reverse first K elements
        → [5,6,7,4,3,2,1]

        Step 3: Reverse remaining elements
        → [5,6,7,1,2,3,4]  (Final Answer)
        */

        // Step 1: Reverse entire array
        A = reverse(A, 0, n-1);

        // Step 2: Reverse first K elements
        A = reverse(A, 0, K-1);

        // Step 3: Reverse remaining elements
        A = reverse(A, K, n-1);

        // Print rotated array
        for (int a : A){
            System.out.print(a + " ");
        }
    }

    // Main method to test rotation
    static void main() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        // Rotate array by 4 positions to the right
        rotateAnArray(arr, 4);
    }
}

/*
⚡ Complexity
Time Complexity: O(n)
Space Complexity: O(1) ✅ (in-place, no extra space)
 */