package Tree.BFS.Easy;
import Tree.common.TreeNode;
import Tree.common.BT;

import java.util.LinkedList;
import java.util.Queue;

public class MinBtDepth {

    public static void main(String[] args) {
        TreeNode root = BT.fromLevelOrder(3,9,20,null,null,15,7);
        int minDepth = minDepth(root);
        System.out.println(minDepth);
    }

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
