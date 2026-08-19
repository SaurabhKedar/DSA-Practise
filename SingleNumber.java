public class SingleNumber {
    static int singleNumber(final int[] A){
        //Approach 1
//        int ans = 0;
//        for (int i = 0; i < A.length; i++){
//            ans = ans ^ A[i];
//            System.out.println(ans);
//        }
//        return ans;

        //Approach 2
        int result = 0;

        for (int i = 0; i <= 31; i++){
            int cnt = 0;
            for (int j = 0; j < A.length; j++){
                if (((A[j] >> i) & 1) == 1){
                    cnt++;
                }
            }

            if (cnt % 2 != 0){
                result = result | (1 << i);
            }
        }

        return result;
    }
    static void main() {
        int[] A = {1, 2, 2, 3, 1};
        System.out.println(singleNumber(A));
    }
}
