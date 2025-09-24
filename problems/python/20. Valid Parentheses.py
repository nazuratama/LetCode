class Solution:
    def isValid(self, s: str) -> bool:
        stk = []
        cmap = {")": "(", "}": "{", "]": "["}
        
        for c in s:
            if c in cmap:
                if not stk or stk.pop() != cmap[c]:
                    return False
            else:
                stk.append(c)
                
        return not stk