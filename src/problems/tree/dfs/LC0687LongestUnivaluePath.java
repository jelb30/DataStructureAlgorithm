package problems.tree.dfs;

import common.tree.TreeNode;
import common.tree.BinaryTreeUtils;

public class LC0687LongestUnivaluePath {

    public static int maxSeq;

    public static void main(String[] args) {
        TreeNode root = BinaryTreeUtils.fromLevelOrder(5, 4, 5, 4, null, null , null, 4, null);
        BinaryTreeUtils.printTopDown(root);

        System.out.println(longestUnivaluePath(root));
    }

    public static int longestUnivaluePath(TreeNode root) {
        helperMethod(root);
        return maxSeq;
    }

    public static int helperMethod(TreeNode root) {
        if(root == null) return 0;

        int leftSum = helperMethod(root.left);
        int rightSum = helperMethod(root.right);

        int leftArrow = 0;
        int rightArrow = 0;

        if(root.left != null && root.left.val == root.val) leftArrow = leftSum + 1;
        if(root.right != null && root.right.val == root.val) rightArrow = rightSum+1;

        maxSeq = Math.max(maxSeq, leftArrow+rightArrow);

        return Math.max(leftArrow, rightArrow);
    }


}
