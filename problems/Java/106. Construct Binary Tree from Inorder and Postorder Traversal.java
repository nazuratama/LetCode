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
    int pidx;
    int[] mp = new int[6001];

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        pidx = postorder.length - 1;
        for(int i = 0; i < inorder.length; i++) {
            mp[inorder[i] + 3000] = i;
        }
        return bld(postorder, 0, inorder.length - 1);
    }

    private TreeNode bld(int[] postorder, int l, int r) {
        if(l > r) return null;
        
        int val = postorder[pidx--];
        TreeNode node = new TreeNode(val);
        int mid = mp[val + 3000];
        
        node.right = bld(postorder, mid + 1, r);
        node.left = bld(postorder, l, mid - 1);
        return node;
    }
}