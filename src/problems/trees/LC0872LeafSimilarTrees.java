package problems.trees;
import common.tree.TreeNode;

import java.util.ArrayList;

public class LC0872LeafSimilarTrees {

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
