package Tree.DFS.Medium;

import Tree.common.BT;
import Tree.common.TreeNode;

public class DeleteNodeInBST {
    public static void main(String[] args) {
        TreeNode root = BT.fromLevelOrder(5,3,6,2,4,null,7);
        BT.printTopDown(root);
        System.out.println(deleteNode(root, 3));
        BT.printTopDown(root);
    }

    public static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        // 1. Search for the node (and rebuild the parent connections!)
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        }

        // 2. We found the node! Let's delete it.
        else {
            // Case 1 & 2: 0 or 1 child
            // We just return the non-null child to the parent.
            // If both are null (leaf), it returns null to the parent!
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            // Case 3: 2 children
            // Find the Heir (Smallest in the right subtree)
            TreeNode heir = root.right;
            while (heir.left != null) {
                heir = heir.left;
            }

            // Steal the crown
            root.val = heir.val;

            // Delete the original Heir from the right subtree
            // Recursion handles reconnecting any right children the heir had!
            root.right = deleteNode(root.right, heir.val);
        }

        // Return the updated node to its parent
        return root;
    }

}
