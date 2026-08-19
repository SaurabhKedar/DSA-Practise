import java.util.ArrayList;
import java.util.Arrays;

public class BoundaryClockwiseDirection {
    static ArrayList<Integer> solve(ArrayList<ArrayList<Integer>> A){
        int rows = A.size();
        int cols = A.get(0).size();
        ArrayList<Integer> ans = new ArrayList();

        for (int j = 0; j < cols - 1; j++){
            ans.add(A.get(0).get(j));
        }

        for (int i = 0; i < rows - 1; i++ ){
            ans.add(A.get(i).get(cols - 1));
        }

        for (int j = cols - 1; j >= 1; j--){
            ans.add(A.get(rows - 1).get(j));
        }

        for (int i = rows - 1; i >= 1; i--){
            ans.add(A.get(i).get(0));
        }

        return ans;
    }
    static void main() {
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();

        A.add(new ArrayList<>(Arrays.asList(1, 2, 3)));
        A.add(new ArrayList<>(Arrays.asList(4, 5, 6)));
        A.add(new ArrayList<>(Arrays.asList(7, 8, 9)));

        System.out.println(solve(A));
    }
}
