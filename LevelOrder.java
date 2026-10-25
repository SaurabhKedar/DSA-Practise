//Advanced DSA 3: Backtracking & Advanced Trees
// Lecture 7 | DSA: Trees 1: Structure & Traversal
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class LevelOrder {
    private static ArrayList<ArrayList<Integer>> solve(TreeNode A) {
        // Stores the final level-by-level traversal.
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        // Handle an empty tree.
        if (A == null) {
            return result;
        }

        // Queue processes nodes in FIFO order.
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(A);

        while (!queue.isEmpty()) {

            // Number of nodes belonging to this level.
            int size = queue.size();

            // Stores values of the current level.
            ArrayList<Integer> currentLevel = new ArrayList<>();

            // Process only the nodes present at this level.
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();

                // Add the current node's value.
                currentLevel.add(current.val);

                // Add children for processing at the next level.
                if (current.left != null) {
                    queue.offer(current.left);
                }

                if (current.right != null) {
                    queue.offer(current.right);
                }
            }

            // Add the completed level to the answer.
            result.add(currentLevel);
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
        ArrayList<ArrayList<Integer>> result = solve(root);

        // Print each level.
        System.out.println("Level Order Traversal:");

        for (ArrayList<Integer> level : result) {
            System.out.println(level);
        }
    }
}
