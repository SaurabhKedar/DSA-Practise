//Advanced DSA 3: Backtracking & Advanced Trees
// Lecture 7 | DSA: Trees 2: BST

public class BSTNodesInRange {
    static int solve(TreeNode A, int B, int C) {
        if (A == null) {
            return 0;
        }

        int count = 0;

        // Current node is in range
        if (A.val >= B && A.val <= C) {
            count++;
        }

        // Left subtree contains smaller values
        if (A.val > B) {
            count += solve(A.left, B, C);
        }

        // Right subtree contains larger values
        if (A.val < C) {
            count += solve(A.right, B, C);
        }

        return count;
    }
    static void main(String[] args) {

        // Create the BST
        TreeNode root = new TreeNode(15);
        root.left = new TreeNode(12);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(10);
        root.left.right = new TreeNode(14);
        root.right.left = new TreeNode(16);
        root.right.right = new TreeNode(27);

        // Given range
        int B = 12;
        int C = 20;

        // Call solve()
        int result = solve(root, B, C);

        System.out.println("Count of nodes in range: " + result);
    }
}
