package problems.topological_sort;
import java.util.*;

public class LC0210CourseScheduleII {

    public static void main(String[] args) {
        int[][] prerequisites = {{1, 0}};
        int numCourses = 2;

        int[] topoOrder = findOrder(numCourses, prerequisites);
        for(int i: topoOrder) {
            System.out.println(i+" ,");
        }

    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        int[] order = new int[numCourses];
        int[] inDegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] subArr: prerequisites) {
            int pre = subArr[1];
            int dep = subArr[0];
            adjList.get(pre).add(dep);
            inDegree[dep]++;
        }

        for (int i = 0; i < numCourses; i++) {
            if(inDegree[i]==0) {
                q.add(i);
            }
        }

        int index = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            order[index++] = node;

            for(int adjNode: adjList.get(node)) {
                inDegree[adjNode]--;
                if(inDegree[adjNode] == 0) {
                    q.add(adjNode);
                }
            }
        }

        return numCourses == index ? order : new int[]{};

    }
}
