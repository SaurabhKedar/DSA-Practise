//Advanced DSA 3: Backtracking & Advanced Trees
// Lecture 7 | DSA: Trees 2: BST

public class SortedArrayToBalancedBST {
    static TreeNode buildBST(int[] A, int start, int end){
        // No elements are available in this range.
        if (start > end) {
            return null;
        }

        // Select the middle element as the root.
        int mid = start + (end - start) / 2;

        TreeNode root = new TreeNode(A[mid]);

        // Construct the left subtree from the left half.
        root.left = buildBST(A, start, mid - 1);

        // Construct the right subtree from the right half.
        root.right = buildBST(A, mid + 1, end);

        // Return the root of this subtree.
        return root;
    }
    static TreeNode sortedArrayToBST(final int[] A){
        return buildBST(A, 0, A.length - 1);
    }
    // Print the tree using inorder traversal
    static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    static void main(String[] args) {

        int[] A = {1, 2, 3, 4, 5, 6, 7};

        TreeNode root = sortedArrayToBST(A);

        System.out.println("Inorder Traversal of BST:");
        inOrder(root);
    }
}
