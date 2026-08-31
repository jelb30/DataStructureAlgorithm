package problems.trees;
import common.tree.TreeNode;
// LEETCODE 226.
public class LC0226InvertBinaryTree {

    public static TreeNode invertBinaryTree(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        if (root.left != null && root.right != null){
            invertBinaryTree(root.left);
            invertBinaryTree(root.right);
        }
        return root;
    }
}
