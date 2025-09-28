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
    public ListNode swapPairs(ListNode head) {
        ListNode dumm = new ListNode(0, head);
        ListNode prev = dumm;

        while (prev.next != null && prev.next.next != null) {
            ListNode n1 = prev.next;
            ListNode n2 = n1.next;

            prev.next = n2;
            n1.next = n2.next;
            n2.next = n1;

            prev = n1;
        }
        return dumm.next;
    }
}