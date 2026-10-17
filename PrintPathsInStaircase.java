//Advanced DSA 3: Backtracking & Advanced Trees
// Lecture 5 | DSA: Lab Session on Backtracking

import java.util.ArrayList;

public class PrintPathsInStaircase {
    static ArrayList<ArrayList<Integer>> WaysToClimb(int A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        backtrack(A, path, result);
        return result;
    }
     private static void backtrack(
             int remaining,
             ArrayList<Integer> path,
             ArrayList<ArrayList<Integer>> result
     ){
        if (remaining == 0){
            result.add(new ArrayList<>(path));
            return;
        }

        if (remaining >= 1){
            path.add(1);
            backtrack(remaining - 1, path, result);
            path.remove(path.size() - 1);
        }

        if (remaining >= 2){
            path.add(2);
            backtrack(remaining - 2, path, result);
            path.remove(path.size() - 1);
        }
     }

    static void main() {
        System.out.println(WaysToClimb(3));
    }
}
