public class SecondLargest {

    // Function to find second largest element in array
    static int secondLargetElement(int[] A){
        int n = A.length;

        // Initialize largest and second largest with minimum value
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        /*
        Traverse the array once
        */
        for (int i = 0; i < n; i++){

            // If current element is greater than largest
            if (A[i] > largest){

                // Update second largest before changing largest
                secondLargest = largest;

                // Update largest
                largest = A[i];
            }

            /*
            If current element is:
            - greater than secondLargest
            - AND smaller than largest (to avoid duplicate of largest)
            */
            else if (A[i] > secondLargest && A[i] < largest){
                secondLargest = A[i];
            }
        }

        // Return second largest element
        return (secondLargest == Integer.MIN_VALUE ? -1 : secondLargest);
    }

    // Main method to test
    static void main() {
        int[] arr = {1, 1, 1};//{5, 6, 3, 4, 5, 12, 67, 32, 87, 43};

        // Output: 67 (largest = 87, second largest = 67)
        System.out.println(secondLargetElement(arr));
    }
}

/*
⚡ Complexity
🕒 Time Complexity
Single loop → O(n)
📦 Space Complexity
Only variables used → O(1)
🔥 Key Insight (very important)

👉 “Track both largest and second largest in one pass.”
 */