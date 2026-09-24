import java.util.ArrayList;

public class GenerateSubsets {
    private static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        // This will store all the possible subsets
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        // Temporary list used to build one subset
        ArrayList<Integer> currentSubset = new ArrayList<>();

        // Start recursion from index 0
        backtrack(A, 0, currentSubset, result);

        return result;
    }
    private static void backtrack(
            ArrayList<Integer> A,
            int index,
            ArrayList<Integer> currentSubset,
            ArrayList<ArrayList<Integer>> result)
    {
        // Base case:
        // We have considered every element of A.
        // So currentSubset is now one complete subset.
        if (index == A.size()) {

            // Add a COPY of currentSubset to result.
            // We need a copy because currentSubset will
            // continue changing during backtracking.
            result.add(new ArrayList<>(currentSubset));

            return;
        }


        // ------------------------------------------------
        // CHOICE 1: TAKE A[index]
        // ------------------------------------------------

        // Add the current element to our subset
        currentSubset.add(A.get(index));

        // Move to the next element
        backtrack(A, index + 1, currentSubset, result);

        // BACKTRACK:
        // Remove the element we just added.
        // This allows us to explore the "don't take" choice.
        currentSubset.remove(currentSubset.size() - 1);


        // ------------------------------------------------
        // CHOICE 2: DON'T TAKE A[index]
        // ------------------------------------------------

        // We simply move to the next element
        // without adding A[index].
        backtrack(A, index + 1, currentSubset, result);
    }
    static void main() {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(3);
        System.out.println(subsets(A));
    }
}
