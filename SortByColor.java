import java.util.Arrays;

public class SortByColor {
    static int[] sortColors(int[] A) {
        int n = A.length;
        int[] freq = new int[3];
        for (int i = 0; i < n; i++){
            freq[A[i]]++;
        }

        int idx = 0;
        for (int i = 0; i < freq.length; i++){
            int f = freq[i];
            for (int j = 1; j <= f; j++){
                A[idx] = i;
                idx++;
            }
        }
        return A;
    }
    static void main() {
        int[] A = {0, 1, 2, 0, 1, 2};
        System.out.println(Arrays.toString(sortColors(A)));
    }
}
