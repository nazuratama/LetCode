class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        
        int res = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int csum = nums[i] + nums[l] + nums[r];
                if (Math.abs(csum - target) < Math.abs(res - target)) {
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
}