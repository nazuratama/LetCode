class Solution:
    def setZeroes(self, matrix: List[List[int]]) -> None:
        m, n = len(matrix), len(matrix[0])
        c0z = False
        
        for r in range(m):
            if matrix[r][0] == 0:
                c0z = True
            for c in range(1, n):
                if matrix[r][c] == 0:
                    matrix[r][0] = 0
                    matrix[0][c] = 0
        
        for r in range(m - 1, -1, -1):
            for c in range(n - 1, 0, -1):
                if matrix[r][0] == 0 or matrix[0][c] == 0:
                    matrix[r][c] = 0
            if c0z:
                matrix[r][0] = 0