package problems.topological_sort;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class GFGTopologicalSortDFS {

    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++) {
            adj.add(new ArrayList<Integer>());
        }

        for(int[] edge: edges) {
            adj.get(edge[0]).add(edge[1]);
        }

        //REAL LOGIC AFTER ADJ list.
        boolean[] vis = new boolean[V];
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i= 0; i< V; i++) {
            if(!vis[i]) {
                dfs(adj, vis, i, stack);
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        for(int index = 0; index < V; index++) {
            res.add(index, stack.pop());
        }
        return res;

    }

    public void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] vis, int node, Deque<Integer> stack) {
        vis[node] = true;

        for(int adjNode: adj.get(node)) {
            if(!vis[adjNode]) {
                dfs(adj, vis, adjNode, stack);
            }
        }
        stack.push(node);
    }
}
