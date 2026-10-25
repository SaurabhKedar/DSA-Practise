//Advanced DSA 3: Backtracking & Advanced Trees
// Lecture 7 | DSA: Trees 1: Structure & Traversal

import java.util.ArrayList;

public class PostorderTraversal {
    private static ArrayList<Integer> postorderTraversal(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<>();

        // Start traversal from the root.
        postorder(A, result);

        return result;
    }

    private static void postorder(TreeNode node, ArrayList<Integer> result) {

        // Base case: no node to visit.
        if (node == null) {
            return;
        }

        // Step 1: Visit the left subtree.
        postorder(node.left, result);

        // Step 2: Visit the right subtree.
        postorder(node.right, result);

        // Step 3: Add the current node last.
        result.add(node.val);
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
        ArrayList<Integer> result = postorderTraversal(root);

        // Print each level.
        System.out.println("PostOrder Traversal:");

        for (Integer val : result) {
            System.out.print(val + ", ");
        }
    }
}
