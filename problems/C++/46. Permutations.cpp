class Solution {
public:
    vector<vector<int>> permute(vector<int>& nums) {
        vector<vector<int>> res;
        vector<int> path;
        vector<bool> used(nums.size(), false);
        bt(res, path, nums, used);
        return res;
    }

private:
    void bt(vector<vector<int>>& res, vector<int>& path, vector<int>& nums, vector<bool>& used) {
        if (path.size() == nums.size()) {
            res.push_back(path);
            return;
        }

        for (int i = 0; i < nums.size(); ++i) {
            if (!used[i]) {
                used[i] = true;
                path.push_back(nums[i]);
                bt(res, path, nums, used);
                path.pop_back();
                used[i] = false;
            }
        }
    }
};