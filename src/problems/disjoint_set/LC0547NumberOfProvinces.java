package problems.disjoint_set;

public class LC0547NumberOfProvinces {

    public static void main(String[] args) {
        Solution obj = new Solution();
        obj.findCircleNum(new int[][] {{1,1,0}, {1,1,0}, {0, 0, 1}});
    }

}

class Solution {
    public int findCircleNum(int[][] isConnected) {

        DisjoinSet dsuObject = new DisjoinSet(isConnected.length);
        for(int i = 0; i < isConnected.length; i++) {
            for(int j = 0; j < isConnected.length; j++) {
                if(isConnected[i][j] == 1) {
                    dsuObject.unionBySize(i, j);
                }
            }
        }
        return dsuObject.components;
    }

}

class DisjoinSet {
    int[] size, parent;
    int components;

    DisjoinSet(int n) {
        this.components = n;
        size = new int[n];
        parent = new int[n];
        for(int i = 0; i < n; i++) {
            size[i] = 1;
            parent[i] = i;
        }
    }

    int findParent(int node) {
        while(parent[node] != node) {
            parent[node] = parent[parent[node]];
            node = parent[node];
        }
        return node;
    }

    boolean unionBySize(int a, int b) {
        int ra = findParent(a);
        int rb = findParent(b);
        if( ra == rb ) return false;

        if(size[ra] < size[rb]) {
            int tmp = ra;
            ra = rb;
            rb = tmp;
        }

        parent[rb] = ra;
        size[ra] += size[rb];
        components--;
        return true;
    }
}