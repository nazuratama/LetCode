# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def reverseKGroup(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        if k == 1:
            return head

        dumm = ListNode(0, head)
        gprv = dumm
        
        while True:
            kth = gprv
            for _ in range(k):
                kth = kth.next
                if not kth:
                    return dumm.next
            
            gnxt = kth.next
            
            prev, curr = gnxt, gprv.next
            while curr != gnxt:
                temp = curr.next
                curr.next = prev
                prev = curr
                curr = temp
            
            temp = gprv.next
            gprv.next = kth
            gprv = temp