class Solution:
    def solveSudoku(self, board: List[List[str]]) -> None:
        rows = [set() for _ in range(9)]
        cols = [set() for _ in range(9)]
        boxs = [set() for _ in range(9)]
        
        empt = []
        for i in range(9):
            for j in range(9):
                if board[i][j] != '.':
                    num = board[i][j]
                    rows[i].add(num)
                    cols[j].add(num)
                    boxs[i//3*3+j//3].add(num)
                else:
                    empt.append((i, j))
        
        def back(idx):
            if idx == len(empt):
                return True
            i, j = empt[idx]
            box = i//3*3+j//3
            for num in '123456789':
                if num not in rows[i] and num not in cols[j] and num not in boxs[box]:
                    board[i][j] = num
                    rows[i].add(num)
                    cols[j].add(num)
                    boxs[box].add(num)
                    if back(idx+1):
                        return True
                    rows[i].remove(num)
                    cols[j].remove(num)
                    boxs[box].remove(num)
                    board[i][j] = '.'
            return False
        
        back(0)