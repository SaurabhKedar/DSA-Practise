//Advanced DSA 3: Backtracking & Advanced Trees
// Lecture 8 | DSA: Lab Session on Binary Trees

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeInOrderAndPreOrder {
    static Map<Integer, Integer> inOrderMap;
    static int preIndex;

    static TreeNode buildTree(int[] A, int[] B){
        // Store each inorder value and its index.
        inOrderMap = new HashMap<>();

        for (int i = 0; i < B.length; i++) {
            inOrderMap.put(B[i], i);
        }

        // Points to the next root in preorder.
        preIndex = 0;

        // Initially, the entire inorder range is available.
        return build(A, 0, B.length - 1);
    }

    static TreeNode build(int[] preOrder, int inStart, int inEnd){
        // No elements remain in this subtree.
        if (inStart > inEnd) {
            return null;
        }

        // Preorder visits the root before its children.
        int rootValue = preOrder[preIndex];
        preIndex++;
        TreeNode root = new TreeNode(rootValue);

        // Find the root position in O(1) average time.
        int rootIndex = inOrderMap.get(rootValue);

        // Build the left subtree first.
        root.left = build(preOrder, inStart, rootIndex - 1);

        // Then build the right subtree.
        root.right = build(preOrder, rootIndex + 1, inEnd);

        return root;
    }
    static void main() {

    }
}
