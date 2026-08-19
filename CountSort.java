import java.util.Arrays;

public class CountSort {
    static int[] solve(int[] A) {
        int n = A.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++){
            min = Math.min(A[i], min);
            max = Math.max(A[i], max);
        }

        int range = max - min + 1;
        int[] freqArr = new int[range];

        for (int i = 0; i < n; i++){
            freqArr[A[i] - min]++;
        }

        int idx = 0;
        for (int i = 0; i < range; i++){
            int f = freqArr[i];
            for (int j = 1; j <= f; j++){
                A[idx] = i + min;
                idx++;
            }
        }

        return A;
    }
    static void main() {
        //1 <= |A| <= 10 ^ 5
        //1 <= A[i] <= 10 ^ 5
        int[] A = {1, 3, 1};
        System.out.println(Arrays.toString(solve(A)));
    }
}
