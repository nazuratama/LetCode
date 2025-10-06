class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        vector<unordered_set<char>> rows(9);
        vector<unordered_set<char>> cols(9);
        vector<unordered_set<char>> boxs(9);

        for (int r = 0; r < 9; ++r) {
            for (int c = 0; c < 9; ++c) {
                char val = board[r][c];
                if (val == '.') {
                    continue;
                }

                int b_idx = (r / 3) * 3 + (c / 3);
                
                if (rows[r].count(val) || cols[c].count(val) || boxs[b_idx].count(val)) {
                    return false;
                }
                
                rows[r].insert(val);
                cols[c].insert(val);
                boxs[b_idx].insert(val);
            }
        }
        return true;
    }
};