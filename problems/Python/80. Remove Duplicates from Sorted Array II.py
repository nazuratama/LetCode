class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        j = 0
        for n in nums:
            if j < 2 or n > nums[j - 2]:
                nums[j] = n
                j += 1
        return j