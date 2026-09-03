package problems.topological_sort;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class GFGToposortKahnsBFS {

    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] indegrees = new int[V];
        Deque<Integer> queue = new ArrayDeque<>();
        ArrayList<Integer> res = new ArrayList<>();

        //Making adj list
        for(int i = 0; i < V; i++) {
            adj.add(new ArrayList<Integer>());
        }

        for(int[] edge: edges) {
            adj.get(edge[0]).add(edge[1]);
            indegrees[edge[1]]++;
        }

        for(int i=0; i < V; i++) {
            if(indegrees[i] == 0) {
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()) {
            int node = queue.poll();
            res.add(node);

            for(int adjNode: adj.get(node)) {
                indegrees[adjNode]--;
                if(indegrees[adjNode] == 0) {
                    queue.offer(adjNode);
                }
            }
        }
        return res;
    }
}
