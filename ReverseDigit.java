import java.util.Scanner;

public class ReverseDigit {
    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number : ");
        long n = sc.nextLong();

        int sign = (n > 0) ? 1 : -1;
        long reverse = 0;

        while(n > 0){
            long rem = n % 10;
            reverse = (reverse * 10) + rem;
            n /= 10;
        }

        System.out.println("The reverse digit number is : " + reverse);

    }
}
