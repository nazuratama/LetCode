# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        mp = {v: i for i, v in enumerate(inorder)}
        self.pidx = 0
        
        def bld(l, r):
            if l > r:
                return None
            
            val = preorder[self.pidx]
            self.pidx += 1
            node = TreeNode(val)
            mid = mp[val]
            
            node.left = bld(l, mid - 1)
            node.right = bld(mid + 1, r)
            return node
            
        return bld(0, len(inorder) - 1)