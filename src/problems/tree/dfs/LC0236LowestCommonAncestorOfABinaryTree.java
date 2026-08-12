package problems.tree.dfs;

import common.tree.BinaryTreeUtils;
import common.tree.TreeNode;

public class LC0236LowestCommonAncestorOfABinaryTree {

    public static void main(String[] args) {
        TreeNode root = BinaryTreeUtils.fromLevelOrder(3,5,1,6,2,0,8,null,null,7,4);
        BinaryTreeUtils.printTopDown(root);

        //System.out.println(lowestCommonAncestor(root));
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return null;
        }

        if(root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left != null && right != null) {
            return root;
        }

        return right != null ? right : left;
    }
}
