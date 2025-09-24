# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        dumm = ListNode(0, head)
        l = dumm
        r = dumm

        for _ in range(n):
            r = r.next

        while r.next:
            l = l.next
            r = r.next
            
        l.next = l.next.next
        
        return dumm.next