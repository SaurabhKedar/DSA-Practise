import javax.swing.plaf.IconUIResource;

public class SingleNumberII {
    static int singleNumber(final int[] A){
        int result = 0;

        for (int i = 0; i <= 31; i++){
            int cnt = 0;
            for (int j = 0; j < A.length; j++){
                if (((A[j] >> i) & 1) == 1){
                    cnt++;
                }
            }

            if (cnt % 3 != 0){
                result = result | (1 << i);
            }
        }

        return result;
    }
    static void main() {
        int[] A = {1, 2, 4, 3, 3, 2, 2, 3, 1, 1};
        System.out.println(singleNumber(A));
    }
}
