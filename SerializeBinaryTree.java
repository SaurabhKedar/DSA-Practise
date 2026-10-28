//Advanced DSA 3: Backtracking & Advanced Trees
// Lecture 6 | DSA: Trees 1: Structure & Traversal

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeBinaryTree {
    static ArrayList<Integer> solve(TreeNode A){
        ArrayList<Integer> result = new ArrayList<>();

        // Handle an empty tree (if permitted).
        if (A == null) {
            return result;
        }

        // LinkedList allows null entries, unlike ArrayDeque.
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(A);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node == null) {
                // Represent a missing child with -1.
                result.add(-1);
            } else {
                // Record the current node's value.
                result.add(node.val);

                // Add both children, including null children.
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }

        return result;
    }

    static void main(String[] args) {

        /*
                 1
                / \
               2   3
              / \
             4   5
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        ArrayList<Integer> result = solve(root);

        System.out.println(result);
    }
}
