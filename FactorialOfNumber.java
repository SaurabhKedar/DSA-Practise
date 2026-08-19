public class FactorialOfNumber {
    static int fact(int N){
        if (N <= 0){
            return 1;
        }
        return N *  fact(N - 1);
    }
    static void main() {
        System.out.println(fact(5));
    }
}
