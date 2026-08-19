import java.util.Scanner;

public class SumOfNumbersInGivenRange {
    static int SumInRange(int a, int b){
        int sum = 0;
        if (a > b){
            for (int i = a; i >= b; i--){
                sum =+ sum + i;
            }
        } else if (a < b){
            for (int i = a; i <= b; i++){
                sum =+ sum + i;
            }
        }else {
            sum = a + b;
        }

        return sum;
    }
    static void main() {
        Scanner sc = new Scanner(System.in);
        int a, b;
        System.out.println("Enter the first number : ");
        a = sc.nextInt();
        System.out.println("Enter the second number : ");
        b = sc.nextInt();
        System.out.println(SumInRange(b, a));
    }
}
