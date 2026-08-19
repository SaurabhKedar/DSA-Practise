public class SpecialSubsequences {

    // Function to count number of "AG" subsequences
    static long countOfSpecialSubSeqPairs(String s){

        int n = s.length();

        /*
        Step 1: Build prefix array for count of 'G'

        pfG[i] = number of 'G' characters from index 0 to i
        */
        long[] pfG = new long[n];

        // Initialize first element
        pfG[0] = (s.charAt(0) == 'G') ? 1 : 0;

        // Build prefix sum for 'G'
        for (int i = 1; i < n; i++){

            // Carry forward previous count
            pfG[i] = pfG[i - 1];

            // If current character is 'G', increment count
            if (s.charAt(i) == 'G'){
                pfG[i]++;
            }
        }

        /*
        Step 2: Count pairs

        For every 'A', count how many 'G' exist to its right

        Number of G after index j:
        = total G - G till index j
        = pfG[n-1] - pfG[j]
        */
        long countOfPairs = 0;

        for (int j = 0; j < n; j++){

            // If current character is 'A'
            if (s.charAt(j) == 'A'){

                // Add number of 'G' after this 'A'
                countOfPairs += pfG[n - 1] - pfG[j];
            }
        }

        // Return total "AG" subsequences
        return countOfPairs;
    }

    // Main method to test
    static void main() {
        String s = "ABCGAGAGAGAAAGAGAGAGAGAGGGGAGGAGGAGGAGGAGGAGAGGGAGAAAGAGGAGGAGGAAGGA";

        System.out.println("Using prefix sum : " + countOfSpecialSubSeqPairs(s));

        int countA = 0;
        int countOfPairs = 0;
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (c == 'A'){
                countA++;
            } else if (c == 'G') {
                countOfPairs += countA;
            }
            //TC -> O(n)
            //SC -> O(1)
        }
        System.out.println("Using constant space : " + countOfPairs);
    }
}

/*
🔥 Key Insight (VERY IMPORTANT)

👉 You are counting subsequences "AG", not substrings.

Meaning:

'A' comes before 'G'
Not necessarily adjacent
⚡ Complexity
🕒 Time Complexity
Prefix array → O(n)
Counting loop → O(n)
👉 Total = O(n) ✅
 */