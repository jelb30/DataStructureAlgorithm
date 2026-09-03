package problems.graphs;

import java.util.ArrayList;

public class GFGCycleDetectionDFS {

    // RUNNING LOOP TO ALL UNVISITED, TO SECURE FOR THE CONNECT COMPONENTS PROBLEM,
    // IF WE HAVE JUST ONE COMPONENT NO NEED FOR THE LOOP.
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i= 0; i < V; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        boolean[] vis = new boolean[V];
        for(int i = 0; i < V; i++) {
            if(!vis[i]) {
                if(helperDfs(adj, vis, i, -1)) return true;
            }
        }
        return false;
    }

    public boolean helperDfs(ArrayList<ArrayList<Integer>> adj, boolean[] vis, int node, int parent) {

        vis[node] = true;
        for(int neigh: adj.get(node)) {
            if (!vis[neigh]) {
                if(helperDfs(adj, vis, neigh, node)) return true;
            } else if(parent != neigh) {
                return true;
            }
        }
        return false;
    }

}

