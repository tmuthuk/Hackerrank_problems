package leetcode.graphs;

import java.util.*;

/**
 * LC medium #207
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
 *
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return true if you can finish all courses. Otherwise, return false.
 *
 * Example 1:
 *
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0. So it is possible.
 * Example 2:
 *
 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 *
 *
 * Constraints:
 *
 * 1 <= numCourses <= 105
 * 0 <= prerequisites.length <= 5000
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * All the pairs prerequisites[i] are unique.
 */
public class CourseSchedule {
    /** Topological Sort using Kahn's algorithm
    This algorithm can has the ability to detect cycles
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
    // Step 1: Build the adjacency List
    HashMap<Integer, HashSet<Integer>> adjList = new HashMap<>();
        for(int i = 0; i<numCourses; i++) {
        adjList.put(i, new HashSet<Integer>());
    }
        for(int i=0; i< prerequisites.length; i++) {
        int from = prerequisites[i][0];
        int to = prerequisites[i][1];
        HashSet<Integer> set = adjList.get(from);
        set.add(to);
        adjList.put(from, set);
    }

    // Initialize a Topological Order array
    int[] order = new int[numCourses];

    // Initialize a incoming degree counter for each course
    int[] inDegree = new int[numCourses];

    // iterate over each node in the adjacency list and increment the counter for each course
        for(Map.Entry<Integer, HashSet<Integer>> entry: adjList.entrySet()) {
        for(int node: entry.getValue()){
            inDegree[node] += 1;
        }
    }

        System.out.println(inDegree.length);
    // Instantiate a Queue and add the elements with 0 dependency into it
    Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i<numCourses; i++) {
        if(inDegree[i] == 0) {
            q.offer(i);
        }
    }

    int index =0;
        while(!q.isEmpty()) {
        int node = q.poll();

        order[index] = node;

        HashSet<Integer> set = adjList.get(node);

        for(int childNode: set) {
            inDegree[childNode] -= 1;

            if(inDegree[childNode] == 0) {
                q.offer(childNode);
            }
        }
        index++;
    }

        return index == numCourses;

}
}
