//Advanced DSA 3: Backtracking & Advanced Trees
// Lecture 6 | DSA: Trees 1: Structure & Traversal

import java.util.ArrayList;

public class InorderTraversal {
    private static ArrayList<Integer> inorderTraversal(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<>();
        // Start traversal from the root.
        inOrder(A, result);

        return result;
    }

    private static void inOrder(TreeNode node, ArrayList<Integer> result){
        // Base case: there is no node to process.
        if (node == null) {
            return;
        }

        // Visit the left subtree first.
        inOrder(node.left, result);

        // Then visit the current node.
        result.add(node.val);

        // Finally visit the right subtree.
        inOrder(node.right, result);
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
        ArrayList<Integer> result = inorderTraversal(root);

        // Print each level.
        System.out.println("InOrder Traversal:");

        for (Integer val : result) {
            System.out.print(val + ", ");
        }
    }
}
