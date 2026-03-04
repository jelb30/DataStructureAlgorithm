package Tree.BFS.Medium;

import Tree.common.TreeNode;
import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointer {

    public static void main(String[] args) {

    }

    public TreeNode connect(TreeNode root) {

        if(root == null) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){

            int currentSize = queue.size();

            for(int i = 0; i < currentSize; i++){
                TreeNode node = queue.poll();

                if(i == currentSize - 1) node.next = null;
                else node.next = queue.peek();
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
        }
        return root;
    }

    public TreeNode connectOptimized(TreeNode root) {
        if (root == null) return null;

        TreeNode leftMost = root;
        leftMost.next = null;

        while (leftMost.left != null) {
            TreeNode current = leftMost;
            while (current != null) {
                current.left.next = current.right;
                if (current.next != null) current.right.next = current.next.left;
                current = current.next;
            }
            leftMost = leftMost.left;

        }
        return root;
    }
}
