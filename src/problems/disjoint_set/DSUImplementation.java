package problems.disjoint_set;

public class DSUImplementation {
    int[] size, parent;
    int components;

    DSUImplementation(int n) {
        size = new int[n];
        components = n;
        parent = new int[n];

        for (int i = 0; i < n; i++) {
            size[i] = 1;
            parent[i] = i;
        }
    }

    int findParent(int node) {
        while(parent[node] != node) {
            parent[node] = parent[parent[node]]; //path halving
            node = parent[node];
        }
        return node;
    }

    boolean union(int a, int b) {
        int ra = findParent(a), rb = findParent(b);
        if(ra == rb) return false;

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

