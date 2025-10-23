class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        msum = nums[0]
        csum = nums[0]
        
        for i in range(1, len(nums)):
            n = nums[i]
            csum = max(n, csum + n)
            msum = max(msum, csum)
            
        return msum