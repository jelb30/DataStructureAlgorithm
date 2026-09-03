package problems.graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class LC1971FindifPathExists {

    public boolean validPath(int n, int[][] edges, int source, int destination) {

        if(source == destination) return true;

        if(edges.length == 0 ) return false;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] edge: edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        Deque<Integer> q = new ArrayDeque<>();
        boolean[] vis = new boolean[n];

        q.offer(source);
        vis[source] = true;
        while(!q.isEmpty()) {
            int node = q.poll();

            for(int nei: adj.get(node)) {
                if(destination == nei) {
                    return true;
                }
                if(!vis[nei]) {
                    vis[nei] = true;
                    q.offer(nei);
                }
            }
        }
        return false;
    }
}
