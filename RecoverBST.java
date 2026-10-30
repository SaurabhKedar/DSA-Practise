//Advanced DSA 3: Backtracking & Advanced Trees
// Lecture 9 |  DSA: Trees 4: Morris Inorder Traversal + LCA

import java.util.ArrayList;

public class RecoverBST {
    static final ArrayList<Integer> inorder = new ArrayList<>();

    // Visit nodes in Left, Root, Right order and save their values.
    static void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        inorderTraversal(root.left);
        inorder.add(root.val);
        inorderTraversal(root.right);
    }

    public ArrayList<Integer> recoverTree(TreeNode root) {
        inorder.clear();
        inorderTraversal(root);

        int first = -1;
        int second = -1;

        // The swapped values create one or two descending adjacent pairs.
        for (int i = 0; i < inorder.size() - 1; i++) {
            if (inorder.get(i) > inorder.get(i + 1)) {
                if (first == -1) {
                    first = inorder.get(i);
                }
                second = inorder.get(i + 1);
            }
        }

        ArrayList<Integer> answer = new ArrayList<>();
        // Match the supplied InterviewBit examples: preserve detection order.
        answer.add(first);
        answer.add(second);
        return answer;
    }
}
