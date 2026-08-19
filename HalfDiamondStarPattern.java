import java.util.Scanner;

public class HalfDiamondStarPattern {
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
        Scanner sc = new Scanner(System.in);;
        int n = sc.nextInt();
        for (int i = 1; i <= n ; i++){
            for (int j = 1; j <= i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
        for (int k = n - 1; k >= 1; k--){
            for (int m = 1; m <= k; m++){
                System.out.print("*");
            }
            if (k != 1){
                System.out.println();
            }
        }

    }
}
