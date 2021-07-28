package utils.graphs;

import java.util.*;

/**
 * References:
 * William Fiset - https://youtu.be/0jNmHPfA_yE
 * Abdul bari - https://youtu.be/wU6udHRIkcc
 *
 * Note: this implementation does not do path compression
 */
public class UnionFind {
    static int size = 12;
    public static HashMap<String, HashSet<String>> adjacencyList = new HashMap<>();
    public static HashMap<Integer, String> revArrLoc = new HashMap<>();
    public static HashMap<String, Integer> arrLoc = new HashMap<>();

    public static int[] graph = new int[size];

    // variables:
    // 1. A list of sub graphs
    // construction O(n)
    // Union X(n)
    // Find  X(n)
    // Get component size X(n)
    // check if connected X(n)
    // count components O(1)
    // X(n) - amortized(read almost) constant time
// Union Find WITHOUT path compression
//
//    E F I D C A J L G K  B H
//    0 1 2 3 4 5 6 7 8 9 10 11
//
//    Union(C, K)
//    Union(F, E)
//    Union(A, J)
//    Union(A, B)
//    Union(C, D)
//    Union(D, I)
//    Union(L, F)
//    Union(C, A)
//    Union(A, B)
//    Union(H, G)
//    Union(H, F)
//    Union(H, B)

    /**
     * Union Op
     * To unify two elements find which are the root nodes of each component if the root nodes are different make
     * one of the root nodes to be parent of the other
     */

    public static void Union(String node1, String node2) {

        // find the parent of node 1 and node 2
        int node1Parent = find(node1);
        int node2Parent = find(node2);

        int node1ParentSize = findSize(revArrLoc.get(node1Parent));
        int node2ParentSize = findSize(revArrLoc.get(node2Parent));

        // find the size of each sub graph of node1 and node2
        if(node1ParentSize >= node2ParentSize) {
            //merge node2 into node 1
            buildAdjacencyList(revArrLoc.get(node1Parent), revArrLoc.get(node2Parent));
        } else {
            // merge node1 into node 2
            buildAdjacencyList(revArrLoc.get(node2Parent), revArrLoc.get(node1Parent));

        }
        // merge smaller of the graphs to which either node1 or node2 belongs into the larger one
    }

    public static void buildAdjacencyList(String parent, String child) {
        // when doing union, add the node to the adjacency set
        if (parent.equals(child)) return; // do not add to adjacency list
        graph[arrLoc.get(child)] = arrLoc.get(parent);

        HashSet<String> set;

        if(adjacencyList.containsKey(parent)) {
            set = adjacencyList.get(parent);
        } else {
            set = new HashSet<>();
        }
        set.add(child);
        adjacencyList.put(parent, set);
    }

    public static int findSize(String parent) {
        // Build the adjacency list for every parent
        // Do a BFS from parent to find the count of size of the graph
        Queue<String> q = new LinkedList();
        int counter = 0;
        q.offer(parent);
        while(!q.isEmpty()) {
            // loop and find all the children and add to the queue
          String node = q.poll();
          counter++;
          if(adjacencyList.containsKey(node))q.addAll(adjacencyList.get(node));

        }
        return counter;
    }

    /**
     * Find Op:
     * To find which component a particular element belongs to find the root of that component
     * by following the parent nodes until a self loop is reached(a node whose parent is itself)
     */
    public static int find(String node) {
        // loop until the node is the parent of itself
        int parent = arrLoc.get(node);
        while(graph[parent] != parent) {
            parent = graph[parent];
        }
        return parent;
    }

    public static void main(String[] args) {
        arrLoc.put("E", 0);
        revArrLoc.put(0, "E");

        arrLoc.put("F", 1);
        revArrLoc.put(1, "F");

        arrLoc.put("I", 2);
        revArrLoc.put(2,"I");

        arrLoc.put("D", 3);
        revArrLoc.put(3,"D");

        arrLoc.put("C", 4);
        revArrLoc.put(4,"C");

        arrLoc.put("A", 5);
        revArrLoc.put(5,"A");

        arrLoc.put("J", 6);
        revArrLoc.put(6,"J");

        arrLoc.put("L", 7);
        revArrLoc.put(7,"L");

        arrLoc.put("G", 8);
        revArrLoc.put(8,"G");

        arrLoc.put("K", 9);
        revArrLoc.put(9,"K");

        arrLoc.put("B", 10);
        revArrLoc.put(10,"B");

        arrLoc.put("H", 11);
        revArrLoc.put(11,"H");

        // init the array and make each element the parent of itself to startwith
        for(int i=0; i< graph.length; i++) {
           graph[i] = i;
        }
        Union("C", "K");
        Union("F", "E");
        Union("A", "J");
        Union("J", "B");
        Union("C", "D");
        Union("D", "I");
        Union("L", "F");
        Union("C", "J");
        Union("A", "B");
        Union("H", "G");
        Union("H", "F");
        Union("H", "B");

        // print the adjacency list after the union
        for (Map.Entry<String, HashSet<String>> entry: adjacencyList.entrySet()) {
            System.out.println(entry.getKey() +" -> " + entry.getValue());
        }
    }
}
