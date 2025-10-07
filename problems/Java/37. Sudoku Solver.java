class Solution {
    boolean[][] rows = new boolean[9][9];
    boolean[][] cols = new boolean[9][9];
    boolean[][] boxs = new boolean[9][9];
    
    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    rows[i][num] = true;
                    cols[j][num] = true;
                    boxs[i/3*3+j/3][num] = true;
                }
            }
        }
        back(board, 0, 0);
    }
    
    boolean back(char[][] board, int i, int j) {
        if (i == 9) return true;
        if (j == 9) return back(board, i+1, 0);
        if (board[i][j] != '.') return back(board, i, j+1);
        
        int box = i/3*3+j/3;
        for (int num = 0; num < 9; num++) {
            if (!rows[i][num] && !cols[j][num] && !boxs[box][num]) {
                board[i][j] = (char)(num + '1');
                rows[i][num] = true;
                cols[j][num] = true;
                boxs[box][num] = true;
                if (back(board, i, j+1)) return true;
                rows[i][num] = false;
                cols[j][num] = false;
                boxs[box][num] = false;
                board[i][j] = '.';
            }
        }
        return false;
    }
}