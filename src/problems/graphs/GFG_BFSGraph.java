package problems.graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class GFG_BFSGraph {

    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {

        Deque<Integer> q = new ArrayDeque<>();
        ArrayList<Integer> result = new ArrayList<>();
        boolean[] vis = new boolean[adj.size()];

        q.offer(0);
        vis[0] = true;
        while(!q.isEmpty()) {
            int val = q.poll();
            result.add(val);
            for(int neigh: adj.get(val)) {
                if(!vis[neigh]) {
                    vis[neigh] = true;
                    q.offer(neigh);
                }
            }
        }
        return result;
    }

}
