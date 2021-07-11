package leetcode.trees;

/**
 * LCA BST
 *
 * LC Easy #235
 *
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 *
 * According to the definition of LCA on Wikipedia:
 * “The lowest common ancestor is defined between two nodes p and q as the lowest node
 * in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 *
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * Output: 6
 * Explanation: The LCA of nodes 2 and 8 is 6.
 *
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * Output: 2
 * Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
 *
 * Input: root = [2,1], p = 2, q = 1
 * Output: 2
 */
public class LCA_BST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return findNodes(root, p, q);
    }

    public TreeNode findNodes(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return root;
        if (p.val < root.val && q.val < root.val) {
            return findNodes(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val) {
            return findNodes(root.right, p, q);
        } else {
            return root;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);

        // Left:
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(0);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
//===
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        root.left = node1;

        // === RIght
        TreeNode node6 = new TreeNode(8);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(9);
        node6.left = node7;
        node6.right = node8;
        root.right = node6;

        LCA_BST lca_bst = new LCA_BST();
        TreeNode retVal = lca_bst.lowestCommonAncestor(root, node1, node5);

        System.out.println("result: " + retVal.val);


    }
}
