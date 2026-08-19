import java.util.Arrays;

public class AllIndicesOfArray {
    static int[] allIndices(int[] A, int B) {
        return recur(A, B, 0, 0);
    }

    static int[] recur(int[] A, int B, int idx, int cnt){
        if (idx == A.length){
            return new int[cnt];
        }
        int[] ans;
        if (A[idx] == B){
            ans = recur(A, B, idx + 1, cnt + 1);
            ans[cnt] = idx;
        }else {
            ans = recur(A, B, idx + 1, cnt);
        }
        return ans;
    }
    static void main() {
        int[] A = {1, 2, 1, 4, 1};
        int B = 1;
        System.out.println(Arrays.toString(allIndices(A, B)));
    }
}
