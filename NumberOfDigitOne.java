//Advanced DSA 3: Backtracking & Advanced Trees
// Lecture 1 | DSA: Maths: Combinatorics Basics & Prime Numbers

public class NumberOfDigitOne {
    private static int solve(int A){
        //Brute Force
        //int count = 0;
        //for (int num = 1; num <= A; num++){
        //    int n = num;
        //    while (n > 0){
        //        if (n % 10 == 1){
        //            count++;
        //        }
        //        n /= 10;
        //    }
        //}

        //Optimised Approach
        long count = 0;
        long factor = 1;

        while (factor <= A){
            long higher = A / (factor * 10);
            long current = (A / factor) % 10;
            long lower = A % factor;

            if (current == 0){
                count += higher * factor;
            }
            else if (current == 1){
                count += (higher * factor) + lower + 1;
            }
            else {
                count += (higher + 1) * factor;
            }

            factor *= 10;
        }

        return (int)count;
    }
    public static void main() {
        System.out.println(solve(1000000000));
    }
}
