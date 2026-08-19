import java.util.Scanner;

public class DiamondStarPattern {
    /*
            *
           ***
          *****
         *******
          *****
           ***
            *
     */
    static void main() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= n -i; j++){
                System.out.print(" ");
            }
            for (int k = 1; k <= 2 * i - 1; k++){
                System.out.print("*");
            }
            for (int j = 1; j <= n -i; j++){
                System.out.print(" ");
            }
            System.out.println();
        }
        for (int p = n-1; p >= 1; p--){
            for (int q = 1; q <= n-p; q++){
                System.out.print(" ");
            }
            for (int r = 1; r <= 2*p - 1; r++){
                System.out.print("*");
            }
            for (int q = 1; q <= n-p; q++){
                System.out.print(" ");
            }
            if (p != 1){
                System.out.println();
            }
        }
    }
}
