//Advanced DSA 3: Backtracking & Advanced Trees
// Lecture 9 |  DSA: Trees 4: Morris Inorder Traversal + LCA

public class Distance_Between_Nodes_of_BST {
    static int solve(TreeNode A, int B, int C) {
        TreeNode lca = A;

        while (lca != null){
            if (B < lca.val && C < lca.val){
                lca = lca.left;
            }
            else if (B > lca.val && B > lca.val){
                lca = lca.right;
            }
            else {
                break;
            }
        }

        int distanceB = findDistance(lca, B);
        int distanceC = findDistance(lca, C);

        return distanceB + distanceC;
    }

    static int findDistance(TreeNode node, int target){
        int distance = 0;

        while (node.val != target){
            if (target < node.val){
                node = node.left;
            }else {
                node = node.right;
            }

            distance++;
        }

        return distance;
    }
    static void main() {

    }
}
