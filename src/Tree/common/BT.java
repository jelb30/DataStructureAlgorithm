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

            // Left child
            if (i < arr.length && arr[i] != null) {
                cur.left = new TreeNode(arr[i]);
                q.offer(cur.left);
            }
            i++;

            // Right child
            if (i < arr.length && arr[i] != null) {
                cur.right = new TreeNode(arr[i]);
                q.offer(cur.right);
            }
            i++;
        }
        return root;
    }

    // Print tree as LeetCode Array String
    public static void printLeetCodeArray(TreeNode root) {
        System.out.println(levelOrderString(root));
    }

    public static String levelOrderString(TreeNode root) {
        if (root == null) return "[]";

        List<String> out = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
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
        return "[" + String.join(",", out.subList(0, end + 1)) + "]";
    }

    // NEW: Visually prints the tree in the console (Top-Down)
    public static void printTopDown(TreeNode root) {
        if (root == null) {
            System.out.println("(empty tree)");
            return;
        }
        System.out.println("\n--- Top-Down Tree ---");
        int maxLevel = BT.maxLevel(root);
        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
        System.out.println("---------------------\n");
    }

    private static void printNodeInternal(List<TreeNode> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int edgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        printWhitespaces(firstSpaces);

        List<TreeNode> newNodes = new ArrayList<>();
        for (TreeNode node : nodes) {
            if (node != null) {
                System.out.print(node.val);
                newNodes.add(node.left);
                newNodes.add(node.right);
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }
            printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= edgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    printWhitespaces(edgeLines + edgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).left != null)
                    System.out.print("/");
                else
                    printWhitespaces(1);

                printWhitespaces(i + i - 1);

                if (nodes.get(j).right != null)
                    System.out.print("\\");
                else
                    printWhitespaces(1);

                printWhitespaces(edgeLines + edgeLines - i);
            }
            System.out.println("");
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private static int maxLevel(TreeNode node) {
        if (node == null)
            return 0;
        return Math.max(maxLevel(node.left), maxLevel(node.right)) + 1;
    }

    private static boolean isAllElementsNull(List<TreeNode> list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }
        return true;
    }
}