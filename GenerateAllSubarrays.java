import java.util.ArrayList;

public class GenerateAllSubarrays {

    // Function to generate all possible subarrays
    static ArrayList<ArrayList<Integer>> generateSubArrays(int[] A){

        int n = A.length;

        // This will store all subarrays
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        /*
        Outer loop: selects starting index of subarray
        */
        for (int i = 0; i < n; i++){

            /*
            Middle loop: selects ending index of subarray
            (always >= start index)
            */
            for (int j = i; j < n; j++){

                // Create a new list to store current subarray
                ArrayList<Integer> row = new ArrayList<>();

                /*
                Inner loop: builds subarray from index i to j
                */
                for (int k = i; k <= j; k++){
                    row.add(A[k]);
                }

                // Add constructed subarray to result
                result.add(row);
            }
        }

        // Return all subarrays
        return result;
    }

    // Main method to test
    static void main() {
        int[] arr = {1, 2, 3, 4, 5, 6};

        // Print all subarrays
        System.out.println(generateSubArrays(arr));
    }
}