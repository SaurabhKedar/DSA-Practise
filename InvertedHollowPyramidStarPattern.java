import java.util.Scanner;

public class InvertedHollowPyramidStarPattern {
    /*
     *******
      *   *
       * *
        *
     */
    static void main() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = n; i >= 1; i--){
            for (int j = 1 ; j <= n - i; j++){
                System.out.print(" ");
            }
            for (int k = 1; k <= 2*i - 1; k++){
                if (i == n || k == 1 || k == 2 * i - 1) {
                    System.out.print("*");
                }else {
                    System.out.print(" ");
                }
            }
            for (int j = 1 ; j <= n - i; j++){
                System.out.print(" ");
            }
            if (i != 1){
                System.out.println();
            }
        }
    }
}
