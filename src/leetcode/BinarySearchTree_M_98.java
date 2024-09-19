package leetcode;

public class BinarySearchTree_M_98 {
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

    public boolean isValidBST(TreeNode root) {
        return checkBst(root,null,null);
    }

    public boolean checkBst(TreeNode node, Integer low, Integer high) {
        if (node == null)
            return true;
        if (low != null && node.val <= low)
            return false;
        if (high != null && node.val >= high)
            return false;

        return checkBst(node.left,low,node.val) && checkBst(node.right,node.val,high);
    }
}
