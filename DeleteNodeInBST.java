//Advanced DSA 3: Backtracking & Advanced Trees
// Lecture 7 | DSA: Trees 2: BST

public class DeleteNodeInBST {
    static TreeNode solve(TreeNode A, int B)
    {
        // An empty subtree means the target was not found on this path.
        if (A == null) {
            return null;
        }

        // Search the left subtree when the target is smaller.
        if (B < A.val) {
            A.left = solve(A.left, B);
        }

        // Search the right subtree when the target is greater.
        else if (B > A.val) {
            A.right = solve(A.right, B);
        }

        // The target node has been found.
        else {
            // With no left child, the right child replaces this node.
            if (A.left == null) {
                return A.right;
            }

            // With no right child, the left child replaces this node.
            if (A.right == null) {
                return A.left;
            }

            // Find the in-order predecessor: the largest value in the left subtree.
            TreeNode predecessor = A.left;
            while (predecessor.right != null) {
                predecessor = predecessor.right;
            }

            // Copy the predecessor value, then remove its original node.
            A.val = predecessor.val;
            A.left = solve(A.left, predecessor.val);
        }

        // Return this subtree's root so the parent can reconnect it.
        return A;
    }
    // Print BST using inorder traversal
    static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    static void main(String[] args) {

        // Create a BST
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);

        System.out.println("Before deletion:");
        inOrder(root);

        int B = 3;
        root = solve(root, B);

        System.out.println("\nAfter deleting " + B + ":");
        inOrder(root);
    }
}
