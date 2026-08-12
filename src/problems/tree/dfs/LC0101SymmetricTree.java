package problems.tree.dfs;
import common.tree.TreeNode;
import common.tree.BinaryTreeUtils;

// LEETCODE 101.
public class LC0101SymmetricTree {
    public static void main(String[] args) {
        TreeNode root = BinaryTreeUtils.fromLevelOrder(1,2,2,null,3,null,3);
        boolean result = symmetricTree(root);
        System.out.println(result);
    }

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
