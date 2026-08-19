import java.util.ArrayList;
import java.util.Scanner;

public class NumericStairPattern {
    static void main() {
        Scanner sc = new Scanner(System.in);
        int n = Math.abs(sc.nextInt());
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for (int i = 1 ; i <= n; i++){
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 1; j <= i; j++){
                row.add(j);
            }
            res.add(row);
        }
        System.out.println(res);
    }
}
