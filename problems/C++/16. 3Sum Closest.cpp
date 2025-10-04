class Solution {
public:
    int threeSumClosest(vector<int>& nums, int target) {
        sort(nums.begin(), nums.end());
        int res = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.size() - 2; ++i) {
            int l = i + 1;
            int r = nums.size() - 1;
            while (l < r) {
                int csum = nums[i] + nums[l] + nums[r];
                if (abs(csum - target) < abs(res - target)) {
                    res = csum;
                }

                if (csum < target) {
                    l++;
                } else if (csum > target) {
                    r--;
                } else {
                    return csum;
                }
            }
        }
        return res;
    }
};