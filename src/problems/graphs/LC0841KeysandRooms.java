package problems.graphs;

import java.util.List;

public class LC0841KeysandRooms {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        boolean[] visited = new boolean[rooms.size()];
        dfs(0, visited, rooms);
        for(boolean isVisited: visited) {
            if(!isVisited) {
                return false;
            }
        }
        return true;
    }

    public void dfs(int index, boolean[] visited, List<List<Integer>> rooms) {
        if(visited[index] == true) {
            return;
        }
        visited[index] = true;
        for(int i: rooms.get(index)) {
            visited[i] = true;
            dfs(i, visited, rooms);
        }
    }
}
