package problems.topological_sort;

import java.util.*;

public class LC0802FindEventualSafeState {

    public List<Integer> eventualSafeNodes(int[][] graph) {
        // convert the out degrees into indegrees --> reverse it

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] indeg = new int[graph.length];
        Deque<Integer> q = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();

        for(int i = 0; i < graph.length; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i =0; i < graph.length; i++) {
            for(int node: graph[i]) {
                adj.get(node).add(i);
                indeg[i]++;
            }
        }

        for(int i = 0; i < indeg.length; i++) {
            if(indeg[i]==0) {
                q.offer(i);
            }
        }

        while(!q.isEmpty()) {
            int node = q.poll();
            res.add(node);

            for(int adjNode: adj.get(node)) {
                if(--indeg[adjNode] == 0) {
                    q.offer(adjNode);
                }
            }
        }
        Collections.sort(res);
        return res;
    }

}
