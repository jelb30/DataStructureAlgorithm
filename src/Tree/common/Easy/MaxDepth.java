package Tree.common.Easy;

import Tree.common.BT;
import Tree.common.TreeNode;

// LEETCODE: 104 MAX DEPTH OF BT
public class MaxDepth {

    public static void main(String[] args) {
        TreeNode root = BT.fromLevelOrder(4,2,7,1,3);
        int maxDepth = maxDepth(root);
        System.out.println(maxDepth);
    }

    public static int maxDepth(TreeNode root) {
        if(root == null) return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left, right) + 1;
    }
}
