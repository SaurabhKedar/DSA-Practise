//Advanced DSA 3: Backtracking & Advanced Trees
// Lecture 7 | DSA: Trees 1: Structure & Traversal

import java.util.ArrayList;

public class PreorderTraversal {
    private static ArrayList<Integer> preorderTraversal(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<>();

        // Start preorder traversal at the root.
        preorder(A, result);

        return result;
    }

    private static void preorder(TreeNode node, ArrayList<Integer> result) {
        // Base case: there is no node to visit.
        if (node == null) {
            return;
        }

        // Visit the root before either subtree.
        result.add(node.val);

        // Continue in preorder: left subtree, then right subtree.
        preorder(node.left, result);
        preorder(node.right, result);
    }

    static void main() {
        // Create the following binary tree:
        //
        //          1
        //        /   \
        //       2     3
        //      / \   / \
        //     4   5 6   7

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        // Call the level order traversal method.
        ArrayList<Integer> result = preorderTraversal(root);

        // Print each level.
        System.out.println("PreOrder Traversal:");

        for (Integer val : result) {
            System.out.print(val + ", ");
        }
    }
}
