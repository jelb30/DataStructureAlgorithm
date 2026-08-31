package problems.trees;
import common.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class LC0103BinaryTreeZigzagLevelOrderTraversal {

    public static List<List<Integer>> zigzagOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>(); //will be returned as result
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int counter = 0;
        while (!queue.isEmpty()){

            int currentLevelSize = queue.size();
            List<Integer> levelList = new LinkedList<>();

            for (int i = 0; i < currentLevelSize; i++) {

                TreeNode node = queue.poll();
                if(counter%2==0){
                    levelList.add(node.val);
                }else{
                    levelList.add(0,node.val);
                }

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            counter++;
            result.add(levelList);
        }
        return result;
    }
}
