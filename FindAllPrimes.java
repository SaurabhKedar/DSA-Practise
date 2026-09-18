import java.util.ArrayList;

public class FindAllPrimes {
    static boolean IsPrime(int n){
        if (n < 2){
            return false;
        }
        for (int i = 2; i * i <= n; i++){
            if (n % i == 0){
                return false;
            }
        }
        return true;
    }
    static ArrayList<Integer> solve(int A){
        ArrayList<Integer> primes = new ArrayList<>();
        boolean[] isPrime = new boolean[A + 1];

        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i <= A; i++){
            isPrime[i] = true;
        }

        for (int i = 2; i * i <= A; i++){
            if (!IsPrime(i)) continue;
            for (int j = i * i; j <= A; j += i){
                isPrime[j] = false;
            }
        }

        for (int k = 2; k <= A; k++){
            if (isPrime[k]){
                primes.add(k);
            }
        }

        return primes;
    }
    static void main(String[] args){
        System.out.println(solve(25));
    }
}
