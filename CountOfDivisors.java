//Advanced DSA 3: Backtracking & Advanced Trees
// Lecture 2 | DSA: Lab Session on Prime Numbers & 2 Pointers

import java.util.ArrayList;
import java.util.Arrays;

public class CountOfDivisors {
    static ArrayList<Integer> solve(ArrayList<Integer> A){
        ArrayList<Integer> result = new ArrayList<>();

        for (int num : A){
            int count = 0;
            int sqrt = (int)Math.sqrt(num);
            for (int i = 1; i <= sqrt; i++){
                if (num % i == 0){
                    if (i == num / i){
                        count++;
                    }else {
                      count = count + 2;
                    }
                }
            }
            result.add(count);
        }

        return result;
    }

    static ArrayList<Integer> solve2(ArrayList<Integer> A){
        int max = 0;

        // Step 1: Find the maximum element.
        for (int num : A) {
            max = Math.max(max, num);
        }

        // divisors[x] stores the number of divisors of x.
        int[] divisors = new int[max + 1];

        // Step 2: Count divisors for every number using a sieve.
        for (int d = 1; d <= max; d++) {

            // Every multiple of d is divisible by d.
            for (int multiple = d; multiple <= max; multiple += d) {
                divisors[multiple]++;
            }
        }

        // Step 3: Retrieve the precomputed counts in input order.
        ArrayList<Integer> result = new ArrayList<>();

        for (int num : A) {
            result.add(divisors[num]);
        }

        return result;
    }

    static void main(){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(4);
        list.add(45);
        list.add(24);
        list.add(36);
        list.add(10);

        System.out.println(solve(list));
        System.out.println(solve2(list));
    }
}
