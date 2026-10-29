//Advanced DSA 3: Backtracking & Advanced Trees
// Lecture 8 | DSA: Lab Session on Binary Trees

public class BalancedBinaryTree {

    private static boolean balanced;

    // Returns the edge-based height of this subtree; an empty subtree has height -1.
    static int height(TreeNode node) {
        if (node == null) {
            return -1;
        }

        // Visit both subtrees before checking this node (postorder traversal).
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        // Record an imbalance, but keep computing heights for the parent nodes.
        if (Math.abs(leftHeight - rightHeight) > 1) {
            balanced = false;
        }

        return 1 + Math.max(leftHeight, rightHeight);
    }

    static int isBalanced(TreeNode root) {
        // Reset shared state for each independent invocation.
        balanced = true;
        height(root);
        return balanced ? 1 : 0;
    }
    static void main() {
        // Example 1: Balanced binary tree
        //        1
        //       / \
        //      2   3
        //     / \
        //    4   5

        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);

        System.out.println("Example 1: " + isBalanced(root1));


        // Example 2: Unbalanced binary tree
        //        1
        //       /
        //      2
        //     /
        //    3
        //   /
        //  4

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.left.left = new TreeNode(3);
        root2.left.left.left = new TreeNode(4);

        System.out.println("Example 2: " + isBalanced(root2));
    }
}
