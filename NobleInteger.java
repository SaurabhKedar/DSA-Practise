import java.util.Arrays;

public class NobleInteger {
    static boolean isNobleIntegerExists(int[] A){
        Arrays.sort(A);
        int n = A.length;

        for (int i = 0; i < n; i++){
            if (i < n-1 && A[i] == A[i+1]){
                continue;
            }

            int greater = n - i - 1;
            if (A[i] == greater){
                return true;
            }
        }
        return false;
    }

    static void main(String[] args) {
        int[] arr = {3, 2, 1, 3};
        System.out.println(isNobleIntegerExists(arr));
    }
}
