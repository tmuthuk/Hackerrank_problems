package leetcode.trees;

import leetcode.TreeNode;

/**
 * LC Easy #226
 *
 * Given the root of a binary tree, invert the tree, and return its root.
 *
 * Input: root = [4,2,7,1,3,6,9]
 * Output: [4,7,2,9,6,3,1]
 *
 * Input: root = [2,1,3]
 * Output: [2,3,1]
 *
 * Input: root = []
 * Output: []
 */
public class InvertBinaryTree {
    TreeNode rootNode;
    public TreeNode invertTree(TreeNode root) {
        rootNode  = root;
        invert(rootNode);
        return rootNode;
    }

    public void invert(TreeNode node) {
        if(node == null || (node.left == null && node.right == null)) return;
        // System.out.println("val. " + node.val);
        invert(node.left);
        invert(node.right);

        // swap
        // System.out.println("swapping " + node.left.val + " and " +node.right.val );
        TreeNode swap = node.left;
        node.left = node.right;
        node.right = swap;
    }
}
