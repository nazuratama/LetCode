# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def partition(self, head: Optional[ListNode], x: int) -> Optional[ListNode]:
        lh = ListNode()
        lt = lh
        gh = ListNode()
        gt = gh
        
        curr = head
        while curr:
            if curr.val < x:
                lt.next = curr
                lt = lt.next
            else:
                gt.next = curr
                gt = gt.next
            curr = curr.next
            
        gt.next = None
        lt.next = gh.next
        
        return lh.next