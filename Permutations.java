import java.util.ArrayList;
import java.util.Arrays;

public class Permutations {

    private static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        // Stores all the permutations
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        // Stores the permutation that we are currently building
        ArrayList<Integer> current = new ArrayList<>();

        // used[i] tells us whether A[i] is already included
        // in the current permutation.
        boolean[] used = new boolean[A.size()];

        // Start building the permutation
        backtrack(A, used, current, result);

        return result;
    }

    private static void backtrack(
            ArrayList<Integer> A,
            boolean[] used,
            ArrayList<Integer> current,
            ArrayList<ArrayList<Integer>> result
    ){
        // Base case:
        // If current permutation has N elements,
        // we have created one complete permutation.
        if (current.size() == A.size()) {

            // Add a COPY of current to result.
            //
            // We need a new ArrayList because current will
            // continue changing during backtracking.
            result.add(new ArrayList<>(current));

            return;
        }

        // Try every element as the next element
        // of the permutation.
        for (int i = 0; i < A.size(); i++) {

            // If this element is already used,
            // we cannot use it again.
            if (used[i]) {
                continue;
            }

            // -----------------------------
            // 1. CHOOSE
            // -----------------------------

            // Mark this element as used
            used[i] = true;

            // Add it to the current permutation
            current.add(A.get(i));


            // -----------------------------
            // 2. EXPLORE
            // -----------------------------

            // Recursively choose the next element
            backtrack(A, used, current, result);


            // -----------------------------
            // 3. UNDO / BACKTRACK
            // -----------------------------

            // Remove the last chosen element
            current.remove(current.size() - 1);

            // Mark the element as unused
            // so that it can be used in another permutation.
            used[i] = false;
        }
    }
    static void main() {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 2, 3));

        ArrayList<ArrayList<Integer>> result = permute(A);

        System.out.println(result);
    }
}
