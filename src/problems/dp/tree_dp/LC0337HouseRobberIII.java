package problems.dp.tree_dp;

import common.tree.BinaryTreeUtils;
import common.tree.TreeNode;

public class LC0337HouseRobberIII {

    public static void main(String[] args) {
        TreeNode root = BinaryTreeUtils.fromLevelOrder(3,4,5,1,3,null,1);
        BinaryTreeUtils.printTopDown(root);

        System.out.println(rob(root));
    }

    public static int rob(TreeNode root) {
        if(root == null) return 0;
        int[] results = helper(root);
        return Math.max(results[0], results[1]);
    }

    public static int[] helper(TreeNode root) {
        if(root == null) return new int[]{0,0};

        int[] left = helper(root.left);
        int[] right = helper(root.right);

        int rob = root.val + left[1] + right[1];
        int notRob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return new int[]{rob, notRob};
    }
}
