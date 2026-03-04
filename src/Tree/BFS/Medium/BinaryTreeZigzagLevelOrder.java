package Tree.BFS.Medium;
import Tree.common.TreeNode;
import Tree.common.BT;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class BinaryTreeZigzagLevelOrder {

    public static void main(String[] args) {

        TreeNode root = BT.fromLevelOrder(3,9,20,null,null,15,7);

        List<List<Integer>> result = zigzagOrder(root);
        for(List<Integer> list : result){
            System.out.println(list);
        }
    }

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
