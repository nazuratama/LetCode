class Solution {
public:
    int totalNQueens(int n) {
        unordered_set<int> cols;
        unordered_set<int> pdia;
        unordered_set<int> ndia;
        return bt(0, n, cols, pdia, ndia);
    }
private:
    int bt(int r, int n, unordered_set<int>& cols, unordered_set<int>& pdia, unordered_set<int>& ndia) {
        if (r == n) {
            return 1;
        }

        int cnt = 0;
        for (int c = 0; c < n; ++c) {
            if (cols.count(c) || pdia.count(r - c) || ndia.count(r + c)) {
                continue;
            }

            cols.insert(c);
            pdia.insert(r - c);
            ndia.insert(r + c);

            cnt += bt(r + 1, n, cols, pdia, ndia);

            cols.erase(c);
            pdia.erase(r - c);
            ndia.erase(r + c);
        }
        return cnt;
    }
};