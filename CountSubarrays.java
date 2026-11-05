//Advanced DSA 3: Backtracking & Advanced Trees
// Lecture 11 | DSA: Hashing 3: Internal Implementation & Problems

import java.util.HashMap;

public class CountSubarrays {
    static int solve(int[] A) {
        final long MOD = 1000000007L;

        HashMap<Integer, Integer> lastSeen = new HashMap<>();

        int left = 0;
        long answer = 0;

        for (int right = 0; right < A.length; right++) {

            if (lastSeen.containsKey(A[right])) {
                left = Math.max(left, lastSeen.get(A[right]) + 1);
            }

            lastSeen.put(A[right], right);

            // Number of unique subarrays ending at right
            answer += right - left + 1;
            answer %= MOD;
        }

        return (int) answer;
    }
    static void main() {
        int[] A = {1, 1, 3};
        System.out.println(solve(A));
    }
}
