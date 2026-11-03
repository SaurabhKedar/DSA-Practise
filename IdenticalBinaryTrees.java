//Advanced DSA 3: Backtracking & Advanced Trees
// Lecture 10 |  DSA: Lab Session on Binary Trees 2

public class IdenticalBinaryTrees {
    static int isSameTree(TreeNode A, TreeNode B){
        // Case 1: Both nodes are null, so these branches match.
        if (A == null && B == null) {
            return 1;
        }

        // Case 2: Only one node is null, so the structures differ.
        if (A == null || B == null) {
            return 0;
        }

        // Case 3: Both nodes exist, but their values must match.
        if (A.val != B.val) {
            return 0;
        }

        // Compare corresponding left and right subtrees.
        int left = isSameTree(A.left, B.left);
        int right = isSameTree(A.right, B.right);

        // Both subtree comparisons must succeed.
        return (left == 1 && right == 1) ? 1 : 0;
    }
}
