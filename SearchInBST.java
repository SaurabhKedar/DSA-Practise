//Advanced DSA 3: Backtracking & Advanced Trees
// Lecture 7 | DSA: Trees 2: BST

public class SearchInBST {
    static int solve(TreeNode A, int B){
        // Begin at the root and follow one branch at a time.
        TreeNode current = A;

        while (current != null) {
            // The target has been found.
            if (current.val == B) {
                return 1;
            }

            // A smaller target can only be in the left subtree.
            else if (B < current.val) {
                current = current.left;
            }

            // A greater target can only be in the right subtree.
            else {
                current = current.right;
            }
        }

        // The search reached an empty child without finding the target.
        return 0;
    }
    static void main(String[] args) {

        // Create a Binary Search Tree
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);

        // Test 1: Search for an existing value
        int B = 4;
        System.out.println("Search for " + B + ": " + solve(root, B));

        // Test 2: Search for a non-existing value
        B = 10;
        System.out.println("Search for " + B + ": " + solve(root, B));

        // Test 3: Search for the root value
        B = 5;
        System.out.println("Search for " + B + ": " + solve(root, B));
    }
}
