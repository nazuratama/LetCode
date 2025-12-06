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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        List<ListNode> temp = new ArrayList<>();
        for (ListNode node : lists) {
            temp.add(node);
        }

        while (temp.size() > 1) {
            List<ListNode> mres = new ArrayList<>();
            for (int i = 0; i < temp.size(); i += 2) {
                ListNode l1 = temp.get(i);
                ListNode l2 = (i + 1 < temp.size()) ? temp.get(i + 1) : null;
                mres.add(m2l(l1, l2));
            }
            temp = mres;
        }
        return temp.get(0);
    }

    private ListNode m2l(ListNode l1, ListNode l2) {
        ListNode dumm = new ListNode(0);
        ListNode curr = dumm;
        
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        curr.next = (l1 != null) ? l1 : l2;
        return dumm.next;
    }
}