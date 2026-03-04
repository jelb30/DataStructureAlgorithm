package Tree.DFS.Medium;

import Tree.common.TreeNode;
import Tree.common.BT;

public class SumRootToLeafNumber {


    public static void main(String[] args) {
        TreeNode root = BT.fromLevelOrder(1,null,3);
        BT.printTopDown(root);

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
