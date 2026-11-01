//Advanced DSA 3: Backtracking & Advanced Trees
// Lecture 9 |  DSA: Trees 4: Morris Inorder Traversal + LCA

import java.util.HashSet;
import java.util.Set;

public class CommonNodesInTwoBST {
    static final  long MOD = 1000000007L;
    static void store(TreeNode node, Set<Integer> set){
        if (node == null){
            return;
        }

        store(node.left, set);
        set.add(node.val);
        store(node.right, set);
    }

    static long findCommon(TreeNode node, Set<Integer> values){
        if (node == null){
            return 0L;
        }

        long sum = values.contains(node.val) ? node.val : 0;
        sum += findCommon(node.left, values);
        sum += findCommon(node.right, values);

        return sum % MOD;
    }
    static int solve(TreeNode A, TreeNode B) {
        Set<Integer> values = new HashSet<>();

        store(A, values);

        return (int) findCommon(B, values);
    }
    static void main() {

    }
}
