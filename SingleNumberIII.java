import java.util.Arrays;

public class SingleNumberIII {
    static boolean isBitSet(int A, int i){
        if (((A >> i) & 1) == 1){
            return true;
        }
        return false;
    }

    static int[] singleNumber(final int[] A){
        int xorAll = 0;
        int n = A.length;

        for (int i = 0; i < n; i++){
            xorAll ^= A[i];
        }

        int pos = -1;
        for (int i = 0; i <= 31; i++){
            if (isBitSet(xorAll, i)){
                pos = i;
                break;
            }
        }

        int num1= 0;
        int num2 = 0;

        for (int i = 0; i < n; i++){
            if (isBitSet(A[i], pos)){
                num1 ^= A[i];
            }else {
                num2 ^= A[i];
            }
        }

        return new int[]{
                num1, num2
        };
    }
    static void main() {
        int[] A = {1, 2, 3, 1, 2, 4};
        System.out.println(Arrays.toString(singleNumber(A)));
    }
}
