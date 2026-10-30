//Advanced DSA 3: Backtracking & Advanced Trees
// Lecture 9 |  DSA: Trees 4: Morris Inorder Traversal + LCA

public class LcaInBST {
    static int solve(TreeNode A, int B, int C) {

        // Start searching from the root.
        TreeNode current = A;

        while (current != null) {

            // Both target values are smaller:
            // their LCA must be in the left subtree.
            if (B < current.val && C < current.val) {
                current = current.left;
            }

            // Both target values are greater:
            // their LCA must be in the right subtree.
            else if (B > current.val && C > current.val) {
                current = current.right;
            }

            // The values split across the two sides,
            // or the current node is one of the targets.
            else {
                return current.val;
            }
        }

        // The problem guarantees both nodes exist.
        return -1;
    }

    static void main() {

    }
}
