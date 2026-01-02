# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxPathSum(self, root: Optional[TreeNode]) -> int:
        self.mx = -float('inf')
        
        def dfs(n):
            if not n:
                return 0
            
            l = max(dfs(n.left), 0)
            r = max(dfs(n.right), 0)
            
            self.mx = max(self.mx, n.val + l + r)
            
            return n.val + max(l, r)
            
        dfs(root)
        return self.mx