class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        int n = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            n++;
        }
        
        tail.next = head;

        k %= n;
        int steps = n - k;
        
        ListNode new_tail = tail;
        for (int i = 0; i < steps; i++) {
            new_tail = new_tail.next;
        }
        
        ListNode new_head = new_tail.next;
        new_tail.next = null;

        return new_head;
    }
}