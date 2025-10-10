class Solution {
public:
    vector<vector<int>> combinationSum2(vector<int>& candidates, int target) {
        sort(candidates.begin(), candidates.end());
        vector<vector<int>> res;
        vector<int> path;
        bt(candidates, target, path, 0, res);
        return res;
    }

private:
    void bt(vector<int>& candidates, int rem, vector<int>& path, int start, vector<vector<int>>& res) {
        if (rem == 0) {
            res.push_back(path);
            return;
        }
        if (rem < 0) {
            return;
        }

        for (int i = start; i < candidates.size(); ++i) {
            if (i > start && candidates[i] == candidates[i-1]) {
                continue;
            }
            path.push_back(candidates[i]);
            bt(candidates, rem - candidates[i], path, i + 1, res);
            path.pop_back();
        }
    }
};