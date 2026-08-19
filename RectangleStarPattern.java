import java.util.Scanner;

public class RectangleStarPattern {
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

        for (int i = 1; i <= rows; i++){
            for (int j = 1; j <= cols; j++){
                System.out.print("*");
            }
            if (i != rows){
                System.out.println();
            }
        }
    }
}
