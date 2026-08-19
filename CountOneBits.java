public class CountOneBits {
    static int countSetBits(int A){
        int count = 0;

        //Approach  1 : Integer has 32 bits
//        for (int i = 0; i <= 31; i++){
//            if (((A >> i) & 1) == 1){
//                count++;
//            }
//        }

        //Approach 2
        while (A > 0){
            if ((A & 1) == 1){
                count++;
            }
            A = A >> 1;
        }

        return count;
    }
    static void main() {
        int A = 54;
        System.out.println(countSetBits(A));
    }
}
