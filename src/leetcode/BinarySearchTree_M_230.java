package leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree_M_230 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static List<Integer> list;

    public int kthSmallest(TreeNode root, int k) {
        list = new ArrayList<>();
        findTree(root);
        return list.get(k - 1);
    }

    public void findTree(TreeNode node) {
        if (node == null)
            return;
        findTree(node.left);
        list.add(node.val);
        findTree(node.right);
    }
}
