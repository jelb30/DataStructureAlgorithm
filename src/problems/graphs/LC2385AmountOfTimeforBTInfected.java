package problems.graphs;
import common.tree.TreeNode;

import java.util.*;

public class LC2385AmountOfTimeforBTInfected {

    public int amountOfTime(TreeNode root, int start) {

        Map<Integer, List<Integer>> graph = new HashMap<>();
        convertToGraph(root, null , graph);

        Deque<Integer> queue = new ArrayDeque<>();
        Set<Integer> seenValues = new HashSet<>();
        queue.offer(start);
        seenValues.add(start);

        int timeToSpread = -1;

        while(!queue.isEmpty()) {
            timeToSpread++;
            int currSize = queue.size();

            for (int i = 0; i < currSize; i++) {
                int val = queue.poll();
                for(int node : graph.getOrDefault(val, new ArrayList<>())) {
                    if(!seenValues.contains(node)) {
                        queue.offer(node);
                        seenValues.add(node);
                    }
                }
            }
        }
        return timeToSpread;
    }

    public void convertToGraph(TreeNode node, TreeNode parent, Map<Integer, List<Integer>> graph) {
        if(node == null) return;

        graph.putIfAbsent(node.val, new ArrayList<>());

        if(parent != null) {
            graph.get(parent.val).add(node.val);
            graph.get(node.val).add(parent.val);
        }

        convertToGraph(node.left, node, graph);
        convertToGraph(node.right, node, graph);
    }

}
