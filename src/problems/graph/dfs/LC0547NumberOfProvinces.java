package problems.graph.dfs;

public class LC0547NumberOfProvinces {

    public static void main(String[] args) {

    }

    public static int findCircleNum(int[][] isConnected) {
        int size = isConnected.length;
        boolean[] visited = new boolean[size];

        int provinces = 0;

        for (int city = 0; city < size; city++) {
            if(!visited[city]) {
                provinces++;
                dfs(isConnected, visited, city);
            }
        }
        return provinces;
    }

    public static void dfs(int[][] isConnected, boolean[] visited, int city) {
        visited[city] = true;
        for (int neightbour = 0; neightbour < isConnected.length ; neightbour++) {
            if(!visited[neightbour] && isConnected[city][neightbour] == 1) {
                dfs(isConnected, visited, neightbour);
            }
        }
    }
}
