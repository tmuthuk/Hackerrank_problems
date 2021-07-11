package leetcode.trees;

/**
 *
 * LC Medium #236
 *
 * LCA Btree
 Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

 According to the definition of LCA on Wikipedia:
 “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants
 (where we allow a node to be a descendant of itself).”

 Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 Output: 3
 Explanation: The LCA of nodes 5 and 1 is 3.

 Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 Output: 5
 Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.

 Note: This solution will work even if the nodes p and/ or q are not in the tree
 */
public class LCA_BTree_1 {
    TreeNode result;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        find( root, p,q);
        return result;

    }

    boolean find(TreeNode currentNode, TreeNode p, TreeNode q) {
        if(currentNode == null) return false;

        int left = find(currentNode.left, p, q)? 1:0;
        int right = find(currentNode.right, p, q)? 1:0;
        int mid = (currentNode == p  || currentNode == q) ? 1:0;

        if (left + mid + right >=2) {
            this.result = currentNode;
        }

        return (left + right + mid) > 0;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);

        // Left:
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(7);
        TreeNode node5 = new TreeNode(4);
//===

        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        root.left = node1;

        // === RIght
        TreeNode node6 = new TreeNode(1);
        TreeNode node7 = new TreeNode(0);
        TreeNode node8 = new TreeNode(8);

        node6.left = node7;
        node6.right = node8;
        root.right = node6;

        LCA_BTree_1 lca_bTree_1 = new LCA_BTree_1();

        lca_bTree_1.lowestCommonAncestor(root, node1, node5);
    }
}
