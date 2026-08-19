import java.util.ArrayList;
import java.util.Scanner;

public class FibonacciSeries {
    static void main() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<Integer>();
        if (n == 0) {
            arr.add(0);
        } else if (n == 1) {
            arr.add(0);
            arr.add(1);
        } else {
            arr.add(0);
            arr.add(1);
            for (int i = 2; i <= n; i++) {
                arr.add(arr.get(i - 1) + arr.get(i - 2));
            }
        }
        System.out.println(arr);
    }
}
