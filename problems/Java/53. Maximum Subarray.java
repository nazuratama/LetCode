class Solution {
    public int maxSubArray(int[] nums) {
        int msum = nums[0];
        int csum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int n = nums[i];
            csum = Math.max(n, csum + n);
            msum = Math.max(msum, csum);
        }
        
        return msum;
    }
}