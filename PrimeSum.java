import java.util.Arrays;

public class PrimeSum {
    private static boolean isPrime(int n){
        if (n < 2) return false;
        int sqrt = (int)Math.sqrt(n);
        for (int i = 2; i <= sqrt; i++){
            if (n % i == 0)
            {
                return  false;
            }
        }
        return true;
    }
    private  static boolean[] sieve(int A){
        boolean[] isPrimes = new boolean[A + 1];

        isPrimes[0] = false;
        isPrimes[1] = false;

        for (int i = 2; i <= A; i++){
            isPrimes[i] = true;
        }

        int sqrt = (int)Math.sqrt(A);
        for (int i = 2; i <= sqrt; i++){
            if (!isPrime(i)) continue;
            for (int multiple = i * i; multiple <= A; multiple += i){
                isPrimes[multiple] = false;
            }
        }

        return isPrimes;
    }
    private static int[] primeSum(int A){
//        1. Brute Force Approach
//        for (int p = 2; p <= A / 2; p++){
//            int q = A - p;
//            if (isPrime(p) && isPrime(q)){
//                return new int[] {p, q};
//            }
//        }

        //2. Sieve of Eratosthenes
        boolean[] isPrimes = sieve(A);
        for (int p = 2; p <= A /2; p++) {
            int q = A - p;
            if (isPrimes[p] && isPrimes[q]) {
                return new int[]{p, q};
            }
        }
        return new int[]{};
    }
    static void main(String[] args){
        System.out.println(Arrays.toString(primeSum(10)));
    }
}
