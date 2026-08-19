import java.util.Scanner;

public class ParallelogramStarPattern {
    /*
     ******
      ******
       ******
        ******
     */
    static void main() {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int cols = sc.nextInt();

        for (int i = 1; i<= rows; i++){
            for (int j = 1; j <= i - 1; j++){
                System.out.print(" ");
            }
            for (int k = 1; k <= cols; k++){
                System.out.print("*");
            }
            if(i != rows){
                System.out.println();
            }
        }
    }
}
