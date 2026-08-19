import java.util.Scanner;

public class SquareStarPattern {
    /*
         ****
         ****
         ****
         ****
     */

    static void main() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= n; j++){
                System.out.print("*");
            }
            if(i != n){
                System.out.println();
            }
        }
    }
}
