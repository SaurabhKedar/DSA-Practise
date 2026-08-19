import java.util.Scanner;

public class InternalVarsitySquarePattern {
    static void main() {
        Scanner sc = new Scanner(System.in);
        int n = Math.abs(sc.nextInt());
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= n - 1; j++){
                if (i == 1 || i == n || j == 1 || j == n - 1){
                    System.out.print((n - 1) + " ");
                }else {

                }
                System.out.println();
            }
        }
    }
}
