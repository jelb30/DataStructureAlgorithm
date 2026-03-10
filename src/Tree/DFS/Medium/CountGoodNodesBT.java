package Tree.DFS.Medium;

import Tree.common.BT;
import Tree.common.TreeNode;

// LEETCODE PROBLEM 1448: MEDIUM --> PRE ORDER TRAVERSAL AS WE NEED SOME VALUES FORM PARENTS.
public class CountGoodNodesBT {

    public static int goodNodesCounts =0;

    public static void main(String[] args) {
        TreeNode root = BT.fromLevelOrder(3,3, null, 4, 2);
        BT.printTopDown(root);
        System.out.println(goodNodes(root));
    }

    public static int goodNodes(TreeNode root) {
        if(root == null) return 0;
        helper(root, root.val);
        return goodNodesCounts;

    }

    public static void helper (TreeNode root, int pathMax) {
        if(root == null) return;

        if(root.val >= pathMax) {
            pathMax = root.val;
            goodNodesCounts = goodNodesCounts + 1;
        }

        helper(root.left, pathMax);
        helper(root.right, pathMax);
    }
}
