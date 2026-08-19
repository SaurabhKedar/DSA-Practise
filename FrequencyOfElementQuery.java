import java.util.Arrays;
import java.util.HashMap;

public class FrequencyOfElementQuery {
    static int[] solve(int[] A, int[] B) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int n = A.length;
        int q = B.length;

        for (int i = 0; i < n; i++){
            if (hm.containsKey(A[i])){
                int val = hm.get(A[i]) + 1;
                hm.put(A[i], val);
            }else {
                hm.put(A[i], 1);
            }
        }

        int[] ans = new int[q];
        for (int i = 0; i < q; i++){
            if (hm.containsKey(B[i])){
                ans[i] = hm.get(B[i]);
            }else {
                ans[i] = 0;
            }
        }

        return ans;
    }
    static void main() {
        int[] A = {1, 2, 1, 1};
        int[] B = {1, 2};

        System.out.println(Arrays.toString(solve(A, B)));
    }
}
