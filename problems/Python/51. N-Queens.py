class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        res = []
        cols = set()
        pdia = set()
        ndia = set()
        
        board = [['.'] * n for _ in range(n)]

        def bt(r):
            if r == n:
                copy = ["".join(row) for row in board]
                res.append(copy)
                return

            for c in range(n):
                if c in cols or (r - c) in pdia or (r + c) in ndia:
                    continue
                
                cols.add(c)
                pdia.add(r - c)
                ndia.add(r + c)
                board[r][c] = 'Q'
                
                bt(r + 1)
                
                cols.remove(c)
                pdia.remove(r - c)
                ndia.remove(r + c)
                board[r][c] = '.'

        bt(0)
        return res