package problems.tree.dfs;

import common.tree.BinaryTreeUtils;
import common.tree.TreeNode;

import java.util.HashSet;

public class LC1457PseudoPalindromicPathsInABinaryTree {

    public static int counter = 0;

    public static void main(String[] args) {
        TreeNode root = BinaryTreeUtils.fromLevelOrder(2,3,1,3,1,null,1);
        BinaryTreeUtils.printTopDown(root);

        System.out.println(pseudoPalindromicPaths(root));
    }

    public static int pseudoPalindromicPaths (TreeNode root) {
        if (root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        HashSet<Integer> set = new HashSet<>();
        helper(root, set);
        return counter;
    }

    // NOT OPTIMIZED, BUT YEAH WORKS.
    public static int helper(TreeNode root, HashSet<Integer> set){

        if(set.contains(root.val)){
            set.remove(root.val);
        }else {
            set.add(root.val);
        }

        if(root.left != null) helper(root.left, new HashSet<>(set));
        if(root.right != null) helper(root.right, new HashSet<>(set));

        if(root.left == null && root.right == null) if(set.size() <= 1) counter++;

        return 0;
    }


}
