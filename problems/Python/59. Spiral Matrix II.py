class Solution:
    def generateMatrix(self, n: int) -> List[List[int]]:
        mat = [[0] * n for _ in range(n)]
        l, r = 0, n - 1
        t, b = 0, n - 1
        num = 1
        
        while l <= r and t <= b:
            for i in range(l, r + 1):
                mat[t][i] = num
                num += 1
            t += 1
            
            for i in range(t, b + 1):
                mat[i][r] = num
                num += 1
            r -= 1
            
            for i in range(r, l - 1, -1):
                mat[b][i] = num
                num += 1
            b -= 1
            
            for i in range(b, t - 1, -1):
                mat[i][l] = num
                num += 1
            l += 1
            
        return mat