class Solution:
    def isNumber(self, s: str) -> bool:
        dig, dot, exp = False, False, False
        
        for i, c in enumerate(s):
            if c.isdigit():
                dig = True
            elif c in ['+', '-']:
                if i > 0 and s[i-1].lower() != 'e':
                    return False
            elif c == '.':
                if dot or exp:
                    return False
                dot = True
            elif c.lower() == 'e':
                if exp or not dig:
                    return False
                exp = True
                dig = False
            else:
                return False
                
        return dig