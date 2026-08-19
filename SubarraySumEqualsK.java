import java.util.HashMap;

public class SubarraySumEqualsK {
    static int solve(int[] A, int B) {
        HashMap<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);

        long prefixSum = 0;
        int count = 0;

        for (int num : A) {
            prefixSum += num;

            // Number of previous prefix sums equal to (prefixSum - B)
            count += map.getOrDefault(prefixSum - B, 0);

            // Store current prefix sum
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }

    static void main() {
        int[] A = {1, 0, 1};
        System.out.println(solve(A, 2));
    }
}
