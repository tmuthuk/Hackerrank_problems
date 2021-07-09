package leetcode.trees;

import java.util.ArrayList;
import java.util.List;

/**
 * LC easy #94
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 *
 * Input: root = [1,null,2,3]
 * Output: [1,3,2]
 */
public class BTreeInorderTraversal {
    List<Integer> list = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        traverse(root);
        return list;
    }

    public void traverse(TreeNode node) {
        if(node == null) return;
        System.out.println("curr node " + node.val);
        traverse(node.left);
        list.add(node.val);
        traverse(node.right);

    }
}
