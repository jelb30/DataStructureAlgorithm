package problems.disjoint_set;

public class LC1319MakeNetworkConnected {

    public int makeConnected(int n, int[][] connections) {
        DSUImplementation dsu = new DSUImplementation(n);
        int spareCables = 0;
        for(int[] connection: connections) {
            if(!dsu.union(connection[0], connection[1])) {
                spareCables++;
            }
        }
        int components = dsu.components;
        if(components-1 > spareCables) {
            return -1;
        } else {
            return components-1;
        }
    }
}
