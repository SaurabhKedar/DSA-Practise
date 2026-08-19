import java.util.HashSet;

public class CountDistinctElements {
    static int solve(int[] A) {
        int n = A.length;
        HashSet<Integer> set = new HashSet<>();

        for (int x : A){
            set.add(x);
        }

        return set.size();
    }
    static void main() {
        int[] A = {3, 4, 3, 6, 6};
        System.out.println(solve(A));
    }
}
