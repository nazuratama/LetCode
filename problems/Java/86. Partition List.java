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
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode lh = new ListNode(0);
        ListNode lt = lh;
        ListNode gh = new ListNode(0);
        ListNode gt = gh;

        ListNode curr = head;
        while (curr != null) {
            if (curr.val < x) {
                lt.next = curr;
                lt = lt.next;
            } else {
                gt.next = curr;
                gt = gt.next;
            }
            curr = curr.next;
        }

        gt.next = null;
        lt.next = gh.next;

        return lh.next;
    }
}