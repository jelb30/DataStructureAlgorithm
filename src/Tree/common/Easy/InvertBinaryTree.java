package Tree.common.Easy;
import Tree.common.TreeNode;
import Tree.common.BT;

// LEETCODE 226.
public class InvertBinaryTree {

    public static void main(String[] args) {
        TreeNode root = BT.fromLevelOrder(4,2,7,1,3,6,9);
        TreeNode Node = invertBinaryTree(root);
        BT.print(Node);
    }

    public static TreeNode invertBinaryTree(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        if (root.left != null && root.right != null){
            invertBinaryTree(root.left);
            invertBinaryTree(root.right);
        }
        return root;
    }
}
