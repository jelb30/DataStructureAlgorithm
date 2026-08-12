package problems.tree.bst;
import common.tree.TreeNode;
import common.tree.BinaryTreeUtils;

// LEETCODE 700: SEARCH IN BINARY TREE.
public class LC0700SearchInABinarySearchTree {
    public static void main(String[] args) {
        TreeNode root = BinaryTreeUtils.fromLevelOrder(4,2,7,1,3);
        TreeNode Node = searchBST(root, 2);
        System.out.println(Node.val);
    }

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
