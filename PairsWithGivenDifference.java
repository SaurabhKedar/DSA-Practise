//Advanced DSA 3: Backtracking & Advanced Trees
// Lecture 3 | DSA: Lab Session on Maths & 2 Pointers

import java.util.Arrays;

public class PairsWithGivenDifference {
    static  int solve(int[] A, int B) {
        int n = A.length;
        Arrays.sort(A);

        int count = 0;

        if (B == 0){
            for (int i = 1; i < n; i++){
                if (A[i] == A[i - 1] && (i == 1 || A[i] != A[i - 2])){
                    count++;
                }
            }

            return  count;
        }

        int i = 0;
        int j = 1;

        while (j < n && i < n){
            if (i == j){
                j++;
                continue;
            }

            int diff = A[j] - A[i];

            if (diff < B){
                j++;
            }
            else if (diff > B){
                i++;
            }
            else {
                count++;

                int leftValue = A[i];
                int rightValue =A[j];

                while (i < n && A[i] == leftValue){
                    i++;
                }

                while (j < n && A[j] == rightValue){
                    j++;
                }
            }
        }

        return count;
    }
    static void main() {
        int[] A = {1, 5, 3, 4, 2};
        System.out.println(solve(A, 3));
    }
}
