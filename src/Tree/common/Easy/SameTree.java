package Tree.common.Easy;
import Tree.common.TreeNode;
import Tree.common.BT;

public class SameTree {

    public static void main(String[] args) {
        TreeNode root = BT.fromLevelOrder(1,2);
        TreeNode anotherRoot = BT.fromLevelOrder(1,2);
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
