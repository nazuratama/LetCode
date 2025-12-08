# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def recoverTree(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        n1, n2, prev = None, None, None
        curr = root
        
        while curr:
            if not curr.left:
                if prev and prev.val > curr.val:
                    n2 = curr
                    if not n1:
                        n1 = prev
                prev = curr
                curr = curr.right
            else:
                pred = curr.left
                while pred.right and pred.right != curr:
                    pred = pred.right
                
                if not pred.right:
                    pred.right = curr
                    curr = curr.left
                else:
                    pred.right = None
                    if prev and prev.val > curr.val:
                        n2 = curr
                        if not n1:
                            n1 = prev
                    prev = curr
                    curr = curr.right
                    
        n1.val, n2.val = n2.val, n1.val