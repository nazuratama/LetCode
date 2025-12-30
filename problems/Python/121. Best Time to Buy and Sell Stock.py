class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        minp = float('inf')
        maxp = 0
        
        for p in prices:
            if p < minp:
                minp = p
            elif p - minp > maxp:
                maxp = p - minp
                
        return maxp