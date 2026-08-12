package problems.tree.bfs;

import common.tree.BinaryTreeUtils;
import common.tree.TreeNode;

// LEETCODE: 104 MAX DEPTH OF BinaryTreeUtils
public class LC0104MaximumDepthOfBinaryTree {

    public static void main(String[] args) {
        TreeNode root = BinaryTreeUtils.fromLevelOrder(4,2,7,1,3);
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
