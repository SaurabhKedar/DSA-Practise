//Advanced DSA 3: Backtracking & Advanced Trees
// Lecture 7 | DSA: Trees 2: BST

import java.util.HashSet;

public class TwoSumBST {
    static boolean findPair(TreeNode root, int B, HashSet<Integer> seen)
    {
        // An empty subtree cannot contain a pair.
        if (root == null) {
            return false;
        }

        // Find the value needed to reach the target.
        int required = B - root.val;

        // Check before inserting so this node cannot match itself.
        if (seen.contains(required)) {
            return true;
        }

        // Remember this value for the nodes visited afterward.
        seen.add(root.val);

        // Search both subtrees.
        return findPair(root.left, B, seen)
                || findPair(root.right, B, seen);
    }
    static int t2Sum(TreeNode A, int B){
        HashSet<Integer> seen =  new HashSet<>();
        return findPair(A, B, seen) ? 1 : 0;
    }
    static void main() {

    }
}
