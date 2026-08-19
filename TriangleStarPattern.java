import javax.crypto.spec.PSource;
import java.util.Scanner;

public class TriangleStarPattern {
    /*
     *
     **
     ***
     ****
     */
    static void main() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++){
            for (int j =1; j <= i; j++){
                System.out.print("*");
            }
            if (i != n){
                System.out.println();
            }
        }
    }
}
