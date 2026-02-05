package Tree.common;

import java.util.*;

public final class BT {
    private BT() {}

    // Build tree from level order like LeetCode:
    // fromLevelOrder(1,2,3,null,4) => [1,2,3,null,4]
    public static TreeNode fromLevelOrder(Integer... arr) {
        if (arr == null || arr.length == 0 || arr[0] == null) return null;

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        int i = 1;
        while (!q.isEmpty() && i < arr.length) {
            TreeNode cur = q.poll();

            if (i < arr.length && arr[i] != null) {
                cur.left = new TreeNode(arr[i]);
                q.offer(cur.left);
            }
            i++;

            if (i < arr.length && arr[i] != null) {
                cur.right = new TreeNode(arr[i]);
                q.offer(cur.right);
            }
            i++;
        }
        return root;
    }

    // Print tree in level order (compact)
    public static void print(TreeNode root) {
        System.out.println(levelOrderString(root));
    }

    public static String levelOrderString(TreeNode root) {
        if (root == null) return "empty";

        List<String> out = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            if (cur == null) {
                out.add("null");
            } else {
                out.add(String.valueOf(cur.val));
                q.offer(cur.left);
                q.offer(cur.right);
            }
        }

        // trim trailing "null"s for neat output
        int end = out.size() - 1;
        while (end >= 0 && out.get(end).equals("null")) end--;
        return out.subList(0, end + 1).toString();
    }

    // Common quick traversals (optional)
    public static List<Integer> inorder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorderDfs(root, res);
        return res;
    }

    private static void inorderDfs(TreeNode node, List<Integer> res) {
        if (node == null) return;
        inorderDfs(node.left, res);
        res.add(node.val);
        inorderDfs(node.right, res);
    }
}
