class Solution {
public:
    vector<vector<int>> combine(int n, int k) {
        vector<vector<int>> res;
        vector<int> path;
        bt(1, path, res, n, k);
        return res;
    }

private:
    void bt(int start, vector<int>& path, vector<vector<int>>& res, int n, int k) {
        if (path.size() == k) {
            res.push_back(path);
            return;
        }

        for (int i = start; i <= n; ++i) {
            path.push_back(i);
            bt(i + 1, path, res, n, k);
            path.pop_back();
        }
    }
};