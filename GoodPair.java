import java.util.HashSet;

public class GoodPair {

    // Function to check if any pair exists whose sum = B
    static int goodPair(int[] arr, int B){
        int n = arr.length;

        /*
        Brute force approach (O(n^2)) - check every pair
        */
//        for (int i = 0; i < n; i++){
//            for (int j = i + 1; j < n; j++){
//                if (arr[i] + arr[j] == B){
//                    return  1;
//                }
//            }
//        }

        /*
        Optimized approach using HashSet (O(n))

        Idea:
        For each element arr[i], we check if (B - arr[i]) already exists.
        If yes → we found a pair.
        */

        // HashSet to store elements we have seen so far
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++){

            // Find the required value to form sum B
            int target = B - arr[i];

            // Check if the required element is already present
            if (set.contains(target)){
                return 1;  // Pair found
            }

            // Add current element to set for future checks
            set.add(arr[i]);
        }

        // If no pair found
        return  0;
    }

    // Main method to test the function
    static void main() {
        int[] arr = {1, 2, 3, 4, 5, 1, 5, 7, 8, 9, 5 };

        // Check if any pair sums to 4
        System.out.println(goodPair(arr, 4));

    }
}