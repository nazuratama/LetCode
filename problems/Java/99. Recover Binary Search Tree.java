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
    public void recoverTree(TreeNode root) {
        TreeNode n1 = null, n2 = null, prev = null;
        TreeNode curr = root;

        while (curr != null) {
            if (curr.left == null) {
                if (prev != null && prev.val > curr.val) {
                    n2 = curr;
                    if (n1 == null) n1 = prev;
                }
                prev = curr;
                curr = curr.right;
            } else {
                TreeNode pred = curr.left;
                while (pred.right != null && pred.right != curr) {
                    pred = pred.right;
                }

                if (pred.right == null) {
                    pred.right = curr;
                    curr = curr.left;
                } else {
                    pred.right = null;
                    if (prev != null && prev.val > curr.val) {
                        n2 = curr;
                        if (n1 == null) n1 = prev;
                    }
                    prev = curr;
                    curr = curr.right;
                }
            }
        }
        int temp = n1.val;
        n1.val = n2.val;
        n2.val = temp;
    }
}