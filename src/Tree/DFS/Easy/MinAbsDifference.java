package Tree.DFS.Easy;

import Tree.common.BT;
import Tree.common.TreeNode;

public class MinAbsDifference {

    public static int minDiff = Integer.MAX_VALUE;
    public static Integer prev = null;


    public static void main(String[] args) {
        TreeNode root = BT.fromLevelOrder(236,104,701,null,227,null,911);
        BT.printTopDown(root);
        getMinimumDifference(root);
        System.out.println(minDiff);
    }

    public static int getMinimumDifference(TreeNode root) {
        if(root == null) return 0;

        if(root.left != null) {
            getMinimumDifference(root.left);
        }

        if(prev != null) {
            int diff = Math.abs(root.val-prev);
            minDiff = Math.min(diff, minDiff);
        }
        prev = root.val;

        if(root.right != null) {
            getMinimumDifference(root.right);
        }
        return root.val;
    }


}
