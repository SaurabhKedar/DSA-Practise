import java.util.Arrays;

public class NextPermutation {
    static int[] nextPermutation(int[] A){
        int n = A.length;
        int i = n - 2;

        while (i >= 0 && A[i] >= A[i+1]){
            i--;
        }

        if (i >= 0){
            int j = n - 1;
            while (A[j] <= A[i]){
                j--;
            }

            int temp = A[i];
            A[i] = A[j];
            A[j] =  temp;
        }

        int s = i  + 1;
        int e = n - 1;
        while (s < e){
            int temp = A[s];
            A[s] = A[e];
            A[e] = temp;
            s++;
            e--;
        }

        return  A;
    }
    static void main() {
        int[] A = {2, 1, 5, 4, 3, 2, 6, 3, 3, 1, 1};
        System.out.println(Arrays.toString(nextPermutation(A)));
    }
}
