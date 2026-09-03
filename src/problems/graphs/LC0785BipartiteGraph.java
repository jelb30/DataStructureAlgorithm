package problems.graphs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class LC0785BipartiteGraph {

    public boolean isBipartite(int[][] graph) {

        int[] colors = new int[graph.length];
        Arrays.fill(colors, -1);

        for(int i= 0; i < graph.length; i++) {
            if(colors[i] == -1) {
                if(!helperBfs(i, graph, colors)) return false;
            }
        }
        return true;
    }

    public boolean helperBfs(int start, int[][] graph, int[] colors) {
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(start);
        colors[start] = 1;

        while(!q.isEmpty()) {
            int node = q.poll();
            int nodeColor = colors[node];

            for(int adjNode: graph[node]) {
                if(colors[adjNode] == -1) {
                    colors[adjNode] = 1 - nodeColor;
                    q.offer(adjNode);
                } else if(colors[adjNode] == nodeColor) {
                    return false;
                }
            }
        }
        return true;
    }
}
