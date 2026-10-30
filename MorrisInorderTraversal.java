//Advanced DSA 3: Backtracking & Advanced Trees
// Lecture 9 |  DSA: Trees 4: Morris Inorder Traversal + LCA

import java.util.ArrayList;

public class MorrisInorderTraversal {
    static ArrayList<Integer> solve(TreeNode A){
        ArrayList<Integer> result = new ArrayList<>();

        TreeNode current = A;

        // Continue until all nodes are processed.
        while (current != null) {

            // Case 1: No left subtree.
            // Visit this node and move to the right.
            if (current.left == null) {
                result.add(current.val);
                current = current.right;
            } else {

                // Find the rightmost node in the left subtree.
                // This node is the inorder predecessor.
                TreeNode predecessor = current.left;

                while (predecessor.right != null
                        && predecessor.right != current) {
                    predecessor = predecessor.right;
                }

                // Case 2: First visit to this node.
                // Create a temporary thread back to current.
                if (predecessor.right == null) {
                    predecessor.right = current;
                    current = current.left;
                } else {

                    // Case 3: We returned through the thread.
                    // Remove the thread to restore the tree.
                    predecessor.right = null;

                    // Left subtree is complete; visit current.
                    result.add(current.val);

                    // Process the right subtree next.
                    current = current.right;
                }
            }
        }

        return result;
    }
    public static void main(String[] args) {

        // Create BST
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);

        // Call Morris Inorder Traversal
        ArrayList<Integer> result = solve(root);

        // Print inorder traversal
        System.out.println("Inorder Traversal: " + result);
    }
}
