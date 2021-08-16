package leetcode.graphs;

import java.util.*;

/**
 * LC Medium #210
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
 *
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.
 *
 *
 *
 * Example 1:
 *
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: [0,1]
 * Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].
 * Example 2:
 *
 * Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
 * Output: [0,2,1,3]
 * Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
 * So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
 * Example 3:
 *
 * Input: numCourses = 1, prerequisites = []
 * Output: [0]
 *
 *
 * Constraints:
 *
 * 1 <= numCourses <= 2000
 * 0 <= prerequisites.length <= numCourses * (numCourses - 1)
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * ai != bi
 * All the pairs [ai, bi] are distinct.
 */
public class CourseSchedule2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        /** Topological Sort using Kahn's algorithm
         This algorithm can has the ability to detect cycles
         */

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


        // Initialize a incoming degree counter for each course
        int[] inDegree = new int[numCourses];

        // Initialize the array to hold the top sorted elements
        int[] order = new int[numCourses];

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
            order[(numCourses-1) - index] = node;

            HashSet<Integer> set = adjList.get(node);

            for(int childNode: set) {
                inDegree[childNode] -= 1;

                if(inDegree[childNode] == 0) {
                    q.offer(childNode);
                }
            }
            index++;
        }
        return (index == numCourses) ? order : new int[0];
    }
}
