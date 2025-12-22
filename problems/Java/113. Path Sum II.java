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
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> pth = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return res;
    }

    private void dfs(TreeNode n, int rem) {
        if (n == null) return;

        pth.add(n.val);

        if (n.left == null && n.right == null && n.val == rem) {
            res.add(new ArrayList<>(pth));
        } else {
            dfs(n.left, rem - n.val);
            dfs(n.right, rem - n.val);
        }

        pth.remove(pth.size() - 1);
    }
}