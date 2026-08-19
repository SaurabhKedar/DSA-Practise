import javax.swing.*;
import java.util.HashMap;

public class CountPairSum {
    static int solve(int[] A, int B) {
        int n = A.length;
        HashMap<Integer, Integer> hm = new HashMap<>();
        int ans = 0;

        for (int i= 0; i < n; i++){
            int target = B - A[i];
            if (hm.containsKey(target)){
                ans += hm.get(target);
            }
            hm.put(A[i], hm.getOrDefault(A[i], 0) + 1);
        }
        return ans;
    }
    static void main() {
        int[] A = {3, 5, 1, 2};
        int B = 8;
        System.out.println(solve(A, B));
    }
}
