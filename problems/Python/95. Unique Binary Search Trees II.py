# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def generateTrees(self, n: int) -> List[Optional[TreeNode]]:
        memo = {}
        def gen(start, end):
            if start > end:
                return [None]
            if (start, end) in memo:
                return memo[(start, end)]
            
            res = []
            for i in range(start, end + 1):
                lefts = gen(start, i - 1)
                rights = gen(i + 1, end)
                for l_node in lefts:
                    for r_node in rights:
                        root = TreeNode(i, l_node, r_node)
                        res.append(root)
            
            memo[(start, end)] = res
            return res

        return gen(1, n) if n > 0 else []