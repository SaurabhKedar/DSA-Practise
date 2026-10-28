//Advanced DSA 3: Backtracking & Advanced Trees
// Lecture 6 | DSA: Trees 1: Structure & Traversal

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class DeserializeBinaryTree {
    static TreeNode solve(ArrayList<Integer> A) {
        // Handle an empty tree or a null root.
        if (A == null || A.size() == 0 || A.get(0) == -1) {
            return null;
        }

        // The first element is the root.
        TreeNode root = new TreeNode(A.get(0));

        // Queue stores nodes whose children we must process.
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        // Index of the next value to read from the array.
        int i = 1;
        int n = A.size();

        while (!queue.isEmpty() && i < n) {

            // Get the next parent in level order.
            TreeNode parent = queue.poll();

            // Process the left child.
            int leftValue = A.get(i);
            i++;

            if (leftValue != -1) {
                TreeNode leftChild = new TreeNode(leftValue);
                parent.left = leftChild;
                queue.offer(leftChild);
            }

            // Process the right child, if an entry exists.
            if (i < n) {
                int rightValue = A.get(i);
                i++;

                if (rightValue != -1) {
                    TreeNode rightChild = new TreeNode(rightValue);
                    parent.right = rightChild;
                    queue.offer(rightChild);
                }
            }
        }

        return root;
    }

    // Print the tree using level-order traversal.
    static void printLevelOrder(TreeNode root) {
        if (root == null) {
            System.out.println("Empty Tree");
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            System.out.print(node.val + " ");

            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }
        }

        System.out.println();
    }

    public static void main(String[] args) {

        ArrayList<Integer> A = new ArrayList<>(
                Arrays.asList(1, 2, 3, 4, 5, -1, 6)
        );

        TreeNode root = solve(A);

        System.out.println("Level Order Traversal of Deserialized Tree:");
        printLevelOrder(root);
    }
}
