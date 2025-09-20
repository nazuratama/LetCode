class Solution:
    def reverse(self, x: int) -> int:
        sgn = -1 if x < 0 else 1
        x = abs(x)
        
        rev = 0
        while x != 0:
            dig = x % 10
            rev = rev * 10 + dig
            x //= 10
            
        res = sgn * rev
        
        if not -2**31 <= res <= 2**31 - 1:
            return 0
        
        return res