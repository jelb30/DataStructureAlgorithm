package problems.graphs;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class GFGCycleDetectionBFS {

    //BFS order with parent checking.
    // RUNNING LOOP TO ALL UNVISITED, TO SECURE FOR THE CONNECT COMPONENTS PROBLEM,
    // IF WE HAVE JUST ONE COMPONENT NO NEED FOR THE LOOP.
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        ArrayList<ArrayList<Integer>> adj = constructAdjacency(edges, V);

        boolean[] vis = new boolean[V];
        for(int i = 0; i < V; i++) {
            if(!vis[i]) {
                if(cycleDetector(adj, vis, i)) return true;
            }
        }
        return false;
    }

    // Constructing adj list from edges.
    public ArrayList<ArrayList<Integer>> constructAdjacency(int[][] edges, int V) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i= 0; i < V; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        return adj;
    }

    public boolean cycleDetector(ArrayList<ArrayList<Integer>> adj,boolean[] vis, int start) {

        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{start, -1});
        vis[start]= true;

        while(!q.isEmpty()) {
            int[] values = q.poll();
            int node = values[0];
            int parent = values[1];

            for(int neigh: adj.get(node)) {
                if(!vis[neigh]) {
                    vis[neigh] = true;
                    q.offer(new int[]{neigh, node});
                } else if(neigh != parent) {
                    return true;
                }
            }
        }
        return false;
    }
}
