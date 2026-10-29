//Advanced DSA 3: Backtracking & Advanced Trees
// Lecture 8 | DSA: Lab Session on Binary Trees

public class EqualTreePartition {
    static boolean foundHalf = false;

    static int solve(TreeNode A){
        if (A == null){
            return 0;
        }

        int totalSum = getTreeSum(A);

        if (totalSum / 2 == 1){
            return 0;
        }

        postOrder(A, totalSum);

        return foundHalf ? 1 : 0;

    }

    static int postOrder(TreeNode node, int totalSum){
        if (node == null){
            return 0;
        }

        int leftSum = postOrder(node.left, totalSum);
        int rightSum = postOrder(node.right, totalSum);
        int currSum = node.val + leftSum + rightSum;

        if (currSum == totalSum / 2){
            foundHalf = true;
        }

        return currSum;
    }
    static int getTreeSum(TreeNode node){
        if (node == null){
            return 0;
        }
        return node.val +
                getTreeSum(node.left) +
                getTreeSum(node.right);
    }
    static void main() {
        // Example 1: Equal partition exists.
        // Tree:
        //       5
        //      / \
        //     10  10
        //         / \
        //        2   3
        //
        // Total sum = 30
        // Right subtree sum = 15? No.
        // Use a tree with an equal-sum subtree instead.

        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(10);
        root1.right = new TreeNode(10);
        root1.right.left = new TreeNode(2);
        root1.right.right = new TreeNode(3);

        System.out.println("Example 1: " + solve(root1));


        // Example 2: Equal partition does not exist.
        // Tree:
        //       1
        //      / \
        //     2   4
        //
        // Total sum = 7 (odd), so equal partition is impossible.

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(4);

        System.out.println("Example 2: " + solve(root2));
    }
}
