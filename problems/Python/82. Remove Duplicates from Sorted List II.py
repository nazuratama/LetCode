# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def deleteDuplicates(self, head: Optional[ListNode]) -> Optional[ListNode]:
        dumm = ListNode(0, head)
        prev = dumm
        
        while prev.next and prev.next.next:
            if prev.next.val == prev.next.next.val:
                dup_val = prev.next.val
                while prev.next and prev.next.val == dup_val:
                    prev.next = prev.next.next
            else:
                prev = prev.next
                
        return dumm.next