package leetcode;

public class BinarySearchTree_M_235 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode current = root;

        while (current != null) {
            if (p.val > current.val && q.val > current.val){
                current = current.right;
            }else if(p.val < current.val && q.val < current.val){
                current = current.left;
            }else{
                return current;
            }
        }

        return null;
    }
}
