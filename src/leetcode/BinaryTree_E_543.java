package leetcode;


public class BinaryTree_E_543 {
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

    public int ans = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        findAns(root);
        return ans;
    }

    int findAns(TreeNode node) {
        if (node == null)
            return 0;
        int left = findAns(node.left);
        int right = findAns(node.right);

        ans = Math.max(ans, left + right);

        return 1 + Math.max(left, right);
    }
}
