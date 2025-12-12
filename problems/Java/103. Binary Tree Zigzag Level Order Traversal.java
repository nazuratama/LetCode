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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean ldr = true;
        
        while (!q.isEmpty()) {
            int sz = q.size();
            LinkedList<Integer> lvl = new LinkedList<>();
            
            for (int i = 0; i < sz; i++) {
                TreeNode cur = q.poll();
                if (ldr) {
                    lvl.addLast(cur.val);
                } else {
                    lvl.addFirst(cur.val);
                }
                
                if (cur.left != null) q.add(cur.left);
                if (cur.right != null) q.add(cur.right);
            }
            res.add(lvl);
            ldr = !ldr;
        }
        return res;
    }
}