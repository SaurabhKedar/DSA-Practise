public class FastPowerFunction {
    static long power(int A, int B){
        if (A == 1){
            return 1;
        }
        if (B == 0){
            return 1;
        }
        long P = power(A, B / 2);

        if (B % 2 == 0){
            return P * P;
        }
        else {
            return P * P * A;
        }
    }
    static void main() {
        System.out.println(power(2, 10));
    }
}
