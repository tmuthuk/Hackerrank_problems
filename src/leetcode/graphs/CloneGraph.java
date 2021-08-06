package leetcode.graphs;

import utils.graphs.GraphNode;

import java.util.*;

/**
 * LC medium 133
 *Given a reference of a node in a connected undirected graph.
 *
 * Return a deep copy (clone) of the graph.
 *
 * Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.
 *
 * class Node {
 *     public int val;
 *     public List<Node> neighbors;
 * }
 *
 *
 * Test case format:
 *
 * For simplicity, each node's value is the same as the node's index (1-indexed). For example, the first node with val == 1, the second node with val == 2, and so on. The graph is represented in the test case using an adjacency list.
 *
 * An adjacency list is a collection of unordered lists used to represent a finite graph. Each list describes the set of neighbors of a node in the graph.
 *
 * The given node will always be the first node with val = 1. You must return the copy of the given node as a reference to the cloned graph.
 *
 *Example 1:
 *Input: adjList = [[2,4],[1,3],[2,4],[1,3]]
 * Output: [[2,4],[1,3],[2,4],[1,3]]
 * Explanation: There are 4 nodes in the graph.
 * 1st node (val = 1)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
 * 2nd node (val = 2)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
 * 3rd node (val = 3)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
 * 4th node (val = 4)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
 *
 * Example 2:
 * Input: adjList = [[]]
 * Output: [[]]
 * Explanation: Note that the input contains one empty list. The graph consists of only one node with val = 1 and it does not have any neighbors.
 *
 * Example 3:
 *
 * Input: adjList = []
 * Output: []
 * Explanation: This an empty graph, it does not have any nodes.
 * Example 4:
 * Input: adjList = [[2],[1]]
 * Output: [[2],[1]]
 */
public class CloneGraph {
    /**
     * Bread First visit each node,
     * build the neighbors (create one in the map if not present) and add to it's list
     * @param node
     * @return
     */
    public GraphNode cloneGraph(GraphNode node) {
        Queue<GraphNode> q = new LinkedList<GraphNode>();

        HashMap<Integer, GraphNode> adjMap = new HashMap<>();

        HashSet<Integer> visited = new HashSet<>();

        if(node != null) {
            q.offer(node); }
        else {
            // if its an empty node, return null
            return null;
        }

        while(!q.isEmpty()) {
            GraphNode curNode = q.poll();
            List<GraphNode> neighbors = curNode.neighbors.isEmpty()? new ArrayList<GraphNode>() : curNode.neighbors;
            GraphNode newNode = null;

            if(visited.contains(curNode.val)) {continue;}
            if(adjMap.containsKey(curNode.val)) {
                newNode = adjMap.get(curNode.val);

            } else {
                // create that node
                newNode = new GraphNode(curNode.val);
                adjMap.put(curNode.val, newNode);
            }
            q.addAll(curNode.neighbors);

            int i = 0;
            while(i < neighbors.size()) {
                // visit each one of them
                GraphNode curN1 = neighbors.get(i);
                GraphNode newN1 = null;
                if(adjMap.containsKey(curN1.val)) {
                    // get that node and add it to the new Node
                    newN1 = adjMap.get(curN1.val); // get 2
                } else {
                    // neighbor doesn't exist, create the neighbor and add it
                    newN1 = new GraphNode(curN1.val);
                    adjMap.put(curN1.val, newN1);
                }

                newNode.neighbors.add(newN1); // adding 2 to adjList of 1
                adjMap.put(newNode.val, newNode);
                i++;
            }

            visited.add(curNode.val);
        }
        return adjMap.get(node.val);
    }
}
