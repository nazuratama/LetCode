class Solution:
    def totalNQueens(self, n: int) -> int:
        cols = set()
        pdia = set()
        ndia = set()

        def bt(r):
            if r == n:
                return 1
            
            cnt = 0
            for c in range(n):
                if c in cols or (r - c) in pdia or (r + c) in ndia:
                    continue
                
                cols.add(c)
                pdia.add(r - c)
                ndia.add(r + c)
                
                cnt += bt(r + 1)
                
                cols.remove(c)
                pdia.remove(r - c)
                ndia.remove(r + c)
            return cnt

        return bt(0)