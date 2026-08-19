public class FirstMissingInteger {
    static int getMissingInteger(int[] A){
        int n = A.length;

        for (int i = 0; i < n; i++){
            if (A[i] <= 0){
                A[i] = n + 2;
            }
        }

        for (int i = 0; i < n; i++){
            int ele = Math.abs(A[i]);
            if (ele >= 1 && ele <= n){
                int idx = ele - 1;
                A[idx] = -1 * A[idx];
            }
        }

        for (int i = 0; i < n; i++){
            if (A[i] > 0){
                return i + 1;
            }
        }

        return n+1;
    }
    static void main() {
        int[] A = {1, 2, 0};
        System.out.println(getMissingInteger(A));
    }
}
