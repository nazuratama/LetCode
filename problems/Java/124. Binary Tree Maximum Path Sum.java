/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int mx = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return mx;
    }

    private int dfs(TreeNode n) {
        if (n == null) return 0;

        int l = Math.max(0, dfs(n.left));
        int r = Math.max(0, dfs(n.right));

        mx = Math.max(mx, n.val + l + r);

        return n.val + Math.max(l, r);
    }
}