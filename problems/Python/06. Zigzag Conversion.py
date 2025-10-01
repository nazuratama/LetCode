class Solution:
    def convert(self, s: str, numRows: int) -> str:
        if numRows == 1 or numRows >= len(s):
            return s

        res = [""] * numRows
        row = 0
        down = False

        for c in s:
            res[row] += c
            if row == 0 or row == numRows - 1:
                down = not down
            
            if down:
                row += 1
            else:
                row -= 1
        
        return "".join(res)