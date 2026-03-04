package Tree.DFS.Hard;

import Tree.common.TreeNode;
import Tree.common.BT;

public class BTMaxPathSum {

    public static int maxSum = Integer.MIN_VALUE;

    public static void main(String[] args) {
        TreeNode root = BT.fromLevelOrder(2, -1);
        BT.printTopDown(root);

        maxPathSum(root);
        System.out.println(maxSum);
    }

    public static int maxPathSum(TreeNode root) {
        if(root == null) return 0;

        int leftVal = Math.max(maxPathSum(root.left), 0);
        int rightVal = Math.max(maxPathSum(root.right), 0);

        maxSum = Math.max(maxSum, leftVal + rightVal + root.val);

        return Math.max(leftVal, rightVal) + root.val;
    }
}
