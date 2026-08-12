package problems.graph.topological_sort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC0207CourseSchedule {

    public static void main(String[] args) {

        int[][] prerequisites = {{0, 1}};
        int numCourses = 2;

        System.out.println(canFinish(numCourses, prerequisites));

    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        //making the adjuscent lists.
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        for ( int[] arr: prerequisites) {
            adjList.get(arr[1]).add(arr[0]);
        }

        int[] indegree = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        for(ArrayList<Integer> list: adjList){
            for(Integer i: list){
                indegree[i]++;
            }
        }
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        int count = 0;
        while(!queue.isEmpty()){
            int course = queue.poll();
            count++;
            for(int i: adjList.get(course)){
                indegree[i]--;
                if(indegree[i]==0){
                    queue.offer(i);
                }
            }
        }
        if(count == numCourses) {
            return true;
        }
        return false;
    }
}
