public class SpecialIndex {

    // Function to count number of special indices
    static int specialIndex(int[] A){

        int n = A.length;

        /*
        pfSe (prefix sum of even indices)
        pfSe[i] = sum of elements at even indices from 0 to i
        */
        int[] pfSe = new int[n];

        // index 0 is even
        pfSe[0] = A[0];

        for (int i = 1; i < n; i++){

            // If index is even → include element
            if (i % 2 == 0){
                pfSe[i] = pfSe[i - 1] + A[i];
            }
            // Else carry forward
            else {
                pfSe[i] = pfSe[i - 1];
            }
        }

        /*
        pfSo (prefix sum of odd indices)
        pfSo[i] = sum of elements at odd indices from 0 to i
        */
        int[] pfSo = new int[n];

        // index 0 is even → so odd sum is 0
        pfSo[0] = 0;

        for (int j = 1; j < n; j++){

            // If index is odd → include element
            if (j % 2 == 1){
                pfSo[j] = pfSo[j - 1] + A[j];
            }
            // Else carry forward
            else {
                pfSo[j] = pfSo[j - 1];
            }
        }

        int count = 0;

        /*
        Try removing each index k
        After removal:
        - Elements shift → parity (even/odd) changes after k
        */
        for (int k = 0; k < n; k++){

            int Se = 0; // sum of even indices after removal
            int So = 0; // sum of odd indices after removal

            /*
            Case 1: Removing first element
            Entire array shifts → even ↔ odd swap
            */
            if (k == 0){
                Se = pfSo[n - 1] - pfSo[k]; // odd becomes even
                So = pfSe[n - 1] - pfSe[k]; // even becomes odd
            }

            /*
            Case 2: Removing index k
            Left side remains same
            Right side shifts → parity flips
            */
            else {
                // Even sum = left even + right odd (after shift)
                Se = pfSe[k - 1] + (pfSo[n - 1] - pfSo[k]);

                // Odd sum = left odd + right even (after shift)
                So = pfSo[k - 1] + (pfSe[n - 1] - pfSe[k]);
            }

            // If even sum == odd sum → special index
            if (So == Se){
                count++;
            }
        }

        // Return total special indices
        return count;
    }

    // Main method
    static void main() {
        int[] arr = {2, 1, 6, 4};

        // Output: 1
        // Removing index 1 → array becomes [2,6,4]
        // Even sum = 2 + 4 = 6
        // Odd sum = 6 → equal
        System.out.println(specialIndex(arr));
    }
}

/*
⚡ Complexity
🕒 Time Complexity
Build prefix arrays → O(n)
Check each index → O(n)
👉 Total = O(n) ✅
📦 Space Complexity
Two prefix arrays → O(n)
 */