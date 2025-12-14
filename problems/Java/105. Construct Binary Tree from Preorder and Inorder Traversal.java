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
    int pidx = 0;
    int[] mp = new int[6001];

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i < inorder.length; i++) {
            mp[inorder[i] + 3000] = i;
        }
        return bld(preorder, 0, inorder.length - 1);
    }

    private TreeNode bld(int[] preorder, int l, int r) {
        if(l > r) return null;
        
        int val = preorder[pidx++];
        TreeNode node = new TreeNode(val);
        int mid = mp[val + 3000];
        
        node.left = bld(preorder, l, mid - 1);
        node.right = bld(preorder, mid + 1, r);
        return node;
    }
}