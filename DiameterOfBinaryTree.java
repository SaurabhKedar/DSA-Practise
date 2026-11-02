//Advanced DSA 3: Backtracking & Advanced Trees
// Lecture 10 |  DSA: Lab Session on Binary Trees 2

public class DiameterOfBinaryTree {
    // Stores the maximum diameter found anywhere in the tree.
    private int maxDiameter;

    // Returns the height of a subtree, measured in edges.
    private int height(TreeNode node) {

        // An empty subtree has height -1, making a leaf's height 0.
        if (node == null) {
            return -1;
        }

        // Calculate child heights before processing this node.
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        // The path through this node contains this many edges.
        int diameterThroughNode = leftHeight + rightHeight + 2;

        // Keep the largest diameter found so far.
        maxDiameter = Math.max(maxDiameter, diameterThroughNode);

        // Return the height needed by the parent node.
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public int solve(TreeNode A) {
        maxDiameter = 0;

        height(A);

        return maxDiameter;
    }
}
