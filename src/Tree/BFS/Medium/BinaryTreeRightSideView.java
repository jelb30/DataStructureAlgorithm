package Tree.BFS.Medium;
import Tree.common.TreeNode;
import Tree.common.BT;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class BinaryTreeRightSideView {

    public static void main(String[] args) {

        TreeNode root = BT.fromLevelOrder(3,1,5,null,2,4,6);
        BT.printTopDown(root);

        List<Integer> result = levelOrder(root);
        for(int i : result){
            System.out.println(i);
        }
    }

    public static List<Integer> levelOrder(TreeNode root) {

        ArrayList<Integer> finalResult = new ArrayList();

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
