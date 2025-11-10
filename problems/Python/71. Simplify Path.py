class Solution:
    def simplifyPath(self, path: str) -> str:
        stk = []
        for comp in path.split('/'):
            if comp == '..':
                if stk:
                    stk.pop()
            elif comp and comp != '.':
                stk.append(comp)
        
        return '/' + '/'.join(stk)