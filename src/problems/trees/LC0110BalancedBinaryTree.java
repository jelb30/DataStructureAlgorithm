package problems.trees;
import common.tree.TreeNode;

public class LC0110BalancedBinaryTree {

    public static boolean isBalanced(TreeNode root) {

        int result = helperMethod(root);
        if(result < 1){
            return false;
        }
        return true;

    }

    public static int helperMethod(TreeNode root) {
        if(root == null) return 0;

        int leftSum = helperMethod(root.left);
        int rightSum = helperMethod(root.right);

        if(Math.abs(leftSum - rightSum) > 1) return -100;

        return Math.max(leftSum, rightSum) + 1;
    }

}
