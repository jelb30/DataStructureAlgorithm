package problems.trees;
import common.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LC1161MaximumLevelSumOfABinaryTree {

    public static int maxLevelSum(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int count = 1;
        int result = Integer.MIN_VALUE;
        int level = 0;

        while(queue.isEmpty() == false){
            int size = queue.size();
            int levelSum = 0;

            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                levelSum += node.val;
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            if(levelSum > result) {
                result = levelSum;
                level = count;
            }
            count++;
        }
        return level;
    }
}
