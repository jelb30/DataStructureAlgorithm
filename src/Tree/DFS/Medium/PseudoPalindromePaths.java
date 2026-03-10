package Tree.DFS.Medium;

import Tree.common.BT;
import Tree.common.TreeNode;

import java.util.HashSet;

public class PseudoPalindromePaths {

    public static int counter = 0;

    public static void main(String[] args) {
        TreeNode root = BT.fromLevelOrder(2,3,1,3,1,null,1);
        BT.printTopDown(root);

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
