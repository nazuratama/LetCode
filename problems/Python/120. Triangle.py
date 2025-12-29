class Solution:
    def minimumTotal(self, tri: List[List[int]]) -> int:
        dp = tri[-1]
        n = len(tri)
        
        for i in range(n - 2, -1, -1):
            for j in range(len(tri[i])):
                dp[j] = tri[i][j] + min(dp[j], dp[j + 1])
                
        return dp[0]