//Advanced DSA 3: Backtracking & Advanced Trees
// Lecture 10 |  DSA: Lab Session on Binary Trees 2

import java.util.LinkedList;
import java.util.Queue;

public class InvertTheBinaryTree {
    static TreeNode invertTree(TreeNode A) {

        // An empty tree needs no changes.
        if (A == null) {
            return null;
        }

        // Use a queue to visit nodes level by level.
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(A);

        while (!queue.isEmpty()) {
            // Remove the next node to process.
            TreeNode current = queue.poll();

            // Swap this node's left and right child pointers.
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;

            // Queue the swapped children so their subtrees are processed.
            if (current.left != null) {
                queue.offer(current.left);
            }
            if (current.right != null) {
                queue.offer(current.right);
            }
        }

        // Return the original root, now the root of the inverted tree.
        return A;
    }
}
