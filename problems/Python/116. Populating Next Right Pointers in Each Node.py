"""
# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""

class Solution:
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        l = root
        
        if not root:
            return None

        while l.left:
            h = l
            while h:
                h.left.next = h.right
                if h.next:
                    h.right.next = h.next.left
                h = h.next
            l = l.left
            
        return root
        
