package leetcode.trees;

import leetcode.trees.TreeNode;

/**
 * Problem Description
 *
 * We are given the head node root of a binary tree, where additionally every node's value is either a 0 or a 1.
 *
 * Return the same tree where every subtree (of the given tree) not containing a 1 has been removed.
 *
 * (Recall that the subtree of a node X is X, plus every node that is a descendant of X.)

 * Example 1:
 * Input: [1,null,0,0,1]
 * Output: [1,null,0,null,1]
 *
 * Explanation:
 * Only the red nodes satisfy the property "every subtree not containing a 1".
 * The diagram on the right represents the answer.
 *
 *
 * Example 2:
 * Input: [1,0,1,0,0,0,1]
 * Output: [1,null,1,null,1]
 *
 *
 *
 * Example 3:
 * Input: [1,1,0,1,1,0,1,0]
 * Output: [1,1,0,1,1,null,1]
 *
 *
 * Note:
 *
 * The binary tree will have at most 100 nodes.
 * The value of each node will only be 0 or 1.
 *
 * Link: https://leetcode.com/problems/binary-tree-pruning/description/
 */

public class BTreePruning {
    public TreeNode pruneTree(TreeNode root) {
        root = pruneTreeNodes(root);
        return root;
    }

    private TreeNode pruneTreeNodes(TreeNode root) {
        // base case 1:
        if (root == null) {
            return null;
        }

        // recurse through left
        root.left = pruneTree(root.left);

        // recurse through right
        root.right = pruneTree(root.right);

        // if both left and right subteee are null and val = 0, return null
        if (root.left == null && root.right == null && root.val == 0) {
            return null;
        }
        else {
            // return the subtree in all other cases,
            // as there could be a subtree which has 1 in it
            return root;
        }
    }
}
