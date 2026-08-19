import java.util.Scanner;

public class SumOfFirstNNaturalNumbers {
    static int sumUsingRecursion(int N){
        if (N <= 0){
            return 0;
        }

        return sumUsingRecursion(N - 1) + N;
    }
    static void main() {
        Scanner sc = new Scanner(System.in);
        int n;
        do {
            n = sc.nextInt();
        } while (n <= 0);
        int sum = 0;
//        for (int i = 1; i <= n; i++){
//            sum += i;
//        }

        sum = (n * (n + 1)) / 2; //Formula for sum of N natural numbers
        System.out.println(sum);

        System.out.println("sumUsingRecursion " + sumUsingRecursion(3));
        sc.close();
    }
}
