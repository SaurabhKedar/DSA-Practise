//Advanced DSA 3: Backtracking & Advanced Trees
// Lecture 8 | DSA: Lab Session on Binary Trees


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeInOrderAndPostOrder {
    static Map<Integer, Integer> inorderIndex;
    static int postIndex;

    static TreeNode buildTree(ArrayList<Integer> A,
                              ArrayList<Integer> B) {

        // Map each value to its position so subtree roots are found quickly.
        inorderIndex = new HashMap<>();
        for (int i = 0; i < A.size(); i++) {
            inorderIndex.put(A.get(i), i);
        }

        // Begin at the last postorder value, which is the root.
        postIndex = B.size() - 1;

        return build(B, 0, A.size() - 1);
    }

    static TreeNode build(ArrayList<Integer> postorder,
                           int inStart, int inEnd) {

        // No inorder values in this range means this subtree is empty.
        if (inStart > inEnd) {
            return null;
        }

        // Consume the current root from the end of postorder.
        int rootValue = postorder.get(postIndex);
        postIndex--;
        TreeNode root = new TreeNode(rootValue);

        // The map gives the split between the left and right subtrees.
        int rootIndex = inorderIndex.get(rootValue);

        // Read backward through postorder: build the right side before the left.
        root.right = build(postorder, rootIndex + 1, inEnd);
        root.left = build(postorder, inStart, rootIndex - 1);

        return root;
    }


    static void main() {

    }
}
