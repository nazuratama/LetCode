# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def zigzagLevelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root:
            return []
        
        res = []
        q = collections.deque([root])
        ldr = True
        
        while q:
            sz = len(q)
            lvl = collections.deque()
            for _ in range(sz):
                cur = q.popleft()
                if ldr:
                    lvl.append(cur.val)
                else:
                    lvl.appendleft(cur.val)
                
                if cur.left:
                    q.append(cur.left)
                if cur.right:
                    q.append(cur.right)
            
            res.append(list(lvl))
            ldr = not ldr
            
        return res