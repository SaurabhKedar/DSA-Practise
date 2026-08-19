import java.util.Scanner;

public class PositiveNegativeNumber {
    static void main() {
        Scanner sc = new Scanner(System.in);
        int n;
        do {
            n = sc.nextInt();
        }while (n == 0);

        if (n > 0){
            System.out.println("Number is positive");
        }else {
            System.out.println("Number is negative");
        }
        sc.close();
    }
}
