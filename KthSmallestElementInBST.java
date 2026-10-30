//Advanced DSA 3: Backtracking & Advanced Trees
// Lecture 9 |  DSA: Trees 4: Morris Inorder Traversal + LCA

public class KthSmallestElementInBST {
    static int count;
    static int answer;

    public int kthsmallest(TreeNode A, int B) {
        // Reset state so repeated calls on this Solution instance are independent.
        count = 0;
        inorder(A, B);
        return answer;
    }

    static boolean inorder(TreeNode node, int B) {
        // No node to visit.
        if (node == null) {
            return false;
        }

        // Visit smaller elements first.
        if (inorder(node.left, B)) {
            return true;
        }

        // Process the current node.
        count++;

        // The Bth visited node is the answer.
        if (count == B) {
            answer = node.val;
            return true;
        }

        // Search larger elements only if needed.
        return inorder(node.right, B);
    }

     static void main(String[] args) {

        // Create BST
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);

        // Find Kth smallest element
        int B = 3;

        KthSmallestElementInBST obj = new KthSmallestElementInBST();

        int result = obj.kthsmallest(root, B);

        System.out.println(B + "rd smallest element = " + result);
    }
}
