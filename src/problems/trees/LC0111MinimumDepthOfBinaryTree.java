package problems.trees;
import common.tree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

public class LC0111MinimumDepthOfBinaryTree {

    public static int minDepth(TreeNode root) {
        if(root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int level = 0;
        while(!queue.isEmpty()){

            int size = queue.size();
            level++;

            for(int i = 0; i < size; i++){

                TreeNode node = queue.poll();
                if(node.left == null && node.right == null){
                    return level;
                }

                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }

        }
        return level;
    }

}
