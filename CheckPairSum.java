import java.util.HashSet;

public class CheckPairSum {
    static int solve(int A, int[] B) {
        int n = B.length;
        HashSet<Integer> set = new HashSet<>();

        for (int i= 0; i < n; i++){
            int target = A - B[i];
            if (set.contains(target)){
                return 1;
            }else {
                set.add(B[i]);
            }
        }

        return  0;
    }
    static void main() {
        int A = 10;
        int[] B = {3, 5, 1, 2, 1, 2};

        System.out.println(solve(A, B));
    }
}
