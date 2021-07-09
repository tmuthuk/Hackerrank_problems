package leetcode.trees;

/** LC Easy #938
 * Given the root node of a binary search tree and two integers low and high, return the sum of values of all nodes with a value in the inclusive range [low, high].
 *
 * Input: root = [10,5,15,3,7,null,18], low = 7, high = 15
 * Output: 32
 * Explanation: Nodes 7, 10, and 15 are in the range [7, 15]. 7 + 10 + 15 = 32.
 *
 * Input: root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
 * Output: 23
 * Explanation: Nodes 6, 7, and 10 are in the range [6, 10]. 6 + 7 + 10 = 23.
 */
public class BSTRangeSum {

    int sum = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        add(root, low, high);
        return sum;
    }

    public void add(TreeNode node, int low, int high) {
        if(node == null) return;

        add(node.left,  low, high);
        add(node.right, low, high);

        if(node.val>= low && node.val <= high) {
            sum += node.val;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);

        // Left:
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(7);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(6);
//===

        node2.left = node4;
        node3.left = node5;
        node1.left = node2;
        node1.right = node3;
        root.left = node1;

        // === RIght
        TreeNode node6 = new TreeNode(15);
        TreeNode node7 = new TreeNode(13);
        TreeNode node8 = new TreeNode(18);

        node6.left = node7;
        node6.right = node8;

        root.right = node6;

        BSTRangeSum bst = new BSTRangeSum();

        bst.rangeSumBST(root, 5, 10);
    }
}
