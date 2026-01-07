# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        def dfs(n, cur):
            if not n:
                return 0
            
            cur = cur * 10 + n.val
            
            if not n.left and not n.right:
                return cur
            
            return dfs(n.left, cur) + dfs(n.right, cur)
            
        return dfs(root, 0)