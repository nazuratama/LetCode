class Solution:
    def numDecodings(self, s: str) -> int:
        if s[0] == '0':
            return 0
        
        two, one = 1, 1
        
        for i in range(1, len(s)):
            curr = 0
            if s[i] != '0':
                curr += one
            
            if s[i-1] == '1' or (s[i-1] == '2' and '0' <= s[i] <= '6'):
                curr += two
                
            two = one
            one = curr
            
        return one
