import java.util.Scanner;

public class EvenOrOddNumber {
    static void main() {
        Scanner sc = new Scanner(System.in);
        int n;
        do {
            n = sc.nextInt();
        } while (n == 0);

        if (n % 2 == 0){
            System.out.println("Number is Even");
        }else {
            System.out.println("Number is Odd");
        }
        sc.close();
    }
}
