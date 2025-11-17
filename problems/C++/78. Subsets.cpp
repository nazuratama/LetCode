class Solution {
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<vector<int>> res;
        vector<int> path;
        bt(0, path, nums, res);
        return res;
    }

private:
    void bt(int start, vector<int>& path, vector<int>& nums, vector<vector<int>>& res) {
        res.push_back(path);
        for (int i = start; i < nums.size(); ++i) {
            path.push_back(nums[i]);
            bt(i + 1, path, nums, res);
            path.pop_back();
        }
    }
};