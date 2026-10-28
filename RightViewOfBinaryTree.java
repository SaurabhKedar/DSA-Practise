//Advanced DSA 3: Backtracking & Advanced Trees
// Lecture 6 | DSA: Trees 1: Structure & Traversal

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class RightViewOfBinaryTree {
    private static ArrayList<Integer> solve(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<>();

        // Handle an empty tree.
        if (A == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(A);

        while (!queue.isEmpty()) {

            // Number of nodes at the current level.
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();

                // The last node processed at this level is the rightmost node.
                if (i == size - 1) {
                    result.add(current.val);
                }

                // Add left child before right child.
                if (current.left != null) {
                    queue.offer(current.left);
                }

                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
        }

        return result;
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
        ArrayList<Integer> result = solve(root);

        // Print each level.
        System.out.println("Right View of Binary Tree: " + result);
    }
}
