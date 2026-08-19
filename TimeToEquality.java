public class TimeToEquality {

    // Function to calculate minimum time to make all elements equal
    static int timeToEquality(int[] A){

        // Initialize max with the smallest possible value
        int max = Integer.MIN_VALUE;
        int n = A.length;

        /*
        Step 1: Find the maximum element in the array
        Reason:
        We can only increment elements, so the best target
        is the maximum value present in the array
        */
        for (int i = 0; i < n; i++){
            max = Math.max(max, A[i]);
        }

        int time = 0;

        /*
        Step 2: Calculate total increments required
        For each element, we need (max - A[j]) increments
        */
        for (int j = 0; j < n; j++){
            time += max - A[j];
        }

        // Return total time (total increments)
        return time;
    }

    // Main method to test the function
    static void main() {
        int[] arr = {1, 2, 3};

        // Output: 3
        // Explanation:
        // (3-1) + (3-2) + (3-3) = 2 + 1 + 0 = 3
        System.out.println(timeToEquality(arr));
    }
}
/*
⚡ Complexity Analysis
🕒 Time Complexity
First loop (find max): O(n)
Second loop (calculate time): O(n)

👉 Total = O(n)

📦 Space Complexity
No extra data structures used
Only variables (max, time, n)

👉 Space = O(1) (constant space)
 */