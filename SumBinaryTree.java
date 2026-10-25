//Advanced DSA 3: Backtracking & Advanced Trees
// Lecture 7 | DSA: Trees 1: Structure & Traversal

public class SumBinaryTree {
    static int solve(TreeNode A) {
        return checkSumTree(A) == -1L ? 0 : 1;
    }

    // Returns the subtree sum if valid, otherwise -1.
    static long checkSumTree(TreeNode node) {
        // An empty subtree has sum 0.
        if (node == null) {
            return 0L;
        }

        // Every leaf node is automatically a Sum Tree.
        if (node.left == null && node.right == null) {
            return node.val;
        }

        // Get the sums of the left and right subtrees.
        long leftSum = checkSumTree(node.left);
        long rightSum = checkSumTree(node.right);

        // If either subtree is invalid, the current tree is invalid.
        if (leftSum == -1L || rightSum == -1L) {
            return -1L;
        }

        // Current node must equal the sum of both subtrees.
        if (node.val != leftSum + rightSum) {
            return -1L;
        }

        // Return the sum of the entire subtree for the parent.
        return node.val + leftSum + rightSum;
    }

    static void main(String[] args) {

        /*
                 14
                /  \
               4    6
              / \
             1   3
        */

        TreeNode root = new TreeNode(14);
        root.left = new TreeNode(4);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        System.out.println(solve(root)); // Output: 1
    }
}
