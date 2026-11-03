//Advanced DSA 3: Backtracking & Advanced Trees
// Lecture 10 |  DSA: Lab Session on Binary Trees 2

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class VerticalOrderTraversal {
    // Stores a tree node along with its horizontal distance.
    static class NodeInfo {
        TreeNode node;
        int hd;

        NodeInfo(TreeNode node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        // Handle an empty tree.
        if (A == null) {
            return result;
        }

        // Maps each horizontal distance to its column values.
        HashMap<Integer, ArrayList<Integer>> columns = new HashMap<>();

        // BFS queue stores both the node and its horizontal distance.
        Queue<NodeInfo> queue = new LinkedList<>();
        queue.offer(new NodeInfo(A, 0));

        int minHD = 0;
        int maxHD = 0;

        while (!queue.isEmpty()) {

            NodeInfo current = queue.poll();
            TreeNode node = current.node;
            int hd = current.hd;

            // Create a column if this horizontal distance is new.
            if (!columns.containsKey(hd)) {
                columns.put(hd, new ArrayList<>());
            }

            // BFS guarantees shallower nodes are processed first.
            columns.get(hd).add(node.val);

            // Track the leftmost and rightmost columns.
            minHD = Math.min(minHD, hd);
            maxHD = Math.max(maxHD, hd);

            // Left child belongs to the previous column.
            if (node.left != null) {
                queue.offer(new NodeInfo(node.left, hd - 1));
            }

            // Right child belongs to the next column.
            if (node.right != null) {
                queue.offer(new NodeInfo(node.right, hd + 1));
            }
        }

        // Build the answer from leftmost column to rightmost.
        for (int hd = minHD; hd <= maxHD; hd++) {
            result.add(columns.get(hd));
        }

        return result;
    }}
