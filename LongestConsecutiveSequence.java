import java.util.HashSet;

public class LongestConsecutiveSequence {
    static int longestConsecutive(final int[] A) {
        HashSet<Integer> set = new HashSet<>();
        for (int x : A){
            set.add(x);
        }

        int ans = 0;
        for (int x : A){
            int start = x - 1;
            if (!set.contains(start)){
                int count = 0;
                while (set.contains(start + 1) == true){
                    count++;
                    start++;
                }
                ans = Math.max(ans, count);
            }
        }

        return ans;
    }
    static void main() {
        int[] A = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(A));
    }
}
