class Solution {
public:
    bool isMatch(string s, string p) {
        cache.resize(s.length() + 1, vector<int>(p.length() + 1, -1));
        return dfs(0, 0, s, p);
    }

private:
    vector<vector<int>> cache;

    bool dfs(int i, int j, const string& s, const string& p) {
        if (cache[i][j] != -1) {
            return cache[i][j];
        }

        if (j == p.length()) {
            return i == s.length();
        }

        bool m = (i < s.length() && (p[j] == s[i] || p[j] == '.'));
        bool res;

        if (j + 1 < p.length() && p[j + 1] == '*') {
            res = dfs(i, j + 2, s, p) || (m && dfs(i + 1, j, s, p));
        } else if (m) {
            res = dfs(i + 1, j + 1, s, p);
        } else {
            res = false;
        }

        return cache[i][j] = res;
    }
};