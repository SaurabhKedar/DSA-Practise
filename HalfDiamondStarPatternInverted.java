import java.util.Scanner;

public class HalfDiamondStarPatternInverted {
    /*
            *
           **
          ***
         ****
          ***
           **
            *
     */
    static void main() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 1 ; i <= n; i++){
            for (int j = 1; j <= n - i; j++){
                System.out.print(" ");
            }
            for (int k = 1; k <= i; k++){
                System.out.print("*");
            }
            System.out.println();
        }
        for (int m = 1; m <= n - 1; m++){
            for (int p = 1; p <= m; p++){
                System.out.print(" ");
            }
            for (int q = 1; q <= n - m; q++){
                System.out.print("*");
            }
            if (m != n - 1){
                System.out.println();
            }
        }
    }
}
