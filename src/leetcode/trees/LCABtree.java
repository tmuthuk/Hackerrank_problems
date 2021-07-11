package leetcode.trees;

import java.util.*;

/**
 * LC Medium #1650
 * Given two nodes of a binary tree p and q, return their lowest common ancestor (LCA).
 *
 * Each node will have a reference to its parent node. The definition for Node is below:
 *
 * class Node {
 *     public int val;
 *     public Node left;
 *     public Node right;
 *     public Node parent;
 * }
 * According to the definition of LCA on Wikipedia:
 * "The lowest common ancestor of two nodes p and q in a tree T is the lowest node that has both p and q as descendants
 * (where we allow a node to be a descendant of itself)."
 *
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * Output: 3
 * Explanation: The LCA of nodes 5 and 1 is 3.
 *
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * Output: 5
 * Explanation: The LCA of nodes 5 and 4 is 5 since a node can be a descendant of itself according to the LCA definition.
 */
public class LCABtree {
    public Node lowestCommonAncestor(Node p, Node q) {
        // Store the path from p to root

        Set<Node> path = new HashSet<>();
        while(p != null){
            path.add(p);
            p = p.parent;
        }

        int counter = 0;
        while(q.parent != null) {
            if(path.contains(q))
                return q;
            q = q.parent;
        }
        System.out.println("path " + path);
        return q;
    }
}
