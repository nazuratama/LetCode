class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                board[i][j] = '.';
        
        bt(0, n, new HashSet<>(), new HashSet<>(), new HashSet<>(), board, res);
        return res;
    }

    private void bt(int r, int n, Set<Integer> cols, Set<Integer> pdia, Set<Integer> ndia, char[][] board, List<List<String>> res) {
        if (r == n) {
            List<String> copy = new ArrayList<>();
            for (char[] row : board) {
                copy.add(new String(row));
            }
            res.add(copy);
            return;
        }

        for (int c = 0; c < n; c++) {
            if (cols.contains(c) || pdia.contains(r - c) || ndia.contains(r + c)) {
                continue;
            }

            cols.add(c);
            pdia.add(r - c);
            ndia.add(r + c);
            board[r][c] = 'Q';

            bt(r + 1, n, cols, pdia, ndia, board, res);
            
            cols.remove(c);
            pdia.remove(r - c);
            ndia.remove(r + c);
            board[r][c] = '.';
        }
    }
}