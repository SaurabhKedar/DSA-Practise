public class MaximumANDPair {
    static int solve(int[] A) {
        int n = A.length;
        int ans = 0;
        for (int i = 31; i >= 0; i--){
            int cnt = 0;
            for (int j= 0; j < n; j++){
                if ((A[j] & (1 << i)) != 0){
                    cnt++;
                }
            }

            if (cnt >= 2){
                ans = ans | (1 << i);
                for (int j= 0; j < n; j++){
                    if ((A[j] & (1 << i)) == 0){
                        A[j] = 0;
                    }
                }
            }
        }
        return  ans;
    }
    static void main() {
        int[] A = {53, 39, 88};
        System.out.println(solve(A));
    }
}
