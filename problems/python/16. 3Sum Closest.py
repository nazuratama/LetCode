class Solution:
    def threeSumClosest(self, nums: List[int], target: int) -> int:
        nums.sort()
        res = nums[0] + nums[1] + nums[2]

        for i in range(len(nums) - 2):
            l, r = i + 1, len(nums) - 1
            while l < r:
                csum = nums[i] + nums[l] + nums[r]
                
                if abs(csum - target) < abs(res - target):
                    res = csum
                
                if csum < target:
                    l += 1
                elif csum > target:
                    r -= 1
                else:
                    return csum
                    
        return res