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

    }
}
