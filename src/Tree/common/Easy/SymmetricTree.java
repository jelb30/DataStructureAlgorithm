package Tree.common.Easy;
import Tree.common.TreeNode;
import Tree.common.BT;

// LEETCODE 101.
public class SymmetricTree {
    public static void main(String[] args) {
        TreeNode root = BT.fromLevelOrder(1,2,2,null,3,null,3);
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
