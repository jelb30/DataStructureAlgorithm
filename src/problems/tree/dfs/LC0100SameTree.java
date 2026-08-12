package problems.tree.dfs;
import common.tree.TreeNode;
import common.tree.BinaryTreeUtils;

public class LC0100SameTree {

    public static void main(String[] args) {
        TreeNode root = BinaryTreeUtils.fromLevelOrder(1,2);
        TreeNode anotherRoot = BinaryTreeUtils.fromLevelOrder(1,2);
        Boolean result = isSameTree(root, anotherRoot);
        System.out.println(result);
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return true;
        }
        if(p == null || q == null) {
            return false;
        }
        if(p.val != q.val) {
            return false;
        }else{
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }
}
