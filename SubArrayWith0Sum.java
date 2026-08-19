import java.util.HashSet;

public class SubArrayWith0Sum {
    static int solve(int[] A) {
        HashSet<Long> set = new HashSet<>();
        long prefixSum = 0;

        for (int num : A) {
            prefixSum += num;

            if (prefixSum == 0 || set.contains(prefixSum)) {
                return 1;
            }

            set.add(prefixSum);
        }

        return 0;
    }
    static void main() {
        int[] A = {2,2,1,-3,4,3,1,-2,-3,2};
        System.out.println(solve(A));
    }
}
