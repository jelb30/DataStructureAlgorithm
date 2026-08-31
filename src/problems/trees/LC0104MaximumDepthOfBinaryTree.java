package problems.trees;
import common.tree.TreeNode;

// LEETCODE: 104 MAX DEPTH OF BinaryTreeUtils
public class LC0104MaximumDepthOfBinaryTree {

    public static int maxDepth(TreeNode root) {
        if(root == null) return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left, right) + 1;
    }
}
