public class EquilibriumIndexOfAnArray {

    // Function to find equilibrium index
    static int equilibriumIndexOfAnArray(int[] A){

        int n = A.length;

        /*
        Step 1: Build prefix sum from Left to Right
        pfLtR[i] = sum of elements from index 0 to i
        */
        int[] pfLtR = new int[n];
        pfLtR[0] = A[0];

        for (int i = 1; i < n; i++){
            pfLtR[i] = pfLtR[i - 1] + A[i];
        }

        /*
        Step 2: Build prefix sum from Right to Left
        pfRtL[i] = sum of elements from index i to n-1
        */
        int[] pfRtL = new int[n];
        pfRtL[n - 1] = A[n - 1];

        for (int i = n - 2; i >= 0; i--){
            pfRtL[i] = pfRtL[i + 1] + A[i];
        }

        /*
        Step 3: Find index where left sum == right sum
        */
        for (int m = 0; m < n; m++){
            if (pfLtR[m] == pfRtL[m]){
                return m;
            }
        }

        // If no equilibrium index found
        return -1;
    }

    static int equilibriumIndexOfAnArrayBetterApp(int[] A){
        int totalSum = 0;

        // Step 1: Calculate total sum
        for (int num : A){
            totalSum += num;
        }

        int leftSum = 0;

        // Step 2: Traverse and check equilibrium
        for (int i = 0; i < A.length; i++){

            // Right sum = total - left - current
            int rightSum = totalSum - leftSum - A[i];

            if (leftSum == rightSum){
                return i;
            }

            // Update left sum
            leftSum += A[i];
        }

        return -1;
    }

    static void main() {
        int[] A = {-7, 1, 5, 2, -4, 3, 0};

        // Output: 3
        System.out.println(equilibriumIndexOfAnArray(A));
        System.out.println(equilibriumIndexOfAnArrayBetterApp(A));
    }
}

/*
🕒 Time Complexity
Build pfLtR → O(n)
Build pfRtL → O(n)
Loop → O(n)
👉 Total = O(n)
📦 Space Complexity
Two arrays → O(n)
 */