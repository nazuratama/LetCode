class Solution:
    def maximalRectangle(self, matrix: List[List[str]]) -> int:
        if not matrix:
            return 0
        
        m, n = len(matrix), len(matrix[0])
        h = [0] * n
        area = 0
        
        for r in range(m):
            for c in range(n):
                if matrix[r][c] == '1':
                    h[c] += 1
                else:
                    h[c] = 0
            
            stk = []
            for i, val in enumerate(h + [0]):
                start = i
                while stk and stk[-1][1] > val:
                    idx, hgt = stk.pop()
                    area = max(area, hgt * (i - idx))
                    start = idx
                stk.append((start, val))
                
        return area