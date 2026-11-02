//Advanced DSA 3: Backtracking & Advanced Trees
// Lecture 10 |  DSA: Lab Session on Binary Trees 2

public class NextPointerBinaryTree {
    static void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }

        // The root is the only node on the first level.
        root.next = null;

        // dummy.next will be the first node on the next level.
        TreeLinkNode dummy = new TreeLinkNode(-1);
        TreeLinkNode tail = dummy;
        TreeLinkNode current = root;

        while (current != null) {
            // Append existing children in left-to-right order.
            if (current.left != null) {
                tail.next = current.left;
                tail = tail.next;
            }
            if (current.right != null) {
                tail.next = current.right;
                tail = tail.next;
            }

            // Continue across the current level.
            current = current.next;

            if (current == null) {
                // Terminate the newly built level, then move down to it.
                tail.next = null;
                current = dummy.next;
                dummy.next = null;
                tail = dummy;
            }
        }
    }
    static void main() {

    }

}
