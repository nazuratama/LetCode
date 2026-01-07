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
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode n, int cur) {
        if (n == null) return 0;
        
        cur = cur * 10 + n.val;
        
        if (n.left == null && n.right == null) {
            return cur;
        }
        
        return dfs(n.left, cur) + dfs(n.right, cur);
    }
}