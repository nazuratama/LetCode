class Solution:
    def myAtoi(self, s: str) -> int:
        imax = 2**31 - 1
        imin = -2**31
        
        i = 0
        n = len(s)
        
        while i < n and s[i] == ' ':
            i += 1
            
        sgn = 1
        if i < n:
            if s[i] == '+':
                i += 1
            elif s[i] == '-':
                sgn = -1
                i += 1
                
        res = 0
        while i < n and s[i].isdigit():
            dig = int(s[i])
            
            if res > imax // 10 or (res == imax // 10 and dig > 7):
                return imax if sgn == 1 else imin
            
            res = res * 10 + dig
            i += 1
            
        return sgn * res