package problems.trees;
import common.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class LC0199BinaryTreeRightSideView {

    public static List<Integer> levelOrder(TreeNode root) {

        List<Integer> finalResult = new ArrayList();

        if (root == null) return finalResult;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){

            int currentLevelSize = queue.size();

            for (int i = 0; i < currentLevelSize; i++) {

                TreeNode node = queue.poll();

                if(i == currentLevelSize-1){
                    finalResult.add(node.val);
                }

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);

            }
        }
        return finalResult;
    }
}
