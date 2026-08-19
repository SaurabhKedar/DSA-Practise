import java.util.HashMap;

public class FirstNonRepeatingElement {
    static int solve(int[] A){
        int n = A.length;
        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int x : A){
            hm.put(x, hm.getOrDefault(x, 0) + 1);
        }

        for (int x : A){
            if (hm.get(x) == 1){
                return x;
            }
        }

        return -1;
    }

    static void main() {
        int[] A = {1, 2, 3, 1, 2, 5};
        System.out.println(solve(A));
    }
}
