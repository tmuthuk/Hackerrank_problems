package leetcode;

import leetcode.trees.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Problem Description
 * Consider all the leaves of a binary tree.  From left to right order, the values of those leaves form a leaf value sequence.
 * For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).
 * Two binary trees are considered leaf-similar if their leaf value sequence is the same.
 * Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.
 *
 * Note:
 * Both of the given trees will have between 1 and 100 nodes.
 */



public class LeafSimilarTrees {
    private List<Integer> root1Leaves = new LinkedList<>();
    private List<Integer> root2Leaves = new LinkedList<>();

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        // Approach:
        // Recurse down to left get the value, go back up, go to right, go all the
        // way down, get the value and go back up

        findLeaf(root1, root1Leaves);
        findLeaf(root2, root2Leaves);

        // now compare two lists size
        if (root1Leaves.size() != root2Leaves.size()) return false;

        // now compare element by element
        for(int i=0; i<root1Leaves.size(); i++) {
            if (root1Leaves.get(i) != root2Leaves.get(i))
                return false;
        }
        return true;
    }

    private void findLeaf(TreeNode root, List<Integer> leavesList) {
        // base case 1: When root doesn't have a leaf on right or left side
        if (root == null) return;

        // base case 2 - if it's a leaf add it to the respective list
        if (root.left == null && root.right == null) {
            System.out.println("leaf "+ root.val);
            leavesList.add(root.val);
            return;
        }

        // recurseLeft
        findLeaf(root.left, leavesList);

        // recurseRight
        findLeaf(root.right, leavesList);
    }
}
