# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sortedListToBST(self, head: Optional[ListNode]) -> Optional[TreeNode]:
        n = 0
        curr = head
        while curr:
            n += 1
            curr = curr.next
            
        self.curr = head
        
        def bld(l, r):
            if l > r:
                return None
            
            mid = (l + r) // 2
            
            left = bld(l, mid - 1)
            
            node = TreeNode(self.curr.val)
            node.left = left
            self.curr = self.curr.next
            
            node.right = bld(mid + 1, r)
            
            return node
            
        return bld(0, n - 1)