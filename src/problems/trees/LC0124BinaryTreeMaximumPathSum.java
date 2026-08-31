package problems.trees;
import common.tree.TreeNode;
import common.tree.BinaryTreeUtils;

public class LC0124BinaryTreeMaximumPathSum {

    public static int maxSum = Integer.MIN_VALUE;

    public static int maxPathSum(TreeNode root) {
        if(root == null) return 0;

        int leftVal = Math.max(maxPathSum(root.left), 0);
        int rightVal = Math.max(maxPathSum(root.right), 0);

        maxSum = Math.max(maxSum, leftVal + rightVal + root.val);

        return Math.max(leftVal, rightVal) + root.val;
    }
}
