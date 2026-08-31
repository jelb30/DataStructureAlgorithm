package problems.trees;
import common.tree.TreeNode;

// LEETCODE 700: SEARCH IN BINARY TREE.
public class LC0700SearchInABinarySearchTree {

    public static TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        if (root.val > val) {
            return searchBST(root.left, val);
        }else{
            return searchBST(root.right, val);
        }
    }

}
