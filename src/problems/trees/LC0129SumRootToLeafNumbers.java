package problems.trees;
import common.tree.TreeNode;
public class LC0129SumRootToLeafNumbers {

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
