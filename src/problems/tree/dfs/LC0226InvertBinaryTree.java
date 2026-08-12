package problems.tree.dfs;
import common.tree.TreeNode;
import common.tree.BinaryTreeUtils;

// LEETCODE 226.
public class LC0226InvertBinaryTree {

    public static void main(String[] args) {
        TreeNode root = BinaryTreeUtils.fromLevelOrder(4,2,7,1,3,6,9);
        TreeNode Node = invertBinaryTree(root);
        BinaryTreeUtils.printLeetCodeArray(Node);
    }

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
