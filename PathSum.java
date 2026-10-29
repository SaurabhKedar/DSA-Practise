//Advanced DSA 3: Backtracking & Advanced Trees
// Lecture 8 | DSA: Lab Session on Binary Trees

public class PathSum {
    static int hasPathSum(TreeNode node, long remaining) {
        if (node == null) {
            return 0;
        }

        // Subtract this node before checking whether the path ends here.
        remaining -= node.val;

        // A matching sum counts only when this node is a leaf.
        if (node.left == null && node.right == null) {
            return remaining == 0 ? 1 : 0;
        }

        // Stop as soon as either subtree contains a matching path.
        if (hasPathSum(node.left, remaining) == 1
                || hasPathSum(node.right, remaining) == 1) {
            return 1;
        }

        return 0;
    }
    static void main() {
        // Example 1: Path sum exists
        // Tree:
        //        5
        //       / \
        //      4   8
        //     /   / \
        //    11  13  4
        //   /  \       \
        //  7    2       1

        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(4);
        root1.right = new TreeNode(8);
        root1.left.left = new TreeNode(11);
        root1.left.left.left = new TreeNode(7);
        root1.left.left.right = new TreeNode(2);
        root1.right.left = new TreeNode(13);
        root1.right.right = new TreeNode(4);
        root1.right.right.right = new TreeNode(1);

        int target1 = 22;

        System.out.println(
                "Example 1: " + hasPathSum(root1, target1)
        ); // Output: 1


        // Example 2: Path sum does not exist
        // Tree:
        //        1
        //       / \
        //      2   3

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);

        int target2 = 5;

        System.out.println(
                "Example 2: " + hasPathSum(root2, target2)
        ); // Output: 0
    }
}
