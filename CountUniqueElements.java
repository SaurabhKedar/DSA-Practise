import java.util.HashMap;

public class CountUniqueElements {
    static int solve(int[] A) {
        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int x : A){
            hm.put(x, hm.getOrDefault(x, 0) + 1);
        }

        int ans = 0;
        for (int x : A){
            if (hm.get(x) == 1){
                ans++;
            }
        }

        return ans;
    }
    static void main() {
        int[] A = {3, 3, 3, 9, 0, 1, 0};
        System.out.println(solve(A));
    }
}
