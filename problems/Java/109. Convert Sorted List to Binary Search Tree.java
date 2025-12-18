/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    private ListNode curr;

    public TreeNode sortedListToBST(ListNode head) {
        int n = 0;
        ListNode temp = head;
        while(temp != null) {
            n++;
            temp = temp.next;
        }
        
        curr = head;
        return bld(0, n - 1);
    }

    private TreeNode bld(int l, int r) {
        if (l > r) return null;
        
        int mid = l + (r - l) / 2;
        
        TreeNode left = bld(l, mid - 1);
        
        TreeNode node = new TreeNode(curr.val);
        node.left = left;
        curr = curr.next;
        
        node.right = bld(mid + 1, r);
        
        return node;
    }
}