public class ComputeNCr {
    static int solve(int A, int B, int C){
        // nCr = nC(n-r), so use the smaller side.
        B = Math.min(B, A - B);

        // C(n, 0) = 1
        long[] dp = new long[B + 1];
        dp[0] = 1;

        /*
         * Build Pascal's Triangle row by row.
         *
         * dp[j] represents C(i, j) for the current row.
         */
        for (int i = 1; i <= A; i++) {

            /*
             * Traverse backwards so that dp[j - 1]
             * still belongs to the previous row.
             */
            for (int j = Math.min(i, B); j >= 1; j--) {

                dp[j] = (dp[j] + dp[j - 1]) % C;
            }
        }

        return (int) dp[B];
    }
    static void main(String[] args){
        System.out.println(solve(41,27,143));
    }
}
