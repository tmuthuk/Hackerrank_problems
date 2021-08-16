package utils.graphs;

import java.util.*;

/**
 * Ref: https://youtu.be/cIBFEhD77b4
 */
public class TopologicalSortKahns {

    public void topSort(HashMap<Integer, HashSet<Integer>> adjList) {
        // Keep an array of incoming degree counters for each node
        // Add all the nodes into a Q for which incoming degree counter is 0
        // loop through the nodes in the q
        // Mark them as visited
        // count the indexes. At the end it should be 0

        int[] inDegree = new int[adjList.size()];
        int[] order = new int[adjList.size()];

        for(Map.Entry<Integer, HashSet<Integer>> entry: adjList.entrySet()) {
            HashSet<Integer> set = entry.getValue();

            for(Integer node: set) {
                inDegree[node] += 1;
            }
        }
        Queue<Integer> q = new LinkedList<Integer>();

        for(int i=0; i<adjList.size(); i++) {
            if(inDegree[i] ==0) {
                q.offer(i);
            }
        }

        int index = 0;
        while (!q.isEmpty()) {
            int node = q.poll();

            order[index] = node;
            // for this node go through all the nodes in the adj list and decrement them by one

            HashSet<Integer> set= adjList.get(node);

            for(int nodes: set) {
                inDegree[node] -= 1;
                if(inDegree[node] == 0) {
                    q.offer(node);
                }
            }
            index++;
        }

        if(index != adjList.size()) {
            System.out.println("Graph has cycles");
        }


    }
}
