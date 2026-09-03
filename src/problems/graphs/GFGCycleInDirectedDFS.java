package problems.graphs;

import java.util.ArrayList;

public class GFGCycleInDirectedDFS {

    public boolean isCyclic(int V, int[][] edges) {
        // code here
        //Adj list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i< V; i++) {
            adj.add(new ArrayList<Integer>());
        }
        for(int[] edge: edges) {
            adj.get(edge[0]).add(edge[1]);
        }

        //Actual logic.
        // SPACE COMPLEXITY: N
        // TIME COMPLEXITY: N + E
        boolean[] vis = new boolean[V];
        boolean[] pathVis = new boolean[V];

        for(int i= 0; i<V; i++) {
            if(!vis[i]) {
                if(dfsHelper(adj, vis, pathVis, i)) return true;
            }
        }
        return false;

    }

    public boolean dfsHelper(ArrayList<ArrayList<Integer>> adj, boolean[] vis, boolean[] pathVis, int node) {
        vis[node] = true;
        pathVis[node] = true;

        for(int adjNode: adj.get(node)) {
            if(!vis[adjNode]) {
                if(dfsHelper(adj, vis, pathVis, adjNode)) return true;
            } else if(pathVis[adjNode]) {
                return true;
            }
        }
        pathVis[node] = false;
        return false;
    }

}
