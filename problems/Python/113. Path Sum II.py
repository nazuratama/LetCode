# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        res, pth = [], []
        
        def dfs(n, rem):
            if not n:
                return
            
            pth.append(n.val)
            
            if not n.left and not n.right and n.val == rem:
                res.append(list(pth))
            else:
                dfs(n.left, rem - n.val)
                dfs(n.right, rem - n.val)
                
            pth.pop()
            
        dfs(root, targetSum)
        return res