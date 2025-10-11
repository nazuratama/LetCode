class Solution {
public:
    int firstMissingPositive(vector<int>& nums) {
        int n = nums.size();
        int i = 0;
        while (i < n) {
            long long j_long = (long long)nums[i] - 1;
            if (j_long >= 0 && j_long < n && nums[i] != nums[j_long]) {
                swap(nums[i], nums[j_long]);
            } else {
                i++;
            }
        }

        for (i = 0; i < n; ++i) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }
};