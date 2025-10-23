class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int msum = nums[0];
        int csum = nums[0];

        for (int i = 1; i < nums.size(); ++i) {
            int n = nums[i];
            csum = max(n, csum + n);
            msum = max(msum, csum);
        }
        
        return msum;
    }
};