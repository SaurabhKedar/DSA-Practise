import java.lang.reflect.Array;
import java.util.Arrays;

public class SmallestNumber {
    static int[] smallestNumber(int[] A) {
        int n = A.length;
        int[] freq = new int[10];
        for (int i = 0; i < n; i++){
            freq[A[i]]++;
        }

        int idx = 0;
        for (int i = 0; i < freq.length; i++){
            int f =  freq[i];
            for (int j = 1; j <= f; j++){
                A[idx] = i;
                idx++;
            }
        }

        return A;
    }
    static void main() {
        int[] A = {6, 3, 4, 2, 7, 2, 1, 0, 0};
        System.out.println(Arrays.toString(smallestNumber(A)));
    }
}
