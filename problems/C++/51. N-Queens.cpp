class Solution {
public:
    vector<vector<string>> solveNQueens(int n) {
        vector<vector<string>> res;
        vector<string> board(n, string(n, '.'));
        unordered_set<int> cols;
        unordered_set<int> pdia;
        unordered_set<int> ndia;
        bt(0, n, cols, pdia, ndia, board, res);
        return res;
    }

private:
    void bt(int r, int n, unordered_set<int>& cols, unordered_set<int>& pdia, unordered_set<int>& ndia, vector<string>& board, vector<vector<string>>& res) {
        if (r == n) {
            res.push_back(board);
            return;
        }

        for (int c = 0; c < n; ++c) {
            if (cols.count(c) || pdia.count(r - c) || ndia.count(r + c)) {
                continue;
            }

            cols.insert(c);
            pdia.insert(r - c);
            ndia.insert(r + c);
            board[r][c] = 'Q';

            bt(r + 1, n, cols, pdia, ndia, board, res);
            
            cols.erase(c);
            pdia.erase(r - c);
            ndia.erase(r + c);
            board[r][c] = '.';
        }
    }
};