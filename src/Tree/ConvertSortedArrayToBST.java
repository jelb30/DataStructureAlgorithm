package Tree;

import Tree.common.BT;
import Tree.common.TreeNode;

public class ConvertSortedArrayToBST {

    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode root = sortedArrayToBST(nums);
        BT.printTopDown(root);
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return helper (nums, 0, nums.length - 1);
    }

    public static TreeNode helper(int[] nums, int start, int end) {
        if(start > end) return null;

        int mid = start + (end - start)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, start, mid - 1);
        root.right = helper(nums, mid + 1, end);
        return root;
    }
}
