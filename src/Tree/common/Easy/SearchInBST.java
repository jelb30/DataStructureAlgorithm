package Tree.common.Easy;
import Tree.common.TreeNode;
import Tree.common.BT;

// LEETCODE 700: SEARCH IN BINARY TREE.
public class SearchInBST {
    public static void main(String[] args) {
        TreeNode root = BT.fromLevelOrder(4,2,7,1,3);
        TreeNode Node = searchBST(root, 2);
        System.out.println(Node.val);
    }

    public static TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        if (root.val > val) {
            return searchBST(root.left, val);
        }else{
            return searchBST(root.right, val);
        }
    }

}
