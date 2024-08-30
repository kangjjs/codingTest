package leetcode;

public class BinaryTree_E_104 {
    public int findAns(TreeNode node) {
        if (node == null)
            return 0;
        int left = findAns(node.left);
        int right = findAns(node.right);

        return Math.max(left, right) + 1;
    }

    public int maxDepth(TreeNode root) {
        return findAns(root);
    }
}
