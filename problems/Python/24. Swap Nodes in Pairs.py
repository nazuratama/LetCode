# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def swapPairs(self, head: Optional[ListNode]) -> Optional[ListNode]:
        dumm = ListNode(0, head)
        prev = dumm

        while prev.next and prev.next.next:
            n1 = prev.next
            n2 = n1.next

            prev.next = n2
            n1.next = n2.next
            n2.next = n1

            prev = n1
            
        return dumm.next