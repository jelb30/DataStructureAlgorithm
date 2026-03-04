package Tree.DFS.Easy;

import Tree.common.TreeNode;
import Tree.common.BT;

public class BalancedBinaryTree {

    public static void main(String[] args) {
        TreeNode root = BT.fromLevelOrder(1,2,2,3,3,null,null,4,4);
        BT.printTopDown(root);

        System.out.println(isBalanced(root));

    }

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
