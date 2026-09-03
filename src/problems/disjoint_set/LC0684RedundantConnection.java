package problems.disjoint_set;

import java.util.Arrays;

public class LC0684RedundantConnection {

    public int[] findRedundantConnection(int[][] edges) {

        DSUImplementation dsu = new DSUImplementation(edges.length);
        for(int[] edge: edges) {
            if(!dsu.union(edge[0], edge[1])) {
                return new int[]{edge[0], edge[1]};
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[][] edges = new int[][] {{0,1}, {0,2}, {1,2}};
        LC0684RedundantConnection object = new LC0684RedundantConnection();
        System.out.println(Arrays.toString(object.findRedundantConnection(edges)));

    }

}