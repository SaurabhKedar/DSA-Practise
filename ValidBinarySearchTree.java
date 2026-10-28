//Advanced DSA 3: Backtracking & Advanced Trees
// Lecture 7 | DSA: Trees 2: BST

import java.util.ArrayList;

public class ValidBinarySearchTree {
    // Stores the previously visited node's value.
    static long prev = Long.MIN_VALUE;
    private static boolean inOrder(TreeNode node){
        if (node == null){
            return true;
        }

        // Visit the left subtree first.
        if (!inOrder(node.left)) {
            return false;
        }

        // The current value must be greater than the previous value.
        if (node.val <= prev) {
            return false;
        }

        // Update prev only after the comparison succeeds.
        prev = node.val;

        // Finish the inorder traversal by visiting the right subtree.
        return inOrder(node.right);

    }

    private static boolean isValidBST(TreeNode A){
        // Reset state if this Solution instance is reused.
        prev = Long.MIN_VALUE;
        return inOrder(A);
    }
    static void main() {
        // Create a valid Binary Search Tree
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);

        // Check whether the tree is a valid BST
        boolean result = isValidBST(root);

        System.out.println("Is Valid BST: " + result);
    }
}
