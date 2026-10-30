//Advanced DSA 3: Backtracking & Advanced Trees
// Lecture 9 |  DSA: Trees 4: Morris Inorder Traversal + LCA

public class LeastCommonAncestor {
    static int lca(TreeNode A, int B, int C) {

        // Base case: Node does not exist.
        if (A == null) {
            return -1;
        }

        // If current node matches either B or C.
        if (A.val == B || A.val == C) {
            return A.val;
        }

        int leftLCA = lca(A.left, B, C);
        int rightLCA = lca(A.right, B, C);

        // Both values found in different subtrees.
        if (leftLCA != -1 && rightLCA != -1) {
            return A.val;
        }

        // Return whichever subtree contains a target.
        if (leftLCA == -1) {
            return rightLCA;
        } else {
            return leftLCA;
        }
    }
    static void main(String[] args) {

        // Create binary tree
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        // Find LCA of B and C
        int B = 4;
        int C = 5;

        int result = lca(root, B, C);

        System.out.println("LCA of " + B + " and " + C + " = " + result);
    }
}
