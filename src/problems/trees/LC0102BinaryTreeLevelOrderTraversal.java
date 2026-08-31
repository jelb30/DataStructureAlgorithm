package problems.trees;
import common.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class LC0102BinaryTreeLevelOrderTraversal {

    public static List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>(); //will be returned as result
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){

            int currentLevelSize = queue.size();
            List<Integer> levelList = new ArrayList<>();

            for (int i = 0; i < currentLevelSize; i++) {

                TreeNode node = queue.poll();
                levelList.add(node.val);

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);

            }
            result.add(levelList);
        }
        return result;
    }
}
