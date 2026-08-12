package problems.tree.dfs;

import common.tree.TreeNode;
import common.tree.BinaryTreeUtils;

public class LC0129SumRootToLeafNumbers {


    public static void main(String[] args) {
        TreeNode root = BinaryTreeUtils.fromLevelOrder(1,null,3);
        BinaryTreeUtils.printTopDown(root);

        System.out.println(sumNumbers(root));
    }

    public static int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        return helperMethod(root, 0);
    }

    public static int helperMethod(TreeNode root, int currentNum) {
        if(root == null) {
            return 0;
        }

        int currentNumber = currentNum * 10 + root.val;
        if(root.left == null && root.right == null) {
            return currentNumber;
        }

        return helperMethod(root.left, currentNumber) + helperMethod(root.right, currentNumber);
    }
}
