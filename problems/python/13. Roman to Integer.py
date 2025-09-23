class Solution:
    def romanToInt(self, s: str) -> int:
        rmap = {'I': 1, 'V': 5, 'X': 10, 'L': 50, 'C': 100, 'D': 500, 'M': 1000}
        res = 0
        prev = 0
        
        for c in reversed(s):
            val = rmap[c]
            if val < prev:
                res -= val
            else:
                res += val
            prev = val
            
        return res