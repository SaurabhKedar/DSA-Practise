import java.util.Scanner;

public class HollowSquareStarPattern {
    /*
         ****
         *  *
         *  *
         ****
     */
    static void main() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 1; i<= n ; i++){
            for (int j = 1; j <= n; j++){
                if (i == 1 || i == n || j == 1 | j == n){
                    System.out.print("*");
                }else {
                    System.out.print(" ");
                }
            }
            if (i != n){
                System.out.println();
            }
        }
    }
}
