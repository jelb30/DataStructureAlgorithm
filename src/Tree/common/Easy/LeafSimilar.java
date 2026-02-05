package Tree.common.Easy;

import Tree.common.BT;
import Tree.common.TreeNode;

import java.util.ArrayList;

public class LeafSimilar {

    public static void main(String[] args) {
        TreeNode root = BT.fromLevelOrder(10,5,15);
        TreeNode anotherRoot = BT.fromLevelOrder(10,5,null,null,15);
        boolean result = leafSimilar(root, anotherRoot);
        System.out.println(result);
    }

    public static boolean leafSimilar(TreeNode root, TreeNode anotherRoot) {
        ArrayList<Integer> list = leafs(root, new ArrayList<>());
        ArrayList<Integer> list2 = leafs(anotherRoot, new ArrayList<>());

        if(list.size() != list2.size()){
            return false;
        }

        for (int i = 0; i < list.size(); i++) {
            if(!list.get(i).equals(list2.get(i))){
                System.out.println(list.get(i) + " " + list2.get(i));
                return false;
            }
        }
        return true;
    }

    public static ArrayList<Integer> leafs(TreeNode root, ArrayList<Integer> list) {

        if (root.left == null && root.right == null) {
            list.add(root.val);
            return list;
        }
        if (root.left != null) {
            leafs(root.left, list);
        }
        if (root.right != null) {
            leafs(root.right, list);
        }
        return list;
    }
}
