import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class CommonElements {
    static int[] solve(int[] A, int[] B){
        HashMap<Integer, Integer> freq = new HashMap<>();

        // Store frequency of elements from A
        for (int x : A){
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }

        ArrayList<Integer> result = new ArrayList<>();

        // Check elements in B
        for (int num : B) {
            if (freq.containsKey(num) && freq.get(num) > 0) {
                result.add(num);
                freq.put(num, freq.get(num) - 1);
            }
        }

        // Convert ArrayList to int[]
        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }

        return ans;
    }

    static void main() {
        int[] A = {1, 2, 2, 1};
        int[] B = {2, 3, 1, 2};
        System.out.println(Arrays.toString(solve(A, B)));
    }
}
