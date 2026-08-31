package problems.trees;
import common.tree.TreeNode;

// LEETCODE 101.
public class LC0101SymmetricTree {
    public static boolean symmetricTree(TreeNode root) {
        if(root == null){
            return true;
        }
        return isMirrored(root, root);
    }

    public static boolean isMirrored(TreeNode left, TreeNode right) {
        if(left != null && right != null){
            if(left.val != right.val){
                return false;
            }
            return isMirrored(left.left, right.right) && isMirrored(left.right, right.left);
        }else{
            if((left == null && right != null) || (left != null && right == null)){
                return false;
            }
            else return true;

        }
    }
}
