# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        mp = {v: i for i, v in enumerate(inorder)}
        self.pidx = len(postorder) - 1
        
        def bld(l, r):
            if l > r:
                return None
            
            val = postorder[self.pidx]
            self.pidx -= 1
            node = TreeNode(val)
            mid = mp[val]
            
            node.right = bld(mid + 1, r)
            node.left = bld(l, mid - 1)
            return node
            
        return bld(0, len(inorder) - 1)