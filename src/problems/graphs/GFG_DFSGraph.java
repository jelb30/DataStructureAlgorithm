package problems.graphs;

import java.util.ArrayList;
import java.util.List;

public class GFG_DFSGraph {

    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        if(adj.isEmpty()) {
            return new ArrayList<>();
        }
        int size = adj.size();
        ArrayList<Integer> res = new ArrayList<>();
        boolean[] vis = new boolean[size]; //because it starts with 0 node. if 1 then size+1

        dfs(0, vis, adj, res);
        return res;
    }

    // DFS Traversal: Called per each node, iterates on the neighbours.
    public void dfs(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> res) {
        vis[node] = true;
        res.add(node);

        // Iterating neighbours per every Node and calling dfs.
        for(int child: adj.get(node)) {
            if (!vis[child]) {
                dfs(child, vis, adj, res);
            }
        }
    }

}
