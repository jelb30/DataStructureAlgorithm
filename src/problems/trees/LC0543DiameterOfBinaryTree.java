package problems.trees;
import common.tree.TreeNode;
import common.tree.BinaryTreeUtils;

public class LC0543DiameterOfBinaryTree {

    public static int maxDiameter;

    public static void main(String[] args) {
        TreeNode root = BinaryTreeUtils.fromLevelOrder(4,-7,-3,null,null,-9,-3,9,-7,-4,null,6,null,-6,-6,null,null,0,6,5,null,9,null,null,-1,-4,null,null,null,-2);
        BinaryTreeUtils.printTopDown(root);

        System.out.println(diameterOfBinaryTree(root));

    }

    public static int diameterOfBinaryTree(TreeNode root) {
        helperMethod(root);
        return maxDiameter;
    }

    public static int helperMethod(TreeNode root) {
        if(root == null) return 0;

        int leftSum = helperMethod(root.left);
        int rightSum = helperMethod(root.right);

        maxDiameter = Math.max(maxDiameter, leftSum + rightSum);

        return Math.max(leftSum, rightSum) + 1;
    }
}
