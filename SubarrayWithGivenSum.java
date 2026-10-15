//Advanced DSA 3: Backtracking & Advanced Trees
// Lecture 3 | DSA: Lab Session on Maths & 2 Pointers

import java.util.Arrays;

public class SubarrayWithGivenSum {
    static int[] solve(int[] A, int B){
        int n = A.length;
        int left = 0;
        long sum = 0;

        for (int right = 0; right < n; right++){
            sum += A[right];

            while (sum > B && left <= right){
                sum -= A[left];
                left++;
            }

            if (sum == B){
                int length = right - left + 1;
                int[] result = new int[length];

                for (int i = 0; i < length; i++){
                    result[i] = A[left + i];
                }

                return result;
            }
        }

        return  new int[]{-1};
    }
    static void main() {
        int[] A = {1, 2, 3, 4, 5};

        System.out.println(Arrays.toString(solve(A, 5)));
    }
}
